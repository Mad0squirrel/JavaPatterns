package Task8.State;

public class Main_State {

    public static void main(String[] args) {
        Parcel parcel = new ProcessingRequest();
        PostOffice po = new PostOffice();

        po.stateOfParcel(parcel);
        for (int i = 0; i < 12; i++){
            po.makeDelivery();
            po.changeState();
            if (i % 4 == 0) {
                System.out.println("----NEW PACKAGE----");
            }
        }

    }
}
