package Java;

public class Column {
    String name;
    ColumnType type;

    public Column(String name, ColumnType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ColumnType getType() {
        return type;
    }
}
