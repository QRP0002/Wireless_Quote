package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.realm.Realm;


/**
 *
 */
public class ViewQuoteFragment extends Fragment {
    private String mUsername;
    private String mDisplayString;

    public static ViewQuoteFragment newInstance(String username) {
        ViewQuoteFragment f = new ViewQuoteFragment();
        Bundle args = new Bundle();
        args.putString("username", username);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String viewUsername;
        final String viewFirstName;
        final String viewLastName;
        final String viewMiddleI;
        final String viewCompanyName;
        final String viewCompanyAddress;
        final String viewBuildings;
        final String viewFloors;
        final String viewUnits;
        final String viewRooms;
        final String viewEquipmentOne;
        final String viewEquipmentTwo;
        final String viewEquipmentThree;
        BuildInformation bi;
        EquipmentController ec;

        mUsername = getArguments().getString("username");

        Realm realm = Realm.getInstance(getActivity());
        CustomerInformation ci = realm.where(CustomerInformation.class)
                .equalTo("username", mUsername).findFirst();

        viewUsername = ci.getUsername();
        viewFirstName = ci.getFirstName();
        viewLastName = ci.getLastName();
        viewMiddleI = ci.getMiddleI();
        viewCompanyName = ci.getCompanyName();
        viewCompanyAddress = ci.getCompanyAddress();
        bi = ci.getBi();
        ec = ci.getEc();
        viewBuildings = bi.getBuilding();
        viewFloors = bi.getFloors();
        viewUnits = bi.getUnits();
        viewRooms = bi.getRooms();
        viewEquipmentOne = ec.getEquipmentOne();
        viewEquipmentTwo = ec.getEquipmentTwo();
        viewEquipmentThree = ec.getEquipmentThree();


        mDisplayString = "Customer Information: " + "\n" +
                        "Username: " + viewUsername + "\n" +
                        "First Name: " + viewFirstName + "\n" +
                        "Last Name: " + viewLastName +  "\n" +
                        "Middle Initial: " + viewMiddleI + "\n" +
                        "Company Name: " + viewCompanyName + "\n" +
                        "Company Address: " + viewCompanyAddress  + "\n" + "\n" +
                        "Building Information: " + "\n" +
                        "Number of Buildings: " + viewBuildings + "\n" +
                        "Number of Floors: " + viewFloors + "\n" +
                        "Number of Units: " + viewUnits  + "\n" +
                        "Number of Rooms: " + viewRooms + "\n" + "\n" +
                        "Equipment: " + "\n" +
                        viewEquipmentOne  + "\n" + viewEquipmentTwo  + "\n" + viewEquipmentThree;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_quote, container, false);

        TextView showText = (TextView) v.findViewById(R.id.view_text);
        showText.setText(mDisplayString);
        return v;
    }
}
