package Task6;

public class Samsung implements PhoneFactory {
    @Override
    public Phones createPhone(){
        return new Galaxy();
    }
}
