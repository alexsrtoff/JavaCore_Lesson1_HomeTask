package Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordArray {
    public static void main(String[] args) {
        HashMap<String, Integer> repetition = new HashMap<>();
        String repWord;
        int count = 0;
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
        List<String> words1 = new ArrayList<>();

        for(int i = 0; i < words.size(); i++){
            repWord = words.get(i);
            for(int j = 0; j<words.size(); j++){
                if (repWord.equals(words.get(j))){
                    count++;
                    if(count >1) {
                        repetition.put(repWord, count);
                    }
                }
            }if(count == 1)words1.add(words.get(i));
            count = 0;
        }
        System.out.println("Повторяющиеся слова в массиве и количество повторений: " + repetition);
        System.out.println("Массив слов без повторений: " + words1);

    }
}
