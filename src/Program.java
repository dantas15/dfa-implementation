import java.util.Scanner;

public class Program {
  private DFA automaton;
  private Scanner input;

  public Program() {
    this.automaton = new DFA();
    this.input = new Scanner(System.in);
  }

  public void execute() {
    System.out
        .println(
            "\nStates separated by spaces (should start with q and have a number after. For example: q0 q1 q2 q3): ");
    automaton.setStates(input.nextLine().split(" "));

    System.out.println("\nAlphabet separated by spaces (For example: a b c)");
    automaton.setAlphabet(input.nextLine().split(" "));

    System.out.println("\nTransitions as tuples separated by spaces - For example: (q0 asdfasdfasdfa b c)");
    System.out.print("(fromState valueRead toState): ");
    automaton.setTransitions(input.nextLine());

    System.out.print("\nInitial state: ");
    automaton.setInitialState(input.nextLine().trim());

    System.out
        .println(
            "\nAcceptance states separated by spaces (should start with q and have a number after. For example: q0 q3) ");
    automaton.setAcceptanceStates(input.nextLine().split(" "));

    automaton.printAutomataData();

    input.close();
  }
}
