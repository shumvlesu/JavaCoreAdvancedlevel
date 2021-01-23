package Lessons.Lesson6;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {
    //http://blog.harrix.org/article/7348 как подключить gson
    //Создаем экземпляр класса ServerSocket который слушает порт 8081
    //ServerSocket является наследником классов имеющих AutoCloseable. Так что джава сама его закроет и
    //socket.close(); не нужно использовать при отключении или ошибки исключения
    try (ServerSocket serverSocket = new ServerSocket(8081)) {
      System.out.println("Создали серверный сокет");
      System.out.println("Ожидаем подключение клиента");
      //Встаем на ожидание на подключение к нашему сокету
      Socket socket = serverSocket.accept();
      System.out.println("Клиент подключился");

      //socket.getOutputStream() - это поток на выход с нашего сервера мы можем через него послать информацию с нашего сервера
      //socket.isClosed() - сокет открытый или уже закрыт
      //socket.connect(); - подключилсь?
      //socket.isInputShutdown() , socket.isOutputShutdown() - показывает что входящие или исходящие соединения сокета закрыты или открыты
      //socket.close(); - закрывает серверный сокет и разрывает соединение
      //getInputStream() - это все то что нам пришлет наш клиент
      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
      String inputString;
      Message message;
      do {
        //readUTF() - позволяет полностью вычитать посланное сообщение для вывода его на экран
        inputString = dataInputStream.readUTF();
        message = new Gson().fromJson(inputString, Message.class);
        System.out.println("Echo clientId="+message.getClientId()+": ");
        System.out.println(message.getMessage());
        //принимаем сообщения пока не получим команду(сообщение) в message от клиента - "\\finish"
      } while (!"\\finish".equals(message.getMessage()));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}

