package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import io.realm.RealmObject;

/**
 * Created by Quinn on 4/6/2015.
 * This class is used to check to see if the user has entered valid information.
 * This class will also be used to check if the user is either: Customer or Employee.
 * This will cause the login to go to either EmployeeHomeFragment or CustomerHomeFragment.
 */
public class LoginInformation extends RealmObject {
    private String mUsername;
    private String mPassword;

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
}
