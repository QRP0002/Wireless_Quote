package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import io.realm.RealmObject;

/**
 * Created by Quinn on 4/6/2015.
 * This class is used to check to see if the user has entered valid information.
 * This class will also be used to check if the user is either: Customer or Employee.
 * This will cause the login to go to either EmployeeHomeFragment or CustomerHomeFragment.
 */
public class LoginInformation extends RealmObject {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
