package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 *
 */
public class LoginFragment extends Fragment {
    private Button mLoginButton;
    private Boolean mFlag = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        mLoginButton = (Button)v.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText editText = (EditText) v.findViewById(R.id.username_login);
                EditText editText1 = (EditText) v.findViewById(R.id.password_login);
                String username = editText.getText().toString();
                String password = editText1.getText().toString().toLowerCase();

                LoginInformation li = new LoginInformation(username, password);
                li.addUser(); //Fills the HashMap with the preset list.
                if (li.determineEmployee(username, password)) {
                    Fragment display = new EmployeeHomeFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack("fragment")
                            .add(R.id.fragment_container, display, "display")
                            .commit();
                } else if (li.determineCustomer(username, password)) {
                    Fragment display = new CustomerHomeFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack("fragment")
                            .add(R.id.fragment_container, display, "display")
                            .commit();
                } else {
                    Toast.makeText(getActivity(),
                            R.string.incorrect_info,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
