package Task6;

public class Iphone implements Phones {
    @Override
    public void Creating(){
        System.out.println("Creating new Iphone");
    }
    @Override
    public void Broken(){
        System.out.println("Iphone is broken");
    }
}
