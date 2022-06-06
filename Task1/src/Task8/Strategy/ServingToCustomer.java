package Task8.Strategy;

import Task8.State.Parcel;

public class ServingToCustomer implements Parcel {
    @Override
    public void makeDelivery() {
        System.out.println("Delivery of the parcel to the client");
    }
}
