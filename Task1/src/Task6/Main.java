package Task6;

public class Main {
    public static void main(String[] args) {
        //Фабричный метод
        TankFactoryMethod tankFactoryMethod = new TankFactoryMethod();
        Tank Armata = tankFactoryMethod.CreateFactoryTank(RusTank.class);
        Tank Abrams = tankFactoryMethod.CreateFactoryTank(USTank.class);
        Tank Leopard = tankFactoryMethod.CreateFactoryTank(GerTank.class);
        Armata.CreateTank();
        Abrams.CreateTank();
        Leopard.CreateTank();
        System.out.println("------------------------------------------------");
        //Абстрактная фабрика
        PhoneFactory samsung = new Samsung();
        Phones Galaxy = samsung.createPhone();
        Galaxy.Creating();
        Galaxy.Broken();
        PhoneFactory apple = new Apple();
        Phones Iphone = apple.createPhone();
        Iphone.Creating();
        Iphone.Broken();
        System.out.println("------------------------------------------------");
        //Строитель
        Good good = new Good.Builder().addGood("Potato")
                .addGood("Beet")
                .addGood("Cucumber")
                .addGood("Carrot")
                .addGood("Tomato")
                .build();
        System.out.println(good.list);
        System.out.println("------------------------------------------------");

        //Прототип
        Toy robot = new Toy("Robot");
        Toy clone = robot.copy();
        System.out.println(robot);
        System.out.println(clone);
        System.out.println("------------------------------------------------");

    }
}
