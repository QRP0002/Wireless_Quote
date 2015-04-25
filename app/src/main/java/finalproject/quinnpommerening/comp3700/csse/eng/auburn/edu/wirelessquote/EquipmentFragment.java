package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


/**
 *
 */
public class EquipmentFragment extends Fragment {
    private String mUsername;
    private Button mSaveButton;
    private Button mPreviousButton;
    private Spinner mSpinnerOne;
    private Spinner mSpinnerTwo;
    private Spinner mSpinnerThree;

    public static EquipmentFragment newInstance(String username) {
        EquipmentFragment f = new EquipmentFragment();
        Bundle args = new Bundle();
        args.putString("username", username);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUsername = getArguments().getString("username");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_equipment, container, false);

        mSaveButton = (Button) v.findViewById(R.id.save_equipment_information);
        mPreviousButton = (Button) v.findViewById(R.id.previous_button_equipment);
        mSpinnerOne = (Spinner) v.findViewById(R.id.equipment_spinner_1);
        mSpinnerTwo = (Spinner) v.findViewById(R.id.equipment_spinner_2);
        mSpinnerThree = (Spinner) v.findViewById(R.id.equipment_spinner_3);

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

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String spinnerOneString = mSpinnerOne.getSelectedItem().toString();
                final String spinnerTwoString = mSpinnerTwo.getSelectedItem().toString();
                final String spinnerThreeString = mSpinnerThree.getSelectedItem().toString();

                Realm realm = Realm.getInstance(getActivity());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        EquipmentController ec = realm.createObject(EquipmentController.class);
                        ec.setEquipmentOne(spinnerOneString);
                        ec.setEquipmentTwo(spinnerTwoString);
                        ec.setEquipmentThree(spinnerThreeString);

                        CustomerInformation ci = realm.where(CustomerInformation.class)
                                .equalTo("username", mUsername)
                                .findFirst();
                        ci.setEc(ec);
                    }
                });
                Fragment display = new EmployeeHomeFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = new BuildingInformationFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return v;
    }
}
