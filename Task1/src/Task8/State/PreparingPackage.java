package Task8.State;

public class PreparingPackage implements Parcel {
    @Override
    public void makeDelivery() {
        System.out.println("Package assembly");
    }
}
