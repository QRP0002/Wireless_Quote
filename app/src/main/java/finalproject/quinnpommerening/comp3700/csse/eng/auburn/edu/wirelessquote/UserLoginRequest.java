package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import android.content.Context;

import java.util.HashMap;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Quinn on 4/16/2015.
 */
public class UserLoginRequest {

    private HashMap<String, String> loginDetailEmployee = new HashMap<>();
    private Realm realm;

    /**
     * Creates a new UserLoginRequest.
     *
     * @param context required to create the Realm instance that will be used.
     */
    public UserLoginRequest(Context context) {
        realm = Realm.getInstance(context);
    }

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
        return users.size() != 0;
    }
}
