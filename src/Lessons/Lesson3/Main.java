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
    System.out.println();
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

    //Пример HashMap
    //HashMap  не  гарантирует  порядок  расположения  своих  элементов,
    //соответственно  порядок  их  перебора  может  не  соответствовать  порядку  их  добавления.

    //Важно! Что нужно помнить при работе с HashMap:
    //- HashMap предоставляет возможность быстрого поиска значения по ключу;
    //- Для того, чтобы ваши собственные типы данных (классы) могли использоваться в качестве
    //ключей HashMap, необходимо корректно реализовать методы hashCode() и equals();
    //- Метод put() используем для добавления пары ключ-значение, get() для получения значения
    //по ключу;


    System.out.println();
    HashMap<String, String> hm = new HashMap<>();
    hm.put("Russia", "Moscow");
    hm.put("France", "Paris");
    hm.put("Germany", "Berlin");
    hm.put("Norway", "Oslo");
    for (Map.Entry<String, String> o : hm.entrySet()) {
      System.out.println(o.getKey() + ": " + o.getValue());
    }
    hm.put("Germany", "Berlin2");
    System.out.println("New Germany Entry: " + hm.get("Germany"));

    // Результат:
    // Norway: Oslo
    // France: Paris
    // Germany: Berlin
    // Russia: Moscow
    // New Germany Entry: Berlin2



    //Пример Set
    // HashSet служит для создания коллекции, содержащей только уникальные элементы
    //(особое внимание необходимо уделить словосочетанию “только уникальные элементы”) и основанной
    //на использовании внутренней хеш-таблицы

    Set<String> set = new HashSet<>();
    set.add("Aльфa");
    set.add("Бета");
    set.add("Aльфa");
    set.add("Этa");
    set.add("Гaммa");
    set.add("Эпсилон");
    set.add("Oмeгa");
    set.add("Гaммa");
    System.out.println(set);

    // Результат:
    // [Гaммa, Эпсилон, Бета, Этa, Oмeгa, Aльфa]


    //LinkedHashSet.  Класс  LinkedHashSet<E>  расширяет  класс  HashSet,  не  добавляя  никаких  новых
    //методов.  У  этого  класса  такие  же  конструкторы,  как  и  у  класса  HashSet.  Класс  LinkedHashSet
    //использует связный список для сохранения порядка добавления в него элементов. Следовательно,
    //при переборе элементов они будут извлекаться в том порядке, в каком были добавлены. Пример:
    Set<String> stringSet = new LinkedHashSet<>();
    stringSet.add("Бета");
    stringSet.add("Aльфa");
    stringSet.add("Этa");
    stringSet.add("Гaммa");
    stringSet.add("Эпсилон");
    stringSet.add("Oмeгa");
    System.out.println(stringSet);

    // Результат:
    // [Бета, Альфа, Эта, Гамма, Эпсилон, Омега]

    //TreeSet.  Класс  TreeSet  создаёт  коллекцию,  где  для  хранения  элементов  применяет  древовидная
    //структура.  Объекты  сохраняются  в  отсортированном  порядке  по  возрастанию.  Время  доступа  и
    //извлечения  элементов  достаточно  мало,  благодаря  чему  класс  TreeSet  оказывается  отличным
    //выбором для хранения больших объемов отсортированных данных.
    //В классе TreeSet определены следующие конструкторы:
    //● TreeSet ().
    //● TreeSet (Collection<? extends Е> сollection).
    //● TreeSet (Comparator<? super Е> comparator).
    //● TreeSet (SortedSet<E> s).
    //В первой форме конструктора создаётся пустое древовидное множество. Во второй — древовидное
    //множество, содержащее элементы заданной коллекции сollection. В третьей — пустое древовидное
    //множество,  элементы  которого  будут  отсортированы  заданным  компаратором.  И,  наконец,  в
    //четвёртой  форме  создаётся  древовидное  множество,  содержащее  элементы  заданного
    //отсортированного  множества  s.  В  приведённом  ниже  примере  программы  демонстрируется
    //применение класса TreeSet.

    System.out.println();
    Set<String> stringTreeSet = new TreeSet<>();
    stringTreeSet.add("C");
    stringTreeSet.add("A");
    stringTreeSet.add("B");
    stringTreeSet.add("E");
    stringTreeSet.add("F");
    stringTreeSet.add("D");
    System.out.println(stringTreeSet);

    // Результат:
    // [A, B, C, D, E, F]



}

}
