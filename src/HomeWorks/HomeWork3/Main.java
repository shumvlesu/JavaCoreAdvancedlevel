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


        //2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи.
        // С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.
        System.out.println();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneBook("Редько Качанович", "+7(918)332-22-56");
        phoneBook.addPhoneBook("Редько Качанович", "+7(918)332-22-56");
        phoneBook.addPhoneBook("Редько Качанович", "+7(918)332-22-52");

        phoneBook.addPhoneBook("Нонейм Нонеймович", "+7(918)332-69-58");

        System.out.println();
        System.out.println("Кузнецов Адмиралович");
        System.out.println(phoneBook.getPhoneNumber("Кузнецов Адмиралович"));
        System.out.println("Редько Качанович");
        System.out.println(phoneBook.getPhoneNumber("Редько Качанович"));

    }
}
