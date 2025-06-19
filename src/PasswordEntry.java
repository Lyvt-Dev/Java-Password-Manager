import java.io.Serializable;

public class PasswordEntry implements Serializable {
    private String service;
    private String username;
    private String password;

    public PasswordEntry(String service, String username, String password) {
        this.service = service;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Service: " + service + ", Username: " + username + ", Password: " + password;
    }
}
