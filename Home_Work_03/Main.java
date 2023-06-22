package Home_Work_03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.surname = "Pakhorukov";
        human.name = "Anton";
        human.patronymic = "Vladislavovich";
        human.birthday = "17.02.1985";
        human.gender = "m";
        human.phone = "89137869449";
        System.out.println(human.toString());


        try {
//            String[] test = getData();
//            print(test);
//            Human human1 = new Human(getData());
//            System.out.println("Human1: " + human1);
//            System.out.println(human1.name);
//            System.out.println(human1.phone);
            addHuman(new Human(getData()));
        } catch (InputDataException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void addHuman(Human human) {
        try (FileWriter writer = new FileWriter(new File(human.surname + ".txt"), true)) {
            writer.write(String.valueOf(human) + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getData() {
        String[] result = null;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Введите данные пользователя в формате:\n" +
                    "  Ivanov Ivan Ivanovich 01.02.2000 89134567890 m\n" +
                    ": ");
            result = scan.nextLine().split(" ");
            if (result.length < 6) { // проверка кол-ва данных
                throw new InputDataException("Вы ввели меньше данных, чем требуется");
            } else if (result.length > 6) { // проверка кол-ва данных
                throw new InputDataException("Вы ввели больше данных, чем требуется");
            } else if (result[0].isEmpty() | result[1].isEmpty() | result[2].isEmpty() | // проверка пустого ввода
            result[3].isEmpty() | result[4].isEmpty() | result[5].isEmpty()) {
                throw new InputDataException("Ошибка ввода данных");
            } else {
                examinationFIO(result); // Проверка ФИО выведена в отдельный метод
                examinationDate(result); // проверка ввода даты рождения выведена в отдельный метод
                examinationGender(result); // Проверка на гендер выведена в отдельный метод
                examinationPhone(result); // Проверка номера телефона выведена в отдельный метод
            }
        }

        return result;
    }

    public static void examinationPhone(String[] string) {
        for (Character phone: string[4].toCharArray()) { // проверка номера телефона
            if (!Character.isDigit(phone)) {
                throw new InputDataException("Ошибка ввода номера телефона, содержит не только цифры");
            }
        }
    }

    public static void examinationDate(String[] string){
        for (Character digit: string[3].toCharArray()) { // проверка ввода даты рождения
            if(string[3].length() != 10) {
                throw new InputDataException("Ошибка в вводе даты рождения");
            }
            if(!Character.isDigit(digit)) {
                if(!".".contains(Character.toString(digit))) {
                    throw new InputDataException("Ошибка в вводе даты рождения");
                }
            }
        }
        char[] date = string[3].toCharArray();
        if (Integer.parseInt(String.valueOf(date[6])) == 1) {
            if (Integer.parseInt(String.valueOf(date[7])) != 9) {
                throw new InputDataException("Ошибка ввода даты рождения, не верно указан год");
            }
        } else if (Integer.parseInt(String.valueOf(date[6])) == 2) {
            if (Integer.parseInt(String.valueOf(date[7])) != 0) {
                throw new InputDataException("Ошибка ввода даты рождения, не верно указан год");
            }
        } else {
            throw new InputDataException("Ошибка ввода даты рождения, не верно указан год");
        }
    }

    public static void examinationFIO(String[] string) {
        for (int i = 0; i < 3; i++) { // Проверка ФИО
            for (Character symbol: string[i].toCharArray()) {
                if(Character.isDigit(symbol)) { // на цифры
                    throw new InputDataException("Ошибка ввода, Ф.И.О. содержит цифру");
                }
                if(",.!@#$%^{}[]&*()_+=-`:;'/?><|\\№".contains(Character.toString(symbol))) { // на символы
                    throw new InputDataException("Ошибка ввода Ф.И.О. содержит лишние символы");
                }
            }
        }
    }

    public static void examinationGender(String[] string) {
        if (!string[5].toLowerCase().equals("m")) { // проверка гендера
            if(!string[5].toLowerCase().equals("f")) {
                throw new InputDataException("Не верно указан гендер");
            }
        }
    }

    public static void print(String[] string) {
        for (int i = 0; i < string.length; i++) {
            System.out.print(string[i] + " ");
        }
    }
}
