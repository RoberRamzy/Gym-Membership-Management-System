import java.io.IOException;
import java.util.ArrayList;

public class AdminRole {
    private TrainerDatabase Database;
    public AdminRole(){
        Database=new TrainerDatabase("backend/trainerDatabase");
        Database.readFromFile();
    }
    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber){
        if(!Database.contains(trainerId)) {
            Trainer trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
            Database.insertRecord(trainer);
        }
    }
    public ArrayList<Trainer> getListOfTrainers (){
        ArrayList<Trainer> trainers;
        ArrayList<DatabaseOBJ> data= Database.returnAllRecords();
        trainers= (ArrayList<Trainer>) data.clone();
        return trainers;
    }
    public void removeTrainer(String key){
        Database.deleteRecord(key);
    }
    public void logout() throws IOException {
        Database.saveToFile();
    }

}
