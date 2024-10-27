public class Member extends Person{
    private String memberId;
    private String membershipType;
    private String status;

    public Member(){
        super();
        memberId = null;
        membershipType = null;
    }
    public Member(String memberId,String name,String membershipType,String email ,String phoneNumber,String status){
        super(name, email, phoneNumber);
        this.memberId = memberId;
        this.membershipType = membershipType;
        this.status = status;
    }

    @Override
    public String lineRepresentation(){
        String [] dataArray = super.lineRepresentation().split(",");
        return memberId+","+dataArray[0]+","+ membershipType +","+dataArray[1]+","+dataArray[2]+","+status;
    }

    @Override
    public String getSearchKey(){
        return memberId;
    }
}
