package Task8.Strategy;

import Task8.State.Parcel;

public class ProcessingRequest implements Parcel {
    @Override
    public void makeDelivery() {
        System.out.println("Processing the client's request");
    }
}
