public class Class implements DatabaseOBJ {
    private String ClassID;
    private String ClassName;
    private String trainerID;
    private int duration;
    private int availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        ClassID = classID;
        ClassName = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String lineRepresentation() {
        return ClassID + "," + ClassName + "," + trainerID + "," + duration+","+availableSeats;

    }

    @Override
    public String getSearchKey() {
        return ClassID;
    }
}
