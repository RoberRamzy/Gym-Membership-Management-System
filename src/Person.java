abstract public class Person {
    private String name;
    private String email;
    private String phoneNumber;

    public Person(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String lineRepresentation() {
        return name + "," + email + "," + phoneNumber;
    }

    abstract public String getSearchKey();
}


