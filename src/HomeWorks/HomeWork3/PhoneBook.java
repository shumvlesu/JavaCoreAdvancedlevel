package HomeWorks.HomeWork3;

import java.util.*;

public class PhoneBook {

    private final HashMap<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addPhoneBook(String name, String number) {
        if (phoneBook.containsKey(name)) {//человек уже есть с таким именем
            List<String> numbers = phoneBook.get(name);
            if (!numbers.contains(number)) {//не надо добавлять номер человеку если он уже есть у него
                numbers.add(number);
                System.out.printf("%s добавлен в справочник, номер %s%n",  name, number);
            } else {
                System.out.printf("Номер %s уже существует для %s%n", number, name);
            }
        } else {//Добавляю в первый раз
            phoneBook.put(name, new ArrayList<>(Collections.singletonList(number)));
            System.out.printf("%s добавлен в справочник, номер %s%n",  name, number);
        }
    }

    public String getPhoneNumber(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name).toString();
        } else {
            return "В справочнике нет записей с "+name;
        }
    }

}
