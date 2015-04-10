package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 *
 */
public class RemoveCustomerFragment extends Fragment {
    private Button mRemoveCustomer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_remove_customer, container, false);

        mRemoveCustomer = (Button) view.findViewById(R.id.remove_button);
        mRemoveCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editRemoveUser = (EditText) view.findViewById(R.id.remove_username);
                String removeUser = editRemoveUser.getText().toString();
                String password = "";
                LoginInformation li = new LoginInformation(removeUser, password);

               //li.removeCustomer(removeUser);
                Fragment display = new EmployeeManageQuoteFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return view;
    }

}
