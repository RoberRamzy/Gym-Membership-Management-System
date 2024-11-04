package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class  Database {
    ArrayList<DatabaseOBJ>records;
    String fileName;

    public Database(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    void readFromFile() {
        try {
            records=new ArrayList<>();

            File obj=new File(fileName);
            Scanner reader= new Scanner(obj);
            while(reader.hasNextLine()){
            String Data=reader.nextLine();
            DatabaseOBJ OBJ= createRecordFrom(Data);
            records.add(OBJ);
        }
        reader.close();}catch (FileNotFoundException e) {
            System.err.println("There was no file found in path:"+ fileName);
            throw new RuntimeException(e);
        }
    }


    abstract DatabaseOBJ createRecordFrom(String line);

   //used to return all records in database
    public ArrayList<DatabaseOBJ> returnAllRecords(){
        return records;

    }


    public boolean contains (String key){
        for (int i = 0; i < records.size(); i++)
        {
            if(records.get(i).getSearchKey().equalsIgnoreCase(key)){
                return true;
            }
       }
        return false;
    }
    public DatabaseOBJ getRecord (String key){
        for (int i = 0; i < records.size(); i++)
        {
            if(records.get(i).getSearchKey().equalsIgnoreCase(key)){
                return records.get(i);
            }
        }
        return null;
    }
    public void insertRecord (DatabaseOBJ record){
        if(records.contains(record)){
            System.out.println("Record already exists");
        }else {
            records.add(record);
        }
    }
    public void deleteRecord(String key){
        boolean flag=false;
        for (int i = 0; i < records.size(); i++) {

            if(records.get(i).getSearchKey().equalsIgnoreCase(key)){
                records.remove(i);
                flag=true;
                System.out.println("Record deleted");
            }

        }
        if(!flag){
            System.out.println("Record is not found");
        }
    }
    public void saveToFile() throws IOException {
        FileWriter writer=new FileWriter(fileName);
        for (int i = 0; i < records.size(); i++) {
            writer.write(records.get(i).lineRepresentation()+System.lineSeparator());

        }
        writer.close();
    }

}
