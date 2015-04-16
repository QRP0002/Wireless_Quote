package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Quinn on 4/16/2015.
 */
public class UserLoginRequest {

    LoginInformation li = new LoginInformation();
    public String username = li.getmUsername();
    public String password = li.getmPassword();
    private HashMap<String, String> loginDetailEmployee = new HashMap<>();
    Realm realm;

    public void loadUsers(){
        loginDetailEmployee.put("quinn", "emp");
    }

    public boolean determineEmployee (String username, String password) {
        if (loginDetailEmployee.containsKey(username)) {
            if (loginDetailEmployee.containsValue(password)) {
                return true;
            }
        }
        return false;
    }

    public RealmResults determineCustomer (String username, String password){
        RealmResults<LoginInformation> users = realm.where(LoginInformation.class)
                .equalTo("username", username)
                .equalTo("password", password)
                .findAll();
        if (users.size() == 0) {
            return users;
        }
        return users;
    }

    public boolean determineCustomerRequest(RealmResults users) {
        if(users.size() != 0) {
            return true;
        }
        return false;
    }
}
