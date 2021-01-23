package Lessons.Lesson6;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


//Это пример мультитредового сервера
public class MultiThreadServer {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8081)) {
      System.out.println("Создали серверный сокет");
      do {
        System.out.println("Ожидаем подключение клиента");
        //accept - это блокирующий метод. Пока ак нам не подключится какнибуть клиент программа будет стоять на нем как на точке останова.
        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключился");
        new ClientSocketHandler(socket).start();
        //оборачиваем все это в бесконечный цикл что бы любое количество клиентов могло к нам подключиться
        //иначе сможет с сервером работать только один клиент
      } while (true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
