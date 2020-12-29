package Lessons.Lesson2;

public class CustomExeption extends Exception{
  private final int a;
  private final int b;
  public CustomExeption(int a, int b, Throwable cause) {
    super(cause);
    this.a = a;
    this.b = b;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }
}
