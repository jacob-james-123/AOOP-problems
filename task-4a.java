package tasks.task4;
import java.util.*;
public class t1 {
   
        public static void main(String[] args) {
            // Set up chain of handlers
            LogHandler infoHandler = new InfoHandler();
            LogHandler debugHandler = new DebugHandler();
            LogHandler errorHandler = new ErrorHandler();
    
            infoHandler.setNextHandler(debugHandler);
            debugHandler.setNextHandler(errorHandler);
    
            // Create a LogCommand with the chain of handlers
            LogCommand logCommand = new LogCommand(infoHandler);
    
            // Create a Logger to manage and process commands
            Logger logger = new Logger();
            logger.addCommand(logCommand);
    
            // Process some log messages
            logger.processCommands("System is starting up", LogLevel.INFO);
            logger.processCommands("System is in debug mode", LogLevel.DEBUG);
            logger.processCommands("System encountered an error", LogLevel.ERROR);
        }
    }
    

 enum LogLevel {
    INFO, DEBUG, ERROR;
}
 interface Command {
    void execute(String message, LogLevel level);
}
class LogCommand implements Command {
    private LogHandler handlerChain;

    public LogCommand(LogHandler handlerChain) {
        this.handlerChain = handlerChain;
    }

    @Override
    public void execute(String message, LogLevel level) {
        handlerChain.handleRequest(message, level);
    }
}
 abstract class LogHandler {
    protected LogHandler nextHandler;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(String message, LogLevel level) {
        if (canHandle(level)) {
            log(message);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(message, level);
        }
    }

    protected abstract boolean canHandle(LogLevel level);
    protected abstract void log(String message);
}

 class InfoHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.INFO;
    }

    @Override
    protected void log(String message) {
        System.out.println("INFO: " + message);
    }
}
 class DebugHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }

    @Override
    protected void log(String message) {
        System.out.println("DEBUG: " + message);
    }
}
 class ErrorHandler extends LogHandler {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void log(String message) {
        System.out.println("ERROR: " + message);
    }
}
 class Logger {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void processCommands(String message, LogLevel level) {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            iterator.next().execute(message, level);
        }
    }
}
