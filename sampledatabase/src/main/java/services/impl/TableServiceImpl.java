package services.impl;

import constants.DataType;
import entities.Column;
import entities.Database;
import entities.Row;
import entities.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import services.TableService;

import java.util.ArrayList;
import java.util.HashMap;

@NoArgsConstructor @AllArgsConstructor
public class TableServiceImpl implements TableService {

    public Table createTable(Database database, String name, ArrayList<ArrayList<String>> columns){
        if(database.getTables().containsKey(name)) {
            System.out.println("Table exists");
            return null;
        }

        ArrayList<Column> columnList = processColumns(columns);

        Table table = Table.builder()
                .tableName(name)
                .columns(columnList)
                .build();

        database.getTables().put(name, table);
    }

    public String deleteTable(Database database, String name){
        if(!database.getTables().containsKey(name)) {
            System.out.println("Table does not exist");
            return null;
        }

        database.getTables().remove(name);
        return name;
    }

    public void createIndex(Table table, String colName){
        Column col = table.getColumns().stream().findFirst(col -> col)
    }

    Row insertRow(Table table, HashMap<String, String> values){

    }

    private reindex()

    private ArrayList<Column> processColumns(ArrayList<ArrayList<String>> columns){
        //Place validations

        ArrayList<Column> columnList = new ArrayList<Column>();
        for(ArrayList<String> column : columns){
            Column c = Column.builder()
                    .colIndex(columnList.size()+1)
                    .dataType(DataType.STRING)
                    .name(column.get(0))
                    .isIndexed(false)
                    .build();
            if(column.size()>2){
                c.setDefaultValue(column.get(2));
            }

            columnList.add(c);
        }

        return columnList;
    }

}
