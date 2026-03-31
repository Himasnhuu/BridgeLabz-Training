package marker_interfaces.data_serialization_backup;

import java.io.*;

// Marker interface for serialization
public class UserData implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String email;
    
    public UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "UserData{username='" + username + "', email='" + email + "'}";
    }
}
