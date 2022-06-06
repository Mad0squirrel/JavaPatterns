package Task7.com.company.Proxy;

public class ProxyDatabase implements Database{
    String db;
    StandartDatabase stdb;
    public ProxyDatabase(String db){
        this.db = db;
    }
    @Override
    public void display() {
        if (stdb == null){
            System.out.println("Creating an empty database...");
            stdb = new StandartDatabase(db);
        }
        stdb.display();
    }
}
