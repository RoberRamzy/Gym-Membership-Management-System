package backend;

public class MemberDatabase extends Database{
    public MemberDatabase(String fileName) {
        super(fileName);
    }

    @Override
    DatabaseOBJ createRecordFrom(String line) {
        String [] lineArray = line.split(",");
        return new Member(lineArray[0],lineArray[1],lineArray[2],lineArray[3],lineArray[4],lineArray[5]);
    }


}
