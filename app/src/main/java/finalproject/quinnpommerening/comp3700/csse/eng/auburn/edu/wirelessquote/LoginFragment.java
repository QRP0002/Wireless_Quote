package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;


/**
 *
 */
public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {
        LoginFragment f = new LoginFragment();
        Bundle args = new Bundle();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button mLoginButton = (Button) view.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText editUsername = (EditText) view.findViewById(R.id.username_login);
                EditText editPassword = (EditText) view.findViewById(R.id.password_login);
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editUsername.getWindowToken(), 0);

                final String username = editUsername.getText().toString();
                final String password = editPassword.getText().toString();

                Realm realm = Realm.getInstance(getActivity());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        LoginInformation li = realm.createObject(LoginInformation.class);
                        li.setUsername(username);
                        li.setPassword(password);
                    }
                });

                UserLoginRequest user = new UserLoginRequest(getActivity());
                user.loadUsers();
                if (user.determineEmployee(username, password)) {
                    Fragment display = EmployeeHomeFragment.newInstance();
                    getFragmentManager().beginTransaction()
                            .addToBackStack("fragment")
                            .replace(R.id.fragment_container, display, "display")
                            .commit();
                } else if (user.determineCustomerRequest(user.determineCustomer(username, password))) {
                    Fragment display = CustomerHomeFragment.newInstance();
                    getFragmentManager().beginTransaction()
                            .addToBackStack("fragment")
                            .replace(R.id.fragment_container, display, "display")
                            .commit();
                } else {
                    Toast.makeText(getActivity(),
                            R.string.incorrect_info,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
