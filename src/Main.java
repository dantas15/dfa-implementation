import java.util.Scanner;

public class Main {
  private DFA automaton;
  private Scanner input;

  public Main() {
    this.automaton = new DFA();
    this.input = new Scanner(System.in);
  }

  public void execute() {
    automaton.setStates(input.nextLine().split(" "));
    for (String s : automaton.getStates()) {
      System.out.println(s);
    }
  }
}
