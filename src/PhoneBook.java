import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    HashMap<String, String> phoneBook = new HashMap<>();
    String regexName = "[a-zA-Zа-яА-Я]+";
    String regexPhone = "[0-9]+";

    public void setPhoneBook(String textIn) {

        if (textIn.equals("LIST")) {
            System.out.println(phoneBook.toString());
        } else if (textIn.matches(regexPhone)) {
            addPhone(textIn);
        } else if (textIn.matches(regexName)){
            addName(textIn);
        } else {
            System.out.println("Проверьте введенный техт");
        }

    }

    private void addPhone(String textIn) {
        if (!phoneBook.containsKey(textIn)) {
            System.out.println("Введите имя абонента для номера " + textIn);
            String name = new Scanner(System.in).nextLine();
            phoneBook.put(textIn, name);
        } else {
            System.out.println("Абонент с номер " + textIn + " уже есть в справочнике");
        }
    }

    private void addName(String textIn) {
        if (!phoneBook.containsValue(textIn)) {
            System.out.println("Введите номер телефона для абонента " + textIn);
            String phone = new Scanner(System.in).nextLine();
            phoneBook.put(phone, textIn);
        } else {
            System.out.println("Абонент с именем " + textIn + " уже есть в справочнике");
        }

    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }
}


