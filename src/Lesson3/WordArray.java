package Lesson3;

import java.util.*;

public class WordArray {
    public static void main(String[] args) {

        Map<String, Integer> repetition = new LinkedHashMap<>();
        Integer repWord;
        List<String> words = new ArrayList<>();
        words.add("Кот");
        words.add("Собака");
        words.add("Велосипед");
        words.add("Кот");
        words.add("Кошка");
        words.add("Кот");
        words.add("Велосипед");
        words.add("Пельмень");
        words.add("Торт");
        words.add("Мир");
        words.add("Кот");
        words.add("Велосипед");
        words.add("Кот");
        words.add("Собака");
        words.add("Валенок");
        words.add("Кот");

        for(int i = 0; i < words.size(); i++){
            repWord = repetition.get(words.get(i));
            if(repWord == null){
                repWord = 0;
            }
            repetition.put(words.get(i),repWord + 1);
        }

        System.out.println("Список уникальных слов и количество повторений: ");
        System.out.println(repetition);}

}
