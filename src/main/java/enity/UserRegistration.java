package enity;

public class UserRegistration {

    String name;
    String secondName;
    String lastName;
    String password;
    String email;
    int accessRights;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(int accessRights) {
        this.accessRights = accessRights;
    }
}
