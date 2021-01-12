package Lessons.Lesson3;

import java.util.*;

public class IteratorClass {
  //Итераторы
  public static void main(String[] args) {
    //Итератор позволяет обойти все элементы коллекции. Для работы с итераторами служит интерфейс
    //Iterator. Для получения объекта этого типа, необходимо вызвать метод iterator() у коллекции
    List<String> list = new ArrayList<>();
    Iterator iterator = list.iterator();

    //Давайте рассмотрим три основных метода интерфейса Iterator: hasNext(), next(), remove().
    //● hasNext() проверяет наличие элементов в коллекции, которые мы еще не видели;
    //● next() переходит на следующий элемент коллекции и возвращает ссылку на него;
    //● remove() удаляет элемент, на который указывает итератор в настоящий момент.

    List<String> arrayList = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "A", "A", "B", "C", "B"));
    //while (iter.hasNext()) {
    //    String str = iter.next();
    //       if (str.equals("A")) {
    //        iter.remove();
    //      }
    // }
    arrayList.removeIf(str -> str.equals("A"));
    System.out.println(arrayList);
    // Результат: [B, C, C, B, C, B]

    //При работе с List мы можем использовать “расширенный” вариант итератора - ListIterator.
    List<String> stringList = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "A", "A", "B", "C", "B"));
    ListIterator listIterator = stringList.listIterator();
    //Этот интерфейс добавляет больше гибкости при работе с List.
    //● hasPrevious() - проверка есть ли элемент слева;
    //● previous() - переход на левый элемент и возврат ссылки на него;
    //● nextIndex() - получение индекса следующего элемента;
    //● previousIndex() - получение индекса предыдущего элемента;
    //● add() - добавить новый элемент на то место, на которое указывает итератор;
    //● set() - изменить элемент, на который указывает итератор.


  }


}
