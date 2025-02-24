import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    HashMap<String, String> phoneBook = new HashMap<>();
    String regexName = "[a-zA-Zа-яА-Я]+";

    public void setPhoneBook(String textIn) {

        if (textIn.equals("LIST")) {
            System.out.println(phoneBook.toString());
            System.out.println();
            printList(phoneBook);
        } else if (isValidPhone(textIn)) {
            addPhone(textIn);
        } else if (isValidName(textIn)){
            addName(textIn);
        } else {
            System.out.println("Проверьте введенный техт");
        }

    }

    private void addPhone(String textIn) {
        if (!phoneBook.containsKey(textIn)) {
            System.out.println("Такого номера нет в телефонной книге.");
            System.out.println("Введите имя абонента для номера " + textIn);
            String name = new Scanner(System.in).nextLine();
            if (isValidName(name)) {
                phoneBook.put(textIn, name);
                System.out.println("Контакт сохранен!");
            } else {
                System.out.println("Контакт НЕ сохранен! Не корректое имя. Повторите ввод");
            }

        } else {
            System.out.println("Абонент с номер " + textIn + " уже есть в справочнике");
        }
    }

    private void addName(String textIn) {
        if (!phoneBook.containsValue(textIn)) {
            System.out.println("Такого имени в телефонной книге нет.");
            System.out.println("Введите номер телефона для абонента " + textIn);
            String phone = new Scanner(System.in).nextLine();
            addPhoneIsValid(phone, textIn);

        } else {
            System.out.println("Абонент с именем " + textIn + " уже есть в справочнике");
            System.out.println("Если хотите сохранить еще номер для абонента " + textIn + " введите номер");
            System.out.println("Если нет просто нажмите клавишу ВВОД");
            String phone = new Scanner(System.in).nextLine();
            addPhoneIsValid(phone, textIn);
        }

    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    private boolean isValidPhone(String phone) {
        String regex = "[78][0-9]{10}";
        return phone.matches(regex);
    }

    private boolean isValidName(String name) {
        String regex = "[a-zA-Zа-яА-Я\\s]+";
        return name.matches(regex);
    }

    private void addPhoneIsValid(String phone, String textIn) {
        if (isValidPhone(phone)) {
            phoneBook.put(phone, textIn);
            System.out.println("Контакт сохранен!");
        } else {
            System.out.println("Контакт НЕ сохранен! При необходимости повтоите ввод");
        }
    }

    private void printList(HashMap<String, String> phoneBook) {

        for (String phone : phoneBook.keySet()) {
            System.out.println(phoneBook.get(phone));
            System.out.println(phone);
        }
    }

}


