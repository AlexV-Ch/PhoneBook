import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Создание телефонной книги
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String textIn = new Scanner(System.in).nextLine();
        //Вызов метода для textIn
            phoneBook.setPhoneBook(textIn);

        }
    }
}