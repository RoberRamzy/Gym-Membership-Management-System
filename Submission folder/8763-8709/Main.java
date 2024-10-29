import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        // Admin Role
        AdminRole admin = new AdminRole();
        admin.addTrainer("T1001", "David", "david@example.com", "Yoga", "0123456789");
        admin.addTrainer("T1002", "Sarah", "sarah@example.com", "Strength Training", "0123456788");
        
        System.out.println("List of Trainers:");
        for (int i = 0; i < admin.getListOfTrainers().size(); i++) {
            System.out.println(admin.getListOfTrainers().get(i).lineRepresentation());
        }

        // Trainer Role
        TrainerRole trainerRole = new TrainerRole();
        trainerRole.addMember("M1001", "John", "Monthly", "john@gmail.com", "01012345678", "active");
        trainerRole.addClass("C101", "Yoga", "T1001", 60, 30);

        // List Members and Classes
        System.out.println("\nList of Members:");
        for (int i = 0; i < trainerRole.getListOfMembers().size(); i++) {
            System.out.println(trainerRole.getListOfMembers().get(i).lineRepresentation());
        }

        System.out.println("\nList of Classes:");
        for (int i = 0; i < trainerRole.getListOfClasses().size(); i++) {
            System.out.println(trainerRole.getListOfClasses().get(i).lineRepresentation());
        }

        // Register Member for Class
        /*we need to check if it returns bool*/
        boolean registrationSuccess = trainerRole.registerMemberForClass("M1001", "C101", LocalDate.now());
        System.out.println("\nRegistration Successful: " + registrationSuccess);

        // List Registrations
        System.out.println("\nList of Registrations:");
        for (int i = 0; i < trainerRole.getListOfRegistrations().size(); i++) {
            System.out.println(trainerRole.getListOfRegistrations().get(i).lineRepresentation());
        }

        // Cancel Registration
        boolean cancellationSuccess = trainerRole.cancelRegistration("M1001", "C101");
        System.out.println("\nCancellation Successful: " + cancellationSuccess);

        // Logout Admin
        admin.logout();
        trainerRole.logout();
    }
}