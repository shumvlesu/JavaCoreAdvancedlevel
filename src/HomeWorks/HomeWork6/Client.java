package HomeWorks.HomeWork6;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client implements Runnable {

  private Thread outThread;
  private DataInputStream in;
  private DataOutputStream out;
  private Socket socket;


  public static void main(String[] args) {
    new Client();
  }

  public Client() {
    try {
      Thread inThread = new Thread(this);
      outThread = new Thread(this);

      socket = new Socket("localhost", 8081);

      inThread.start();
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
      if (Thread.currentThread() == outThread) {
        do {
          clientMsg = stdIn.nextLine();
          out.writeUTF(clientMsg);
          out.flush();
        } while (!"\\finish".equals(clientMsg));
      } else {
        do {
          serverMsg = in.readUTF();
          System.out.println("Сервер пишет: " + serverMsg);
        } while (!"\\finish".equals(serverMsg));
      }
    } catch (NullPointerException | IOException e) {
      e.printStackTrace();
    } finally {
      try {
        in.close();
        out.close();
        socket.close();
      } catch (NullPointerException | IOException e) {
        e.printStackTrace();
      }
    }
  }
}
