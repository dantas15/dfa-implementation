import java.util.Scanner;

public class Program {
  private DFA automaton;
  private Scanner input;

  public Program() {
    this.automaton = new DFA();
    this.input = new Scanner(System.in);
  }

  public void execute() {
    this.inputAutomatonData();

    String opt = "y";
    String word;

    while (!opt.equals("n")) {
      System.out.print("\nEnter a word for the automaton to process: ");
      word = input.nextLine().trim();

      if (automaton.execute(word)) {
        System.out.println("It accepts!");
      } else {
        System.out.println("It does not accept!");
      }

      System.out.println("Type 'n' to exit or ENTER to input a word for the automaton to process...");
      opt = input.nextLine();
    }

    input.close();
  }

  private void inputAutomatonData() {
    System.out
        .println(
            "\nStates separated by spaces (should start with q and have a number after. For example: q0 q1): ");
    automaton.setStates(input.nextLine().split(" "));

    System.out.println("\nAlphabet separated by spaces (For example: a b c)");
    automaton.setAlphabet(input.nextLine().split(" "));

    System.out
        .println("\nTransitions as tuples separated by spaces - For example: (q0 0 q0) (q0 1 q1) (q1 0 q1) (q1 1 q0)");
    System.out.print("(fromState valueRead toState): ");
    automaton.setTransitions(input.nextLine());

    System.out.print("\nInitial state (single state, should start with q and have a number after): ");
    automaton.setInitialState(input.nextLine().trim());

    System.out
        .println(
            "\nAcceptance states separated by spaces (should start with q and have a number after. For example: q0 q1) ");
    automaton.setAcceptanceStates(input.nextLine().split(" "));

    automaton.printAutomataData();
  }
}
