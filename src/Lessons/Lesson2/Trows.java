package Lessons.Lesson2;

public class Trows {
  public static void main(String[] args) {

    //пример проброса в верний метод исключения
    try {
      extracted();
    } catch (ArithmeticException e) {
      System.out.println("Ошибка:" + e.getMessage());
      //e.printStackTrace();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("2й  вид ошибки");
    } finally {
      System.out.println("этот кусок обязательно выполнится.");
    }

  }

  private static void extracted() throws ArithmeticException { //throws ArithmeticException это собственно проброс
    int a = 10;
    int b = 0;
    int c = a / b;
  }
}
