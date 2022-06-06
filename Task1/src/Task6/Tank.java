package Task6;

public class Tank {
    private int number;

    public Tank(int number){
        this.number = number;
    }

    public void CreateTank(){
        System.out.println(this.getClass().getTypeName() + " were produced " + number + " pieces");
    }
}
