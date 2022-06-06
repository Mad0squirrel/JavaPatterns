package Task7.com.company.Proxy;

public class StandartDatabase implements Database{
    String db;
    public StandartDatabase(String db){
        this.db = db;
        load();
    }
    void load(){
        System.out.println("Loading data from "+db);
    }
    @Override
    public void display() {
        System.out.println("Data output from "+db);
    }
}
