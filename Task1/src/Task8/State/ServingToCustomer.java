package Task8.State;

public class ServingToCustomer implements Parcel{
    @Override
    public void makeDelivery() {
        System.out.println("Delivery of the parcel to the client");
    }
}
