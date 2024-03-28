import java.util.Scanner;

public class Main {
  private DFA automaton;
  private Scanner input;

  public Main() {
    this.automaton = new DFA();
    this.input = new Scanner(System.in);
  }

  public void execute() {
    System.out
        .println("States separated by spaces (should start with q and have a number after.For example: q0 q1 q2 q3) ");
    automaton.setStates(input.nextLine().split(" "));

    System.out.println("Alphabet separated by spaces (For example: a b c)");
    automaton.setAlphabet(input.nextLine().split(" "));

    System.out.println("Transitions as tuples separated by spaces - For example: (q0 asdfasdfasdfa b c)");
    System.out.println("Transitions as tuples separated by spaces - For example: (q0 asdfasdfasdfa b c)");

    System.out
        .println(
            "Acceptance states separated by spaces (should start with q and have a number after. For example: q0 q3) ");
    automaton.setAcceptanceStates(input.nextLine().split(" "));

    input.close();
  }
}
