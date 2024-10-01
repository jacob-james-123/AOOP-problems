package tasks.task6.t1;
import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private Deque<String> history;
    private Deque<String> forwardStack;

    public BrowserHistory() {
        history = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
    }

    // Add a new page to the history
    public void visitPage(String page) {
        history.push(page);
        forwardStack.clear();  // Clear forward stack when a new page is visited
        System.out.println("Visited: " + page);
    }

    // Go back to the previous page
    public void goBack() {
        if (!history.isEmpty()) {
            String lastPage = history.pop();
            forwardStack.push(lastPage);
            System.out.println("Going back to: " + history.peek());
        } else {
            System.out.println("No previous page to go back to.");
        }
    }

    // Go forward to the next page
    public void goForward() {
        if (!forwardStack.isEmpty()) {
            String nextPage = forwardStack.pop();
            history.push(nextPage);
            System.out.println("Going forward to: " + nextPage);
        } else {
            System.out.println("No forward page to go to.");
        }
    }

    // Display the current page
    public void displayCurrentPage() {
        if (!history.isEmpty()) {
            System.out.println("Current page: " + history.peek());
        } else {
            System.out.println("No pages in history.");
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        browser.visitPage("Page 1");
        browser.visitPage("Page 2");
        browser.visitPage("Page 3");
        browser.displayCurrentPage();
        browser.goBack();
        browser.goForward();
    }
}

