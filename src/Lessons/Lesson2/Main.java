package Lessons.Lesson2;

public class Main {
  //В приведённом примере при делении на ноль была выведена полная информация об исключении, и программа продолжила свою работу.
  public static void main(String args[]) {
    System.out.println("Начало");
    try {
      int а = 0;
      int b = 42 / а;
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }
    System.out.println("Конец");
  }

}
