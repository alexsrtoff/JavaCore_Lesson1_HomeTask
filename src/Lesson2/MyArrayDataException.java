package Lesson2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super("В ячейке " + i + " " + j + " содержится не число");
    }
}
