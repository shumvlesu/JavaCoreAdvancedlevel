package Lessons.Lesson3;

import java.util.*;

public class PrimerComparable {
  public static void main(String[] args) {

    //интерфейс Comparable служит для описания способа сравнения объектов  для их дальнейшего
    //упорядочивания. Данный интерфейс указывает что объекты этого типа могут быть упорядочены.

    List<Cat> cats = new ArrayList<>(Arrays.asList(
            new Cat("A", 5), new Cat("B", 2), new Cat("C", 4)
    ));
    System.out.println(cats);
    //Объяснив Java что хотим сравнивать котов именно по возрасту, мы можем отсортировать список в
    //порядке возрастания, и вывести его в консоль.
    Collections.sort(cats);
    System.out.println(cats);

    // Результат:
    // [Cat [A], Cat [B], Cat [C]]
    // [Cat [B], Cat [C], Cat [A]]
  }
}
