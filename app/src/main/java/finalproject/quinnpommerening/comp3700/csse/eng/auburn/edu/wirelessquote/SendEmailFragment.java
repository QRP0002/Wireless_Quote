package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;


/**
 *
 */
public class SendEmailFragment extends Fragment {

    protected EditText mRecipient;
    private Button mSendButton;
    protected String mBody;
    private String mUsername;
    protected String mSubject = "Infinity Solutions: Your Wireless Quote";

    public static SendEmailFragment newInstance(String username) {
        SendEmailFragment f = new SendEmailFragment();
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
        final double equip1;
        final double equip2;
        final double equip3;
        final String total;
        TotalCost totalCost = new TotalCost();

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
        equip1 = totalCost.equipmentOneCost(viewEquipmentOne);
        equip2 = totalCost.equipmentTwoCost(viewEquipmentTwo);
        equip3 = totalCost.equipmentThreeCost(viewEquipmentThree);
        total = totalCost.calculateTotal(equip1, equip2, equip3);

        mBody = "Customer Information: " + "\n" +
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
                viewEquipmentOne  + "\n" + viewEquipmentTwo  + "\n" + viewEquipmentThree +
                "\n\n" + "Total Cost: " + "\n" + total;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_email, container, false);

        mRecipient = (EditText) view.findViewById(R.id.email_address);
        mSendButton = (Button) view.findViewById(R.id.send_button);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();

                Toast.makeText(getActivity(),
                        R.string.email_sent,
                        Toast.LENGTH_SHORT).show();

                Fragment display = EmployeeManageQuoteFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return view;
    }

    protected void sendEmail() {

        String[] recipients = {mRecipient.getText().toString()};
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only
        email.setType("message/rfc822");

        email.putExtra(Intent.EXTRA_EMAIL, recipients);
        email.putExtra(Intent.EXTRA_SUBJECT, mSubject);
        email.putExtra(Intent.EXTRA_TEXT, mBody);

        try {
            // the user can choose the email client
            startActivity(Intent.createChooser(email, "Choose an email client from..."));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "No email client installed.",
                    Toast.LENGTH_LONG).show();
        }
    }

}
