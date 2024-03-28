public class Triple {
  public final String x;
  public final String y;
  public final String z;

  public final String key;

  public Triple(String fromState, String valueRead, String toState) {
    this.key = "(" + fromState + "," + valueRead + "," + toState + ")";
    this.x = fromState;
    this.y = valueRead;
    this.z = toState;
  }

  public String fromState() {
    return x;
  }

  public String valueRead() {
    return y;
  }

  public String toState() {
    return z;
  }
}
