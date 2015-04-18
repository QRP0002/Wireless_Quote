package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 *
 */
public class CustomerHomeFragment extends Fragment {

    public static CustomerHomeFragment newInstance() {
        CustomerHomeFragment f = new CustomerHomeFragment();
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
        View v = inflater.inflate(R.layout.fragment_customer_home, container, false);

        Button mManageQuote = (Button) v.findViewById(R.id.manage_quote_button);

        mManageQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = ManageQuoteFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        return v;
    }
}
