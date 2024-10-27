import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends Database{

    public MemberClassRegistrationDatabase(String fileName) {
        super(fileName);
    }

    @Override
    DatabaseOBJ createRecordFrom(String line) {
        String [] lineArray = line.split(",");
        return new MemberClassRegistration(lineArray[0],lineArray[1], lineArray[2],LocalDate.parse(lineArray[3]));
    }


}
