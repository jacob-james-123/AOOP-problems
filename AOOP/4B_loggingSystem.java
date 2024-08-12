import java.util.*;
//client 
public class loggingSystem{
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Create commands
        Command infoCommand = new LogCommand(LogLevel.INFO, "This is an info message.");
     Command debugCommand = new LogCommand(LogLevel.DEBUG, "This is a debug message.");
     Command errorCommand = new LogCommand(LogLevel.ERROR, "This is an error message.");

        // Add commands to the logger
        logger.addcommands(infoCommand);
        logger.addcommands(debugCommand);
        logger.addcommands(errorCommand);

        // Process commands
        logger.processCommands();
    }
}
enum LogLevel{
    INFO,DEBUG,ERROR
}
//command 
interface Command{
    void execute();
}
// concrete class
class LogCommand implements Command{
    private LogLevel logLevel;
    private String message;

    public LogCommand(LogLevel ll, String message){
        this.logLevel = ll;
        this.message = message;
    }

    public  void execute(){
        Logger.getInstance().log(message,logLevel);
    }
}
//common handler we can also write an interface instead of abstract class
abstract class LogHandler {
    public LogHandler nextHandler;

    public void setNextHandler(LogHandler nexHandler){
        this.nextHandler = nexHandler;
    }

    public void handle(LogLevel level ,String message){
        if(nextHandler != null){
            nextHandler.handle(level,message);
        }
    }
}
//chain of responsibility
//concrete handlers
class Infohandler extends LogHandler{
    public void handle(LogLevel level ,String message){
        if(level== LogLevel.INFO){
            System.out.println("INFO: " + message);
        }else{
            super.handle(level, message);
        }
    }
} 

class DebugHandler extends LogHandler{
    public void handle(LogLevel level ,String message){
        if(level== LogLevel.DEBUG){
            System.out.println("DEBUG: " + message);
        }else{
            super.handle(level, message);
        }
    }
} 

class ErrorHandler extends LogHandler{
    public void handle(LogLevel level ,String message){
        if(level== LogLevel.ERROR){
            System.out.println("ERROR   : " + message);
        }else{
            super.handle(level, message);
        }
    }
}

//invoker of command and setting of chain
class Logger{
    private static Logger instance;
    private LogHandler chain;
    private ArrayList<Command> commands;

    private Logger(){
        commands = new ArrayList<>();

        LogHandler Infohandler = new Infohandler();
        LogHandler ErrorHandler = new ErrorHandler();
        LogHandler DebugHandler = new DebugHandler();

        Infohandler.nextHandler = DebugHandler;
        DebugHandler.nextHandler = ErrorHandler;
        this.chain = Infohandler;
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message,LogLevel level){
        chain.handle(level, message);
    }

    public void addcommands(Command command){
        commands.add(command);
    }

    public void processCommands(){
        Iterator<Command> i = commands.iterator();
        while(i.hasNext()){
            i.next().execute();
        }
    }
}
