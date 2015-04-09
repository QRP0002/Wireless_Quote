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


/**
 *
 */
public class BuildingInformationFragment extends Fragment {
    private Button mNextButton;
    private Button mPreviousButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
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
                Fragment display = new EquipmentFragment();

                EditText editBuildings = (EditText) view.findViewById(R.id.new_building);
                EditText editUnits = (EditText) view.findViewById(R.id.new_units);
                EditText editRooms = (EditText) view.findViewById(R.id.new_rooms);
                EditText editFloors = (EditText) view.findViewById(R.id.new_floors);

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editBuildings.getWindowToken(), 0);

                String newBilding = editBuildings.getText().toString();
                String newUnits = editUnits.getText().toString();
                String newRooms = editRooms.getText().toString();
                String newFloors = editFloors.getText().toString();

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
                Fragment display = new CustomerInformationFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return view;
    }

}
