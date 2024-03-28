import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DFA {
  private ArrayList<String> states;
  private ArrayList<String> alphabet;
  private ArrayList<Triple> transitions;
  private String initialState;
  private ArrayList<String> acceptanceStates;

  public DFA() {
    this.states = new ArrayList<>();
    this.alphabet = new ArrayList<>();
    this.transitions = new ArrayList<>();
    this.acceptanceStates = new ArrayList<>();
  }

  private ArrayList<String> parseStates(String[] unparsedStrings) {
    ArrayList<String> validStates = new ArrayList<>();

    for (String s : unparsedStrings) {
      if (s.matches("^q\\d+$") && !(validStates.contains(s))) {
        validStates.add(s);
      }
    }

    return validStates;
  }

  public ArrayList<String> getStates() {
    return states;
  }

  public void setStates(String[] unparsedStates) {
    this.states = parseStates(unparsedStates);
  }

  public ArrayList<String> getAlphabet() {
    return alphabet;
  }

  public void setAlphabet(String[] unparsedAlphabet) {
    for (String s : unparsedAlphabet) {
      if (!(alphabet.contains(s))) {
        alphabet.add(s);
      }
    }
  }

  public ArrayList<Triple> getTransitions() {
    return transitions;
  }

  public void setTransitions(String unparsedTransitions) {
    Pattern pattern = Pattern.compile("\\((.*?)\\)");
    Matcher matcher = pattern.matcher(unparsedTransitions);

    while (matcher.find()) {
      String[] transition = matcher.group(1).split(" ");
      if (transition.length == 3) {
        transitions.add(new Triple(transition[0], transition[1], transition[2]));
      } else {
        throw new Error("Invalid transition format");
      }
    }
  }

  public String getInitialState() {
    return initialState;
  }

  public void setInitialState(String initialState) {
    if (!(states.contains(initialState))) {
      throw new Error("Not a valid state");
    }

    this.initialState = initialState;
  }

  public ArrayList<String> getAcceptanceStates() {
    return acceptanceStates;
  }

  public void setAcceptanceStates(String[] unparsedAcceptanceStates) {
    this.acceptanceStates = parseStates(unparsedAcceptanceStates);
  }

  private void printArrayList(String title, ArrayList<String> array) {
    System.out.print(title + ": {\n");
    for (String s : array) {
      System.out.print("\t" + s + "\n");
    }

    System.out.print(" }\n");
  }

  public void printAutomataData() {
    System.out.println("\n---BEGIN Print Automata Data---");
    printArrayList("States", states);
    printArrayList("Alphabet", alphabet);

    // the print for the transitions are a bit different :(
    System.out.println("--- BEGIN Transitions ---");
    for (Triple transition : transitions) {
      System.out.println(transition.key);
    }
    System.out.println("--- END Transitions ---");

    System.out.println("Initial state: " + initialState);
    printArrayList("Acceptance states", acceptanceStates);
    System.out.println("\n---END Print Automata Data---");
  }

  private String getNextState(String currentState, String symbol) {
    for (Triple transition : transitions) {
      if (transition.fromState().equals(currentState) && transition.valueRead().equals(symbol)) {
        return transition.toState();
      }
    }
    return null; // If no transition is found for the current state and symbol
  }

  public boolean execute(String word) {
    String currentState = this.initialState;

    for (int i = 0; i < word.length(); i++) {
      // get the current symbol (letter, number, etc..)
      String symbol = word.substring(i, i + 1);

      String nextState = getNextState(currentState, symbol);

      // if no transition is found, input is invalid
      if (nextState == null) {
        return false;
      }

      currentState = nextState;
    }

    return acceptanceStates.contains(currentState);
  }
}
