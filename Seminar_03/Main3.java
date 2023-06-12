package Seminar_03;

import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {
        try (Counter c = new Counter()) {
            System.out.println(c.getI());
            c.add();
            System.out.println(c.getI());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Counter counter = new Counter();
        System.out.println(counter.getI());
        try {
            counter.add();
            System.out.println(counter.getI());
            counter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        counter.add();
    }
}
