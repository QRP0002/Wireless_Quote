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

import io.realm.Realm;


/**
 *
 */
public class CustomerInformationFragment extends Fragment {

    public static CustomerInformationFragment newInstance() {
        CustomerInformationFragment f = new CustomerInformationFragment();
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
        final View view = inflater.inflate(R.layout.fragment_customer_information, container, false);

        Button mNextButton = (Button) view.findViewById(R.id.next_button_customer);
        mNextButton.setOnClickListener(new View.OnClickListener() {

            /**
             * This button will go to the next page, BuildingInformationFragment.
             * @param v just the view.
             */
            @Override
            public void onClick(View v) {
                EditText editUserName = (EditText) view.findViewById(R.id.new_username);
                EditText editPassword = (EditText) view.findViewById(R.id.new_password);
                EditText editFirstName = (EditText) view.findViewById(R.id.new_customer_first_name);
                EditText editLastName = (EditText) view.findViewById(R.id.new_customer_last_name);
                EditText editMiddleI = (EditText) view.findViewById(R.id.new_customer_middle);
                EditText editCompanyName = (EditText) view.findViewById(R.id.new_company_name);
                EditText editCompanyAddress = (EditText) view.findViewById(R.id.new_company_address);

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editUserName.getWindowToken(), 0);

                final String newUserName = editUserName.getText().toString();
                final String newPassword = editPassword.getText().toString();
                final String newFirstName = editFirstName.getText().toString();
                final String newLastName = editLastName.getText().toString();
                final String newMiddleI = editMiddleI.getText().toString();
                final String newCompanyName = editCompanyName.getText().toString();
                final String newCompanyAddress = editCompanyAddress.getText().toString();

                Realm realm = Realm.getInstance(getActivity());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        CustomerInformation ci = realm.createObject(CustomerInformation.class);
                        ci.setUsername(newUserName);
                        ci.setPassword(newPassword);
                        ci.setFirstName(newFirstName);
                        ci.setLastName(newLastName);
                        ci.setMiddleI(newMiddleI);
                        ci.setCompanyName(newCompanyName);
                        ci.setCompanyAddress(newCompanyAddress);
                    }
                });

                Fragment display = BuildingInformationFragment.newInstance(newUserName);
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return view;
    }

}
