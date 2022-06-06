package containpackage.model.entities.containers;

import java.util.LinkedHashSet;
public class Registry{

    private LinkedHashSet<Record> records;

    public Registry() {
        this.records = new LinkedHashSet<>();
    }

    public LinkedHashSet<Record> getRecords() {
        return records;
    }

    public void addRecord(Record record){
        getRecords().add(record);
    }

    public void addRecords(LinkedHashSet<Record> records){
        for(Record record : records){
            addRecord(record);
        }
    }

    @Override
    public String toString() {
        return "Регистор " +
                "Записей" + records ;
    }

}

