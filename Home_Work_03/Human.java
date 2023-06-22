package Home_Work_03;

public class Human {
    String surname;
    String name;
    String patronymic;
    String birthday;
    String gender;
    String phone;


    public Human() {
    }
    public Human(String surname, String name, String patronymic, String birthday, String gender, String phone) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    }
    public Human(String[] data) {
        this.surname = data[0];
        this.name = data[1];
        this.patronymic = data[2];
        this.birthday = data[3];
        this.phone = data[4];
        this.gender = data[5].toLowerCase();
    }
    public String toString(){
        return surname + " " + name + " " + patronymic + " " + birthday + " " + phone + " " + gender;
    }
}
