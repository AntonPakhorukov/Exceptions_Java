package Lecture_03;

import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SavedException{
        // === try with resources - значительно сокращает код ====================================================
        /*
        try (FileReader test = new FileReader("test")) {
            test.read();
        } catch (RuntimeException | IOException e) {
            System.err.println("catch exception: " + e.getClass().getSimpleName());
        } //finally { // блок, который в любом случае будет выполнен уже не нужен
            // блок закрытия уже не нужен, так как try ориентирован конкретно на работу с файлом ->
            // вышли из try - файл закрвыт
            //System.out.println("finaly start");
            //System.out.println("finaly end");
            // JVM сама будет открывать и закрывать файл, работать в рамках "()" блока try
        //}
        */
        // === Копирование из одного файла в другой ==============================================================
        /*
        try (FileReader reader = new FileReader("C:\\Users\\pakho\\IdeaProjects\\Seminar_01\\src\\Lecture_02\\test.md");
             FileWriter writer = new FileWriter("C:\\Users\\pakho\\IdeaProjects\\Seminar_01\\src\\Lecture_03\\test2.md")/*;
             String str = "null"*//*) { // выдаст ошибку, так как в блоке try могут быть только тип наследника от типа AutoCloseable
            // указали в блоке try 2 файла для чтения и записи - один для чтения, другой для записи
            while (reader.ready()) { // пока есть что читать
                writer.write(reader.read()); // записываем в writer то, что читаем в reader
            }
        } catch (RuntimeException | IOException e) {
            System.err.println("Catch exception: " + e.getClass().getSimpleName());
        }
        System.out.println("Copy successfully");
        */
        System.out.println("File is builded");
        Date date = new Date();
        try (FileWriter writer = new FileWriter("test")) {
            throw new IOException("Operation field");
        }  catch (IOException e) {
            System.err.println(e.getMessage());
            throw new SavedException("New exception",date, e);
        }
    }
}
