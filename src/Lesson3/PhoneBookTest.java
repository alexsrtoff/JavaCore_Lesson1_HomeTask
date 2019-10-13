package Lesson3;

public class PhoneBookTest {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "79112345669");
        phoneBook.add("Петров", "79811145933");
        phoneBook.add("Пупкин", "79811182233");
        phoneBook.add("Васильв", "79812512233");
        phoneBook.add("Иванов", "79811112233");
        phoneBook.add("Петров", "79811112433");
        phoneBook.add("Кукушкин", "79811114933");

        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Кратов");
    }


}
