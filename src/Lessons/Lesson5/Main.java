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

    //если вы например запустите 2 потока и поставите одному из них interrupt.
    //может так получиться что этот поток будет как раз "заснувшим"(проц время у другого потока) в этот момент
    //то в мамент вызова interrupt() проищойдет исключение InterruptedException
    //нужно это учитывать

  }
}
