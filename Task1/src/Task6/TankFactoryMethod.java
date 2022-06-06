package Task6;

public class TankFactoryMethod {
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Tank CreateFactoryTank(Class num){
        Tank tank = null;

        if (RusTank.class.equals(num)){
            tank = new RusTank(getRandomNumber(0, 100));
        } else if (USTank.class.equals(num)) {
            tank = new USTank(getRandomNumber(0, 100));
        } else if (GerTank.class.equals(num)) {
            tank = new GerTank(getRandomNumber(0, 100));
        }
        return tank;
    }
}
