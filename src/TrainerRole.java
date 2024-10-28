import java.lang.Class;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() {
        memberDatabase = new MemberDatabase("src/Member Database.txt");
        classDatabase = new ClassDatabase("src/Class Database.txt");
        registrationDatabase = new MemberClassRegistrationDatabase("src/Registration Database.txt");
    }

    public void addMember (String memberID, String name, String membershipType, String email, String phoneNumber, String status){
        memberDatabase.insertRecord(new Member(memberID,name,membershipType,email,phoneNumber,status));
    }

    public ArrayList<Member> getListOfMembers (){
        ArrayList<DatabaseOBJ> records = memberDatabase.returnAllRecords();
        ArrayList<Member> memberArrayList= new ArrayList<>();
        for(DatabaseOBJ obj : records){
            String [] dataArray = obj.lineRepresentation().split(",");
            memberArrayList.add(new Member(dataArray[0],dataArray[1],dataArray[2],dataArray[3],dataArray[4],dataArray[5]));
        }
        return memberArrayList;
    }

    public void Class (String classID, String className, String trainerID, int duration, int maxParticipants){
        classDatabase.insertRecord(new Class(classID,className,trainerID,duration,maxParticipants));
    }


    public ArrayList<Class> getListOfClasses (){

        ArrayList<DatabaseOBJ> records = memberDatabase.returnAllRecords();
        ArrayList<Class> classArrayList = new ArrayList<>();
        for(DatabaseOBJ obj : records){
            String [] dataArray = obj.lineRepresentation().split(",");
            classArrayList.add(new Class(dataArray[0],dataArray[1],dataArray[2],Integer.parseInt(dataArray[3]),Integer.parseInt(dataArray[4])));
        }
        return classArrayList;
    }

    public void registerMemberForClass (String memberID, String classID, LocalDate registrationDate){

        registrationDatabase.insertRecord(new MemberClassRegistration(memberID, classID , "active",registrationDate));
    }
}
