package Lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException() {
    super("Размерность массива должна быть 4 на 4");

    }
}
