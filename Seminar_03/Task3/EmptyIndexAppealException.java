package Seminar_03.Task3;
/**
 * Задание 3.2
 Создайте класс исключений, которое будет возникать при обращении
 к пустому элементу в массиве ссылочного типа.
 Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
public class EmptyIndexAppealException extends RuntimeException {
    public EmptyIndexAppealException() {
        super("По указанному индексу находится Null");
    }
}