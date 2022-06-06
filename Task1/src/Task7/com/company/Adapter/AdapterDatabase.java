package Task7.com.company.Adapter;

public class AdapterDatabase extends AppDatabase implements Database {
    @Override
    public void load() {
        loadTable();
    }

    @Override
    public void insert() {
        insertTable();
    }

    @Override
    public void remove() {
        removeTable();
    }

    @Override
    public void update() {
        updateTable();
    }
}
