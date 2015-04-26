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
public class EditQuoteFragment extends Fragment {
    private String mUsername;
    private Button mSubmitButton;
    private Button mEmailButton;
    String editPassword;
    String editFirstName;
    private String editLastName;
    private String editMiddleI;
    private String editCompanyName;
    private String editCompanyAddress;
    private String editBuildings;
    private String editFloors;
    private String editUnits;
    private String editRooms;
    private String editEquipmentOne;
    private String editEquipmentTwo;
    private String editEquipmentThree;
    BuildInformation bi;
    EquipmentController ec;

    public static EditQuoteFragment newInstance(String username) {
        EditQuoteFragment f = new EditQuoteFragment();
        Bundle args = new Bundle();
        args.putString("username", username);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUsername = getArguments().getString("username");

        Realm realm = Realm.getInstance(getActivity());
        CustomerInformation ci = realm.where(CustomerInformation.class)
                .equalTo("username", mUsername).findFirst();

        editPassword = ci.getPassword();
        editFirstName = ci.getFirstName();
        editLastName = ci.getLastName();
        editMiddleI = ci.getMiddleI();
        editCompanyName = ci.getCompanyName();
        editCompanyAddress = ci.getCompanyAddress();
        bi = ci.getBi();
        ec = ci.getEc();
        editBuildings = bi.getBuilding();
        editFloors = bi.getFloors();
        editUnits = bi.getUnits();
        editRooms = bi.getRooms();
        editEquipmentOne = ec.getEquipmentOne();
        editEquipmentTwo = ec.getEquipmentTwo();
        editEquipmentThree = ec.getEquipmentThree();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_edit_quote, container, false);

        mSubmitButton = (Button) view.findViewById(R.id.edit_submit_quote);
        mEmailButton = (Button) view.findViewById(R.id.edit_email_quote);

        final EditText editPass = (EditText) view.findViewById(R.id.edit_text1);
        final EditText editFirst = (EditText) view.findViewById(R.id.edit_text2);
        final EditText editLast = (EditText) view.findViewById(R.id.edit_text3);
        final EditText editMiddle = (EditText) view.findViewById(R.id.edit_text4);
        final EditText editCompanyN = (EditText) view.findViewById(R.id.edit_text5);
        final EditText editCompanyA = (EditText) view.findViewById(R.id.edit_text6);
        final EditText editBuild = (EditText) view.findViewById(R.id.edit_text7);
        final EditText editFloor = (EditText) view.findViewById(R.id.edit_text8);
        final EditText editUnit = (EditText) view.findViewById(R.id.edit_text9);
        final EditText editRoom = (EditText) view.findViewById(R.id.edit_text10);

        editPass.setHint("Password: " + editPassword);
        editFirst.setHint("First Name: " + editFirstName);
        editLast.setHint("Last Name: " + editLastName);
        editMiddle.setHint("Middle Initial: " + editMiddleI);
        editCompanyN.setHint("Company Name: " + editCompanyName);
        editCompanyA.setHint("Company Address: " + editCompanyAddress);
        editBuild.setHint("Number of Buildings: " + editBuildings);
        editFloor.setHint("Number of Floors: " + editFloors);
        editUnit.setHint("Number of Units: " + editUnits);
        editRoom.setHint("Number of Rooms" + editRooms);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String grabPass = editPass.getText().toString();
                final String grabFirst = editFirst.getText().toString();
                final String grabLast = editLast.getText().toString();
                final String grabMiddle = editMiddle.getText().toString();
                final String grabCompanyN = editCompanyN.getText().toString();
                final String grabCompanyA = editCompanyA.getText().toString();
                final String grabBuild = editBuild.getText().toString();
                final String grabFloor = editFloor.getText().toString();
                final String grabUnit = editUnit.getText().toString();
                final String grabRoom = editRoom.getText().toString();

                Realm realm = Realm.getInstance(getActivity());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        CustomerInformation ci = realm.where(CustomerInformation.class)
                                .equalTo("username", mUsername)
                                .findFirst();
                        ci.setPassword(grabPass);
                        ci.setFirstName(grabFirst);
                        ci.setLastName(grabLast);
                        ci.setMiddleI(grabMiddle);
                        ci.setCompanyName(grabCompanyN);
                        ci.setCompanyAddress(grabCompanyA);
                        ci.setBi(bi);
                        ci.setEc(ec);
                        bi.setBuilding(grabBuild);
                        bi.setFloors(grabFloor);
                        bi.setUnits(grabUnit);
                        bi.setRooms(grabRoom);
                    }
                });

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
