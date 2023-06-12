package Seminar_03;

import java.io.IOException;

/**
 Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */
public class Counter implements AutoCloseable{
    int i = 0;
    boolean closed = false;
    public  int getI (){
        return this.i;
    }
    public void add() throws IOException {
        if (closed) {
            throw new IOException("Ресурс закрыт");
        }
        this.i++;
    }

    @Override
    public void close() throws Exception {
        this.closed = true;
    }
}