package services;

import entities.Database;
import entities.Row;
import entities.Table;

import java.util.ArrayList;
import java.util.HashMap;

public interface TableService {
    Table createTable(Database database, String name, ArrayList<ArrayList<String>> columns);
    String deleteTable(Database database, String name);
    Row insertRow(Table table, HashMap<String, String> values);
    ArrayList<String> deleteRows(Table table, HashMap<String, String> filters);
    ArrayList<Row> updateRow(Table table, HashMap<String, String> values, HashMap<String, String> filters);
    void createIndex(Table table, String colName);
}
