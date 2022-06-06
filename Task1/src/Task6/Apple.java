package Task6;

public class Apple implements PhoneFactory {
    @Override
    public Phones createPhone(){
        return new Iphone();
    }
}
