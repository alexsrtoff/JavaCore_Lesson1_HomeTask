package Lesson3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    int count = 0;
    String test;
    List<String> surname = new ArrayList<>();
    List<String> phoneNum = new ArrayList<>();

    public PhoneBook() {

    }
    public void add(String name, String phone){
        surname.add(name);
        phoneNum.add(phone);
    }

    public void get(String name){
        if (checkName(name)) {
            for(int i = 0; i < surname.size(); i++){
                if(surname.get(i).equals(name)){
                    System.out.println("Фамилия: " + surname.get(i) +"," + " номер телефона: " + phoneNum.get(i));
                }
            }
        }  else System.out.println("В телефонной книге фамилии " + name + " нет");
    }
    public boolean checkName(String name){
       boolean result = false;
        for (String o: surname) {
            if(o.equals(name)){
                result = true;
            }
        }return result;
    }
}
