package Task8.Strategy;

import Task8.State.Parcel;

public class CustomsCheck implements Parcel {
    @Override
    public void makeDelivery() {
        System.out.println("Checking the parcel at customs");
    }
}
