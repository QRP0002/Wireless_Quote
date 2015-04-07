package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Quinn on 4/6/2015.
 * This class is used to check to see if the user has entered valid information.
 * This class will also be used to check if the user is either: Customer or Employee.
 * This will cause the login to go to either EmployeeHomeFragment or CustomerHomeFragment.
 */
public class LoginInformation {
    String username;
    String password;
    HashMap<String, String> loginDetailCustomer = new HashMap<>();
    HashMap<String, String> loginDetailEmployee = new HashMap<>();

    LoginInformation(String username, String password) {
        this.username = username;
        this.password = password;
    }


    // Sets the username.
    public void setUsername(String username) {
        this.username = username;
    }

    // Gets the username.
    public String getUsername() {
        return this.username;
    }

    // Sets the users password.
    public void setPassword(String password) {
        this.password = password;
    }

    //Gets the users password.
    public String getPassword() {
        return this.password;
    }

    ///////////////////////////////////////////////////////
    /////////////Used for Login Information////////////////
    ///////////////////////////////////////////////////////
    public void addUser(){
        loginDetailEmployee.put("qrp0002", "employee");
        loginDetailCustomer.put("sep0020", "customer");
    }

    public boolean determineEmployee (String username, String password) {
        if (loginDetailEmployee.containsKey(username)) {
            if (loginDetailEmployee.containsValue(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean determineCustomer (String username, String password) {
        if (loginDetailCustomer.containsKey(username)) {
            if (loginDetailCustomer.containsValue(password)) {
                return true;
            }
        }
        return false;
    }
}