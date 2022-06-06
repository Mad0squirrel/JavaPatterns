package Task7.com.company.Proxy;

public class MainProxy {

    public static void main(String[] args) {
        System.out.println("Data loading and output:");
        Database stdb = new StandartDatabase("oracle.db");
        stdb.display();
        System.out.println("\nLoading data in the absence of data:");
        Database stdb2 = new StandartDatabase(null);
        //stdb2.display();

        System.out.println("-----------------------");
        System.out.println("Loading and outputting data from:");
        Database proxydb = new ProxyDatabase("oracle.db");
        proxydb.display();
        Database proxydb2 = new ProxyDatabase(null);
        //proxydb2.display();
    }
}
