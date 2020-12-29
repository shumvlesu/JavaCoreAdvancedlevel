package Lessons.Lesson2;

public class GlavnyPrimer {

  public static void main(String[] args) {

    //это пример проброса исключения с кастомным исключением. CustomExeption
    int a = 10;
    int b = 0;
    try {
      extracted2(a,b);
    }catch (Exception e){
      System.out.println("Что-то случилось");
      System.out.println("Параметры были такие:");
      System.out.println(e.getMessage());
    }

  }
  private static void extracted2(int a, int b) throws Exception{
    try {
      extracted(a,b);
    }catch (CustomExeption e){
      throw new Exception("a="+e.getA()+" b="+e.getB(),e);
    }
  }

  private static void extracted(int a, int b) throws Exception{
    try {
      int c = a/b;
    }catch (ArithmeticException e){
      throw new CustomExeption(a,b,e);
    }
  }


}
