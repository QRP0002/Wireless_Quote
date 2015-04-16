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
public class BuildingInformationFragment extends Fragment {
    private Button mNextButton;
    private Button mPreviousButton;
    private String mUsername;

    public static BuildingInformationFragment newInstance(String username) {
        BuildingInformationFragment f = new BuildingInformationFragment();
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
        final View view = inflater.inflate(R.layout.fragment_building_information, container, false);
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);

        mNextButton = (Button)view.findViewById(R.id.next_button_building);
        mPreviousButton = (Button)view.findViewById(R.id.previous_button_building);

        /**
         * This button will go to the next page, EquipmentFragment.
         */
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editBuildings = (EditText) view.findViewById(R.id.new_building);
                EditText editUnits = (EditText) view.findViewById(R.id.new_units);
                EditText editRooms = (EditText) view.findViewById(R.id.new_rooms);
                EditText editFloors = (EditText) view.findViewById(R.id.new_floors);

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editBuildings.getWindowToken(), 0);

                final String newBuilding = editBuildings.getText().toString();
                final String newUnits = editUnits.getText().toString();
                final String newRooms = editRooms.getText().toString();
                final String newFloors = editFloors.getText().toString();

                Realm realm = Realm.getInstance(getActivity());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        BuildInformation bi = realm.createObject(BuildInformation.class);
                        bi.setmBuilding(newBuilding);
                        bi.setmUnits(newUnits);
                        bi.setmRooms(newRooms);
                        bi.setmFloors(newFloors);

                        CustomerInformation ci = realm.where(CustomerInformation.class)
                                .equalTo("username", mUsername)
                                .findFirst();

                        ci.setmBi(bi);
                    }
                });

                Fragment display = EquipmentFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        /**
         * This button will go to the previous page, CustomerInformationFragment.
         */
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = CustomerInformationFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return view;
    }

}
