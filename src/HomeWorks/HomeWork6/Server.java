package HomeWorks.HomeWork6;

import java.io.*;
import java.net.*;
import java.util.*;

//1. Написать консольный вариант клиент\серверного приложения,
//в котором пользователь может писать сообщения, как на клиентской стороне, так и на серверной.
//Т.е. если на клиентской стороне написать «Привет», нажать Enter, то сообщение должно передаться на сервер и там отпечататься в консоли.
//Если сделать то же самое на серверной стороне, то сообщение передается клиенту и печатается у него в консоли.
//Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд.
//Такую ситуацию необходимо корректно обработать.

public class Server implements Runnable {

  private ServerSocket server;
  private Socket socket;
  private Thread outThread;

  private DataInputStream in;
  private DataOutputStream out;

  public static void main(String[] args) {
    new Server();
  }

  public Server() {
    try {

      Thread inThread = new Thread(this);
      outThread = new Thread(this);
      //Стартуем сервер
      server = new ServerSocket(8081);
      System.out.println("Сервер готов");
      //Ждем подключения
      socket = server.accept();
      System.out.println("Клиент подключился с адреса: " + socket.getRemoteSocketAddress());

      //Поток на "входящие сообщения"
      inThread.start();
      //Поток на "выход"
      outThread.start();

    } catch (NullPointerException | IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    String serverMsg;
    String clientMsg;

    try {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());

      Scanner stdIn = new Scanner(System.in);

      //Поток на "выход"
      if (Thread.currentThread() == outThread) {
        do {
          serverMsg = stdIn.nextLine();
          out.writeUTF(serverMsg);
          out.flush();
        } while  (!"\\finish".equals(serverMsg));
      //Поток на "входящие сообщения"
      } else {
        do {
          clientMsg = in.readUTF();
          System.out.println("Клиент: " + clientMsg);
        } while (!"\\finish".equals(clientMsg));
      }
    } catch (NullPointerException | IOException e) {
      e.printStackTrace();
    } finally {
      try {
        //закрываем всё в любом случае
        in.close();
        out.close();
        socket.close();
        server.close();
      } catch (NullPointerException | IOException e) {
        e.printStackTrace();
      }
    }
  }
}
