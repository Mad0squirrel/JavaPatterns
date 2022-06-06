package Task8.Strategy;

import Task8.State.Parcel;

public class PreparingPackage implements Parcel {
    @Override
    public void makeDelivery() {
        System.out.println("Package and package assembly");
    }
}
