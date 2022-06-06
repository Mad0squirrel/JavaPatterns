package Task8.State;

public class ProcessingRequest implements Parcel{
    @Override
    public void makeDelivery() {
        System.out.println("Processing the client's request");
    }
}
