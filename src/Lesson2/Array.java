package Lesson2;

import java.util.Random;

public class Array {

    public static String[][] array(int rows, int colls){

        String array[][] = new String[rows][colls];
        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = String.valueOf(random.nextInt(10));
            }
        }
        printArray(array);
        return array;
    }

    public static String[][] array(int rows, int colls, String o){
        String letter = o;
        String array[][] = new String[rows][colls];
        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = String.valueOf(random.nextInt(10));
            }
        }
        array[rows-1][colls-1] = letter;
        printArray(array);
        return array;
    }

    public static  void printArray(String [][] array){
        System.out.println("Массив для дальнейшей проверки:");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void checkArray(String[][] arr) {

        int sum = 0, row = 0, coll = 0;
        if(arr.length !=4 || arr[0].length != 4){throw new MyArraySizeException();}

        try {
            for(int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[i].length; j++){
                    int a = Integer.parseInt(arr[i][j]);
                    sum += a;
                    row = i;
                    coll = j;
                }
            }
        }catch (NumberFormatException e){
            throw new MyArrayDataException(row,coll);
        }finally {
            System.out.println("Сумма значений в массиве: " + sum);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            checkArray(array(4,4));
            checkArray(array(4,4,"D"));

        }catch (MyArraySizeException e){
            e.printStackTrace();
        }catch (MyArrayDataException e1){
            e1.printStackTrace();
        }

    }

}
