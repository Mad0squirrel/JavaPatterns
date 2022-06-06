package Task8.State;

public class PostOffice {
    Parcel parcel;
    public void stateOfParcel(Parcel parcel){
        this.parcel = parcel;
    }
    public void changeState(){
        if (parcel instanceof ProcessingRequest){
            stateOfParcel(new PreparingPackage());
        } else if (parcel instanceof PreparingPackage){
            stateOfParcel(new CustomsCheck());
        } else if (parcel instanceof CustomsCheck){
            stateOfParcel(new ServingToCustomer());
        } else if (parcel instanceof ServingToCustomer){
            stateOfParcel(new ProcessingRequest());
        }
    }
    public void makeDelivery() {
        parcel.makeDelivery();
    }
}
