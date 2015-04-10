package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


/**
 *
 */
public class CustomerInformationFragment extends Fragment {
    private Button mNextButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_customer_information, container, false);

        mNextButton = (Button)view.findViewById(R.id.next_button_customer);
        mNextButton.setOnClickListener(new View.OnClickListener() {

            /**
             * This button will go to the next page, BuildingInformationFragment.
             * @param v just the view.
             */
            @Override
            public void onClick(View v) {
                Fragment display = new BuildingInformationFragment();

                EditText editUserName = (EditText) view.findViewById(R.id.new_username);
                EditText editPassword = (EditText) view.findViewById(R.id.new_password);
                EditText editFirstName = (EditText) view.findViewById(R.id.new_customer_first_name);
                EditText editLastName = (EditText) view.findViewById(R.id.new_customer_last_name);
                EditText editMiddleI = (EditText) view.findViewById(R.id.new_customer_middle);
                EditText editCompanyName = (EditText) view.findViewById(R.id.new_company_name);
                EditText editCompanyAddress = (EditText) view.findViewById(R.id.new_company_address);

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editUserName.getWindowToken(), 0);

                String newUserName = editUserName.getText().toString();
                String newPassword = editPassword.getText().toString();
                String newFirstName = editFirstName.getText().toString();
                String newLastName = editLastName.getText().toString();
                String newMiddleI = editMiddleI.getText().toString();
                String newCompanyName = editCompanyName.getText().toString();
                String newCompanyAddress = editCompanyAddress.getText().toString();

                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return view;
    }

}
