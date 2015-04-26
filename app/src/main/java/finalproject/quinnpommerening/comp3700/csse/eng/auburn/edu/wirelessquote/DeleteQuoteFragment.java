package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;


/**
 *
 */
public class DeleteQuoteFragment extends Fragment {
    private Button mRemoveQuoteButton;

    public static DeleteQuoteFragment newInstance() {
        DeleteQuoteFragment f = new DeleteQuoteFragment();
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
       final View view = inflater.inflate(R.layout.fragment_delete_quote, container, false);

        mRemoveQuoteButton = (Button) view.findViewById(R.id.remove_quote_button);
        mRemoveQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editRemoveUser = (EditText) view.findViewById(R.id.remove_quote_username);
                String removeUser = editRemoveUser.getText().toString();

                Realm realm = Realm.getInstance(getActivity());
                realm.beginTransaction();
                CustomerInformation ci = realm.where(CustomerInformation.class)
                        .equalTo("username", removeUser).findFirst();
                BuildInformation bi = ci.getBi();
                EquipmentController ec = ci.getEc();

                ci.setFirstName("");
                ci.setLastName("");
                ci.setFirstName("");
                ci.setLastName("");
                ci.setMiddleI("");
                ci.setCompanyName("");
                ci.setCompanyAddress("");
                bi.setBuilding("");
                bi.setFloors("");
                bi.setRooms("");
                bi.setUnits("");
                ec.setEquipmentOne("");
                ec.setEquipmentTwo("");
                ec.setEquipmentThree("");
                realm.commitTransaction();

                Fragment display = EmployeeManageQuoteFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return view;
    }

}
