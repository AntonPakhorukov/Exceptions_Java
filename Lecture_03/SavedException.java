package Lecture_03;
// Cоздание своего класса исключения

import java.io.IOException;
import java.util.Date;

public class SavedException extends IOException { // указываем, что новое исключение будет наследоваться от IOException
    private Date startDate;
    public SavedException(String message, Date startDate, Exception e) { // добавили конструктор, который будет принимать String
        // в качестве message, и некий Exception, благодаря которому мы хотим создать свой exception - то, что является
        // нашим предком по stack trace
        super(message, e); // и вызываем super
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return startDate;
    }
}
