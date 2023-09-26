import java.util.ArrayList;
import java.util.Scanner;

public interface Task {
    Scanner sc = new Scanner(System.in);
    ArrayList readInputData();
    void executeTask();
}
