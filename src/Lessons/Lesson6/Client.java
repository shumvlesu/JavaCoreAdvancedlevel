package Lessons.Lesson6;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class Client {

  public static void main(String[] args) throws IOException {
    String id = UUID.randomUUID().toString();
    //Для клиента используем экземпляр класса Socket (не ServerSocket)
    //В момент создания socket пытаемся подключиться к серверу
    Socket socket = new Socket("localhost",8081);

    Scanner scanner = new Scanner(System.in);
    //socket.getInputStream() - получаем данные которые отправил нам сервер
    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
    String inputString;
    do {
      inputString = scanner.nextLine();
      Message message = new Message();
      message.setMessage(inputString);
      message.setClientId(id);
      //с помощью writeUTF помещаем для сервера сообщение забитое из консоли в dataOutputStream
      dataOutputStream.writeUTF(new Gson().toJson(message));
      //flush() - это непосредственная отправка сообщения как кнопка слива в унитазе, гов*о как бы само утечет
      //при dataOutputStream.writeUTF но тут с flush мы его выдаливаем точно.
      dataOutputStream.flush();
      //отсылаем сообщения пока не отошлем команду(сообщение) в inputString на сервер - "\\finish"
    } while (!"\\finish".equals(inputString));
    //Закрываем соединение
    socket.close();
  }

}
