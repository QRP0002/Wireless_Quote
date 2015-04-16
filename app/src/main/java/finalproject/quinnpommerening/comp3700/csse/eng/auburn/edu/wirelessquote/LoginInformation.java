package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import java.util.HashMap;
import java.util.Hashtable;
import io.realm.RealmList;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Quinn on 4/6/2015.
 * This class is used to check to see if the user has entered valid information.
 * This class will also be used to check if the user is either: Customer or Employee.
 * This will cause the login to go to either EmployeeHomeFragment or CustomerHomeFragment.
 */
public class LoginInformation extends RealmObject {
    private String mUsername;
    private String mPassword;

    LoginInformation(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public RealmResults determineCustomer (String username, String password) {
        RealmResults<Users> users = realm.where(Users.class)
                .equalTo("username", username)
                .equalTo("password", password)
                .findAll();
        if (users.size() == 0) {
            return users;
        }
        return users;
    }

    public boolean determineCustomerRequest(RealmResults users) {

    }
}
