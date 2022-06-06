package Task8.Strategy;

import Task8.State.Parcel;
import Task8.State.ProcessingRequest;

public class Main_Strategy {

    public static void main(String[] args) {
        PostOffice po = new PostOffice();

        po.stateOfParcel(new ProcessingRequest());
        po.makeDelivery();

        po.stateOfParcel(new PreparingPackage());
        po.makeDelivery();

        po.stateOfParcel(new CustomsCheck());
        po.makeDelivery();

        po.stateOfParcel(new ServingToCustomer());
        po.makeDelivery();
    }
}
