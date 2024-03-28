public class Triple {
  public final String x;
  public final String y;
  public final String z;

  public final String key;

  public Triple(String x, String y, String z) {
    this.key = "(" + x + "," + y + "," + z + ")";
    this.x = x;
    this.y = y;
    this.z = z;
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
