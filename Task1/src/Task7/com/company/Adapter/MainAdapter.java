package Task7.com.company.Adapter;

import Task7.com.company.Adapter.AdapterDatabase;
import Task7.com.company.Adapter.Database;

public class MainAdapter {

    public static void main(String[] args) {
        Database db = new AdapterDatabase();
        db.load();
        db.insert();
        db.update();
        db.remove();
    }
}
