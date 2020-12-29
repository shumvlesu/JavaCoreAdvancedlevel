package Lessons.Lesson2;

public class UseThrows {

  public static void main(String[] args) {
    try {
      throw new NullPointerException("NPE Test");
    } catch (NullPointerException е) {
      System.out.println("Catch block");
    }
  }
}