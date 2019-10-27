package Lesson3;

import java.util.*;

public class PhoneBook {

    Map<String, Set<String>> phoneBook = new TreeMap<>();

    public PhoneBook() {

    }
    public void add(String name, String phone){
        Set<String> phoneNum = getPhone(name);

        phoneNum.add(phone);
    }

    private Set<String> getPhone(String name) {
        Set<String> phones = phoneBook.get(name);
        if(phones == null){
            phones = new HashSet<>();
            phoneBook.put(name, phones);
        }return phones;
    }

    public void get(String name){
        if (phoneBook.get(name) == null){
            System.out.println("Записи с фамилией " + name + " нет");
        }else System.out.println(name + ": " + phoneBook.get(name));
    }
    public Set<String> getAll(){
        return phoneBook.keySet();
    }
}
