package HomeWorks.HomeWork3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать, сколько раз встречается каждое слово.
        List<String> myArray = Arrays.asList("Зеленый", "Красный", "Зеленый", "Желтый", "Коричневый", "Черный", "Желтый", "Желтый");
        Set<String> uniqueWords = new HashSet<>(myArray);
        for (String key : uniqueWords) {
            int count = Collections.frequency(myArray, key);
            if (count>1) {
                System.out.println("Это значение встречается больше одного раза - "+key + ": " + count);
            }
        }

    }
}
