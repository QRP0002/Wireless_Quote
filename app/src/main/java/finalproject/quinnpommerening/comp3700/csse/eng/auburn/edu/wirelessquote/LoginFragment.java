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


/**
 *
 */
public class LoginFragment extends Fragment {
    private Button mLoginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_login, container, false);
        mLoginButton = (Button)view.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText editText = (EditText) view.findViewById(R.id.username_login);
                EditText editText1 = (EditText) view.findViewById(R.id.password_login);
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                String username = editText.getText().toString();
                String password = editText1.getText().toString();

                LoginInformation li = new LoginInformation(username, password);
                li.loadUsers(); //Fills the HashMap with the preset list.
                if (li.determineEmployee(username, password)) {
                    Fragment display = new EmployeeHomeFragment();
                    getFragmentManager().beginTransaction()
                            .addToBackStack("fragment")
                            .replace(R.id.fragment_container, display, "display")
                            .commit();
                } else if (li.determineCustomer(username, password)) {
                    Fragment display = new CustomerHomeFragment();
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
