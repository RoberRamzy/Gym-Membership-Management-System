package backend;

public class TrainerDatabase extends Database{
    public TrainerDatabase(String fileName) {
        super(fileName);

    }

    @Override
    DatabaseOBJ createRecordFrom(String line) {
        String [] lineArray = line.split(",");
        return new Trainer(lineArray[0],lineArray[1],lineArray[2],lineArray[3],lineArray[4]);
    }

}
