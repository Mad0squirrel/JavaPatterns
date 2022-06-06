package Task8.State;

public class CustomsCheck implements Parcel{
    @Override
    public void makeDelivery() {
        System.out.println("Checking the parcel at customs");
    }
}
