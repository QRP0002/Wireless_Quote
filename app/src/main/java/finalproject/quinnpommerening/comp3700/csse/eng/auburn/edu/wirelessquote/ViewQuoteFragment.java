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
    public  String mDisplayString;

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

        mDisplayString = viewUsername + "\n" + viewFirstName + "\n" + viewLastName +  "\n" +
                        "\n" +viewMiddleI + "\n" + viewCompanyName + "\n" +
                        viewCompanyAddress;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_quote, container, false);

        TextView showText = (TextView) v.findViewById(R.id.view_text);
        showText.setText(getArguments().getString(mDisplayString));
        return v;
    }
}
