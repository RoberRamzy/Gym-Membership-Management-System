import java.time.LocalDate;

public class MemberClassRegistration implements DatabaseOBJ {
    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationStatus(String status){
        this.status = status;
    }

    @Override
    public String getSearchKey() {

        return  memberID+"-"+classID;
    }

    @Override
    public String lineRepresentation() {
        return memberID + "," + classID + "," + status+","+ registrationDate;
    }

}
