package Seminar_03.Task3;

import java.io.IOException;

/**
 * Задание 3.3
 * Создайте класс исключения, которое будет возникать при попытке
 * открыть несуществующий файл.
 * Исключение должно отображать понятное для пользователя сообщение
 * об ошибке.
 */
public class NonExistedFileException extends IOException /*RuntimeException*/ {
    public NonExistedFileException() {
        super("Файла не существует");
    }

    public NonExistedFileException(String message) {
        super(message);
    }
}