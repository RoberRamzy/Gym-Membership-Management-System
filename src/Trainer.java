public class Trainer extends Person implements DatabaseOBJ{
    private String trainerId;
    private String speciality;

    public Trainer(){
        super();
        trainerId = null;
        speciality = null;
    }
    public Trainer(String trainerId,String name,String email,String speciality ,String phoneNumber){
        super(name, email, phoneNumber);
        this.trainerId = trainerId;
        this.speciality = speciality;
    }

    @Override
    public String lineRepresentation(){
        String [] dataArray = super.lineRepresentation().split(",");
        return trainerId+","+dataArray[0]+","+dataArray[1]+","+speciality+","+dataArray[2];
    }

    @Override
    public String getSearchKey(){
     return trainerId;
    }
}
