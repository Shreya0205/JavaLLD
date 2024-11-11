package Java;

import java.util.HashMap;

public class DatabaseManagement {

    HashMap<String, Database> dbs;
    private static DatabaseManagement databaseManagement;
    private Database currentDatabase;

    private DatabaseManagement() {
        this.dbs = new HashMap<>();
    }

    public static DatabaseManagement getInstance(){
        if(databaseManagement == null){
            databaseManagement = new DatabaseManagement();
        }
        return databaseManagement;
    }

    public void addDatabase(String name){
        Database database = new Database(name);
        this.dbs.put(name, database);
    }

    public Database useDatabase(String name){

        if(this.dbs.get(name)==null)
            throw new IllegalArgumentException("No db with this name exists");

        this.currentDatabase = this.dbs.get(name);
        return this.currentDatabase;
    }

}
