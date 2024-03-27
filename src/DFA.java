import java.util.ArrayList;

public class DFA {
  private ArrayList<String> states;
  private ArrayList<String> alphabet;
  private ArrayList<Tuple> transitions;
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
    return this.states;
  }

  public void setStates(String[] unparsedStrings) {
    this.states = parseStates(unparsedStrings);
  }

  public void setAcceptanceStates(String[] unparsedStrings) {
    this.acceptanceStates = parseStates(unparsedStrings);
  }
}
