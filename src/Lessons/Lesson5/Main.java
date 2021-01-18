package Lessons.Lesson5;

import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {

    Thread thread = new Thread(){
      @Override
      public void run() {
        do {
          System.out.println("Тик");
        }while (!isInterrupted()); // проверяем стоит ли флаг завершения потока.
      }
    };

    thread.start();
    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
    //interrupt - это флаг позволяющий потоку понять что его хотят завершить
    thread.interrupt();


  }
}
