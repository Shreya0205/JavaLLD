package Java;

import java.util.HashMap;

public class Database {

    String name;
    HashMap<String, Table> tables;

    public Database(String name) {
        this.name = name;
        this.tables = new HashMap<>();
    }

    public Table addTableInDatabase(String tableName){
        Table table = new Table(name);
        this.tables.put(name, table);
        return table;
    }

    void removeTable(String name){
        this.tables.remove(name);
    }

}
