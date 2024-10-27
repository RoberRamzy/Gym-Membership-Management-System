public class ClassDatabase extends Database{
    public ClassDatabase(String fileName) {
        super(fileName);
    }

    @Override
    DatabaseOBJ createRecordFrom(String line) {
        String [] lineArray = line.split(",");
        return new Class(lineArray[0],lineArray[1],lineArray[2],Integer.parseInt(lineArray[3]),Integer.parseInt(lineArray[4]));
    }


}
