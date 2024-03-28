import java.util.ArrayList;

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

  public void setTransitions(String[] transitions) {
    // TODO Implement this
    throw new Error("Implement transition");
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
    System.out.println(title + ": {");
    for (int i = 0; i < array.size(); i++) {
      System.out.print(" " + array.get(i));
      if (i != array.size() - 1) {
        System.out.print(",");
      }
    }
    System.out.print(" }");
  }

  public void printAutomataData() {
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
  }
}
