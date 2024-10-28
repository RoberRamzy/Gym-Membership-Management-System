public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole(String fileName) {
        memberDatabase = new MemberDatabase(fileName);
        classDatabase = new ClassDatabase(fileName);
        registrationDatabase = new MemberClassRegistrationDatabase(fileName);
    }


}
