package HomeWorks.HomeWork2;

public class MyArrayDataException extends Exception{
  private final int summa;
  public MyArrayDataException(String message, int summa) {
    super(message);
    this.summa = summa;
  }

  @Override
  public String getMessage() {
    return super.getMessage()+"\nСумма элементов на момент ошибки составляет: "+this.summa;
  }
}
