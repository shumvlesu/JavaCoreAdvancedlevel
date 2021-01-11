package Lessons.Lesson3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    //Лучше использовать такое объявление
    List<String> stringlist = new ArrayList<>();
    //чем такое
    //ArrayList<String> stringlist = new ArrayList<>();

    // пример ArrayList
    List<String> arrayList = new ArrayList<>();
    arrayList.add("A");
    arrayList.add("B");
    arrayList.add("C");
    arrayList.add("D");
    arrayList.add("E");
    arrayList.add(1, "А0");
    System.out.println(arrayList);
    arrayList.remove("E");
    arrayList.remove(2);
    System.out.println(arrayList);

    // Результат:
    // [A, А0, B, C, D, E]
    // [A, А0, C, D]


  //пример LinkedList
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("F");
    linkedList.add("B");
    linkedList.add("D");
    linkedList.add("Е");
    linkedList.add("C");
    linkedList.addLast("Z");
    linkedList.addFirst("A");
    linkedList.add(1, "А2");
    System.out.println("1. linkedList: " + linkedList);
    linkedList.remove("F");
    linkedList.remove(2);
    System.out.println("2. linkedList: " + linkedList);
    linkedList.removeFirst();
    linkedList.removeLast();
    System.out.println("3. linkedList: " + linkedList);
    String val = linkedList.get(2);
    linkedList.set(2, val + " изменено");
    System.out.println("4. linkedList: " + linkedList);

    // Результат:
    // 1. linkedList: [A, А2, F, B, D, Е, C, Z]
    // 2. linkedList: [A, А2, D, Е, C, Z]
    // 3. linkedList: [А2, D, Е, C]
    // 4. linkedList: [А2, D, Е изменено, C]



    
  }

}
