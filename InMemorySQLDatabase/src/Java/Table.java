package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Table {
    String name;
    HashMap<String, Column> columns;
    HashMap<Integer, Row> rows;
    ArrayList<Column> requiredColumns;
    private AtomicInteger idCounter;

    public Table(String name) {
        this.name = name;
        this.idCounter = new AtomicInteger(1);
        this.columns= new LinkedHashMap<>();
        this.rows = new LinkedHashMap<>();
        this.requiredColumns = new ArrayList<>();
    }

    public void addColumn(ArrayList<Column> column){
        for(Column addedColumn: column)
            this.columns.put(addedColumn.getName(), addedColumn);
    }

    public void addRequiredColumns(Column column){
        this.requiredColumns.add(column);
    }

    public void addRow(Row row){
        HashMap<String, Object> vals = row.getVals();

        for(String columnName: vals.keySet()){

            if( this.columns.containsKey(columnName) == false)
                throw new IllegalArgumentException(columnName + " is not present in table");

            ColumnType type = this.columns.get(columnName).getType();
            IValidator iValidator = ColumnValidatorFactory.getValidator(type);
            iValidator.validate(columnName, vals.get(columnName));
        }

        for (Column column : this.requiredColumns) {
            if (vals.containsKey(column.getName()) == false)
                throw new RuntimeException(column.getName() + "is required.");
        }

        row.setId(idCounter.getAndIncrement());
        this.rows.put(row.getId(), row);
    }

    public void getRowWithID(Integer id){
        if( !this.rows.containsKey(id))
            throw new RuntimeException("this id is not present in table " + this.name);
        this.rows.get(id).toString();
    }

    public void getRecordWithColumnValue(String colName, Object val){
        for (Integer key: this.rows.keySet()){
            if (this.rows.get(key).getColumnValue(colName) == val){
                this.rows.get(key).toString();
                return;
            }
        }
        System.out.println("row does not exist");
    }

    public void viewTable(){
        System.out.println("----------------------------");
        System.out.print("ID | ");
        for(String columnName: this.columns.keySet()){
            System.out.print(columnName + " | ");
        }
        System.out.println();
        for(Integer key: this.rows.keySet()){
            System.out.print(key + " | ");
            for(String columnName: this.columns.keySet()){
                System.out.print(this.rows.get(key).getColumnValue(columnName) + " | ");
            }
            System.out.println();
        }

        System.out.println("----------------------------");
    }

}
