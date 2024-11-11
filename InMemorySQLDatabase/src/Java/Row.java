package Java;

import java.util.HashMap;

public class Row {
    Integer id;
    HashMap<String, Object> vals;

    public Row() {
        this.id = null;
        this.vals = new HashMap<>();
    }

    public void addDataInRow(String name, Object val){
        this.vals.put(name, val);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setColumn(String columnName, Object val) {
        this.vals.put(columnName, val);
    }

    public Object getColumnValue(String colName){
        return this.vals.get(colName);
    }

    @Override
    public String toString() {
        System.out.print(id + " | ");
        for(String key: this.vals.keySet()){
            System.out.print(this.vals.get(key) + " | ");
        }
        System.out.println();
        return null;
    }

    public HashMap<String, Object> getVals() {
        return vals;
    }
}
