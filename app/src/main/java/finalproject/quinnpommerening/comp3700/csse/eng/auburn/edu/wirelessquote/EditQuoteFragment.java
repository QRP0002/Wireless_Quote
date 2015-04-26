package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
    private Spinner mSpinnerOne;
    private Spinner mSpinnerTwo;
    private Spinner mSpinnerThree;

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
        final TextView editEquipOne = (TextView) view.findViewById(R.id.edit_text11);
        final TextView editEquipTwo = (TextView) view.findViewById(R.id.edit_text12);
        final TextView editEquipThree = (TextView) view.findViewById(R.id.edit_text13);
        TextView cInformation = (TextView) view.findViewById(R.id.customer_text);
        TextView bInformation = (TextView) view.findViewById(R.id.building_text);
        TextView eInformation = (TextView) view.findViewById(R.id.equipment_text);

        cInformation.setText("Customer Information: ");
        editPass.setHint("Password: " + editPassword);
        editFirst.setHint("First Name: " + editFirstName);
        editLast.setHint("Last Name: " + editLastName);
        editMiddle.setHint("Middle Initial: " + editMiddleI);
        editCompanyN.setHint("Company Name: " + editCompanyName);
        editCompanyA.setHint("Company Address: " + editCompanyAddress);
        bInformation.setText("Building Information: ");
        editBuild.setHint("Number of Buildings: " + editBuildings);
        editFloor.setHint("Number of Floors: " + editFloors);
        editUnit.setHint("Number of Units: " + editUnits);
        editRoom.setHint("Number of Rooms" + editRooms);
        eInformation.setText("Equipment Information: ");
        editEquipOne.setText(editEquipmentOne);
        editEquipTwo.setText(editEquipmentTwo);
        editEquipThree.setText(editEquipmentThree);

        mSpinnerOne = (Spinner) view.findViewById(R.id.edit_spinner_1);
        mSpinnerTwo = (Spinner) view.findViewById(R.id.edit_spinner_2);
        mSpinnerThree = (Spinner) view.findViewById(R.id.edit_spinner_3);

        List<String> spinnerOneArray =  new ArrayList();
        List<String> spinnerTwoArray = new ArrayList();
        List<String> spinnerThreeArray = new ArrayList();

        spinnerOneArray.add("Ruckus Wireless R300 $395.00");
        spinnerOneArray.add("Ruckus Wireless R500 $645.00");
        spinnerOneArray.add("Ruckus Wireless T301 $1,495.00");

        spinnerTwoArray.add("TrendNet Unmanaged Housing Switch $19.95");
        spinnerTwoArray.add("Cisco SG 300-10P10 PoE Managed Switch $344.95");
        spinnerTwoArray.add("Cisco SG300-28P PoE Managed Switch $733.95");

        spinnerThreeArray.add("Binary 1M CAT6 patch cables $5.95");
        spinnerThreeArray.add("Binary 3M CAT6 patch cables $7.95");

        ArrayAdapter<String> adapterOne = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerOneArray);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterTwo = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerTwoArray);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterThree = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerThreeArray);
        adapterThree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerOne.setAdapter(adapterOne);
        mSpinnerTwo.setAdapter(adapterTwo);
        mSpinnerThree.setAdapter(adapterThree);

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
                final String grabEquipOne = mSpinnerOne.getSelectedItem().toString();
                final String grabEquipTwo = mSpinnerTwo.getSelectedItem().toString();
                final String grabEquipThree = mSpinnerThree.getSelectedItem().toString();

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
                        ec.setEquipmentOne(grabEquipOne);
                        ec.setEquipmentTwo(grabEquipTwo);
                        ec.setEquipmentThree(grabEquipThree);
                    }
                });

                Fragment display = EmployeeManageQuoteFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        mEmailButton.setOnClickListener(new View.OnClickListener() {
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
                final String grabEquipOne = mSpinnerOne.getSelectedItem().toString();
                final String grabEquipTwo = mSpinnerTwo.getSelectedItem().toString();
                final String grabEquipThree = mSpinnerThree.getSelectedItem().toString();

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
                        ec.setEquipmentOne(grabEquipOne);
                        ec.setEquipmentTwo(grabEquipTwo);
                        ec.setEquipmentThree(grabEquipThree);
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
