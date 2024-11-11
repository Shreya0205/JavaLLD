import Java.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DatabaseManagement databaseManagement = DatabaseManagement.getInstance();

        databaseManagement.addDatabase("Shreya");
        Database database = databaseManagement.useDatabase("Shreya");

        Table table1 = database.addTableInDatabase("users");

        table1.addColumn(
                new ArrayList<>(Arrays.asList(
                new Column("name", ColumnType.string),
                new Column("age", ColumnType.integer),
                new Column("salary", ColumnType.integer)
            ))
        );

        Row row = new Row();
        row.addDataInRow("name", "shreya");
        row.addDataInRow("age", 10);
        row.addDataInRow("salary", 1000);

        table1.addRow(row);

        Row row2 = new Row();
        row2.addDataInRow("name", "sonal");
        row2.addDataInRow("age", 20);
        row2.addDataInRow("salary", 200);
        table1.addRow(row2);

        Row row3 = new Row();
        row3.addDataInRow("name", "asha");
        row3.addDataInRow("age", 30);
        row3.addDataInRow("salary", 100);
        table1.addRow(row3);

        Row row4 = new Row();
        row4.addDataInRow("name", "asha");
        row4.addDataInRow("age", 30);
        row4.addDataInRow("salary", 5000);

        try {
            table1.addRow(row4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Row row5 = new Row();
        row5.addDataInRow("name", "ashaashaa");
        row5.addDataInRow("age", 30);
        row5.addDataInRow("salary", 5000);

        try {
            table1.addRow(row5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Row row6 = new Row();
        row6.addDataInRow("name", "asha");
        row6.addDataInRow("wrongcol", 5000);
        row6.addDataInRow("age", 30);
        row6.addDataInRow("salary", 1000);

        try {
            table1.addRow(row6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        table1.viewTable();
        table1.getRowWithID(3);
        table1.getRecordWithColumnValue("name", "sonal");

    }
}