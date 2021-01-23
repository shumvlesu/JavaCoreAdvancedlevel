package Lessons.Lesson6;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//получается один клиент = один поток
public class ClientSocketHandler extends Thread{
  private Socket socket;

  public ClientSocketHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
      String inputString;
      do {
        inputString = dataInputStream.readUTF();
        //getInetAddress() - ip клиента , нам он нужен для идентефикации клиента
        System.out.println("Echo client "+socket.getInetAddress()+": "+inputString);
      } while (!"\\finish".equals(inputString));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}