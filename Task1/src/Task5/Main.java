package Task5;

public class Main {
    public static void main(String[] args) {
        Singleton1 singleton1 = new Singleton1();
        System.out.println(singleton1.getInstance());

        Singleton2 singleton2 = Singleton2.INSTANCE;
        System.out.println(singleton2.getInstance());

        Singleton3 singleton3 = new Singleton3();
        System.out.println(singleton3.getInstance());
    }
}
