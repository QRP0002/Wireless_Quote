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


/**
 *
 */
public class EquipmentFragment extends Fragment {
    private Spinner mSpinnerOne;
    private Spinner mSpinnerTwo;
    private Spinner mSpinnerThree;

    public static EquipmentFragment newInstance() {
        EquipmentFragment f = new EquipmentFragment();
        Bundle args = new Bundle();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_equipment, container, false);

        Button mSaveButton = (Button) v.findViewById(R.id.save_equipment_information);
        Button mPreviousButton = (Button) v.findViewById(R.id.previous_button_equipment);
        mSpinnerOne = (Spinner) v.findViewById(R.id.equipment_spinner_1);
        mSpinnerTwo = (Spinner) v.findViewById(R.id.equipment_spinner_2);
        mSpinnerThree = (Spinner) v.findViewById(R.id.equipment_spinner_3);

        List<String> spinnerOneArray =  new ArrayList();
        List<String> spinnerTwoArray = new ArrayList();
        List<String> spinnerThreeArray = new ArrayList();

        spinnerOneArray.add("One");
        spinnerOneArray.add("Two");
        spinnerOneArray.add("Three");

        spinnerTwoArray.add("One");
        spinnerTwoArray.add("Two");
        spinnerTwoArray.add("Three");

        spinnerThreeArray.add("One");
        spinnerThreeArray.add("Two");
        spinnerThreeArray.add("Three");

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
