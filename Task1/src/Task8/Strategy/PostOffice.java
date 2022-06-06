package Task8.Strategy;

import Task8.State.Parcel;

public class PostOffice {
    Parcel parcel;
    public void stateOfParcel(Parcel parcel){
        this.parcel = parcel;
    }

    public void makeDelivery() {
        parcel.makeDelivery();
    }
}
