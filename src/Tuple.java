public class Tuple {
  public final String x;
  public final String y;

  public Tuple(String x, String y) {
    this.x = x;
    this.y = y;
  }

  public String first() {
    return this.x;
  }

  public String second() {
    return this.y;
  }
}
