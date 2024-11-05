package backend;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static constants.FileNames.*;

public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() {
        memberDatabase = new MemberDatabase(MEMBER_FILENAME);
        classDatabase = new ClassDatabase(CLASS_FILENAME);
        registrationDatabase = new MemberClassRegistrationDatabase(REGISTRATION_FILENAME);
    }

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        if (!memberDatabase.contains(memberID)) {
            memberDatabase.insertRecord(new Member(memberID, name, membershipType, email, phoneNumber, status));
            System.out.println("Data is saved" + memberDatabase.getRecord(memberID).lineRepresentation());
        }
    }

    public ArrayList<Member> getListOfMembers() {
        ArrayList<DatabaseOBJ> records = memberDatabase.returnAllRecords();
        ArrayList<Member> memberArrayList = new ArrayList<>();
        for (DatabaseOBJ obj : records) {
            String[] dataArray = obj.lineRepresentation().split(",");
            memberArrayList.add(new Member(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]));
            System.out.println(memberArrayList.getLast().lineRepresentation());
        }
        return memberArrayList;
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        if (!classDatabase.contains(classID)) {
            classDatabase.insertRecord(new backend.Class(classID, className, trainerID, duration, maxParticipants));
        }
    }


    public ArrayList<backend.Class> getListOfClasses() {
        ArrayList<DatabaseOBJ> records = classDatabase.returnAllRecords();
        ArrayList<backend.Class> classArrayList = new ArrayList<>();
        for (DatabaseOBJ obj : records) {
            String[] dataArray = obj.lineRepresentation().split(",");
            classArrayList.add(new backend.Class(dataArray[0], dataArray[1], dataArray[2], Integer.parseInt(dataArray[3]), Integer.parseInt(dataArray[4])));
        }
        return classArrayList;
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (classDatabase.contains(classID)) {
            backend.Class found = (backend.Class) classDatabase.getRecord(classID);
            if (found.getAvailableSeats() > 0) {
                if (!registrationDatabase.contains(memberID + "-" + classID)) {
                    registrationDatabase.insertRecord(new MemberClassRegistration(memberID, classID, "active", registrationDate));
                    found.setAvailableSeats(found.getAvailableSeats() - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        if (registrationDatabase.contains(memberID + "-" + classID)) {
            MemberClassRegistration registration = (MemberClassRegistration) registrationDatabase.getRecord(memberID +"-"+classID);
            LocalDate registrationDate = registration.getRegistrationDate();
            LocalDate dateThreeDaysFromRegistration = registrationDate.plusDays(3);
            if (LocalDate.now().isBefore(dateThreeDaysFromRegistration)) {
                registrationDatabase.deleteRecord(registration.getSearchKey());
                backend.Class found = (Class) classDatabase.getRecord(classID);
                found.setAvailableSeats(found.getAvailableSeats() + 1);
                return true;
            }
        }

        return false;
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        ArrayList<DatabaseOBJ> records = registrationDatabase.returnAllRecords();
        ArrayList<MemberClassRegistration> classArrayList = new ArrayList<>();
        for (DatabaseOBJ obj : records) {
            String[] dataArray = obj.lineRepresentation().split(",");
            classArrayList.add(new MemberClassRegistration(dataArray[0], dataArray[1], dataArray[2], LocalDate.parse(dataArray[3])));
        }
        return classArrayList;
    }

    public void logout() {
        try {
            memberDatabase.saveToFile();
            classDatabase.saveToFile();
            registrationDatabase.saveToFile();
        } catch (IOException e) {
            System.err.println("There was no file found in path for memberDatabaase");
            throw new RuntimeException(e);
        }
        try {
            classDatabase.saveToFile();
        } catch (IOException e) {
            System.err.println("There was no file found in path for claasDatabaase");
            throw new RuntimeException(e);
        }
        try {
            registrationDatabase.saveToFile();
        } catch (IOException e) {
            System.err.println("There was no file found in path for registrationDatabaase");
            throw new RuntimeException(e);
        }
        System.out.println("All data Saved Successfully");
    }
}
