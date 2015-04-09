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
public class EmployeeManageQuoteFragment extends Fragment {
    private Button mViewQuote;
    private Button mEditQuote;
    private Button mRemoveCustomer;
    private Button mRemoveQuote;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_employee_manage_quote, container, false);
        mViewQuote= (Button)v.findViewById(R.id.employee_view_button);
        mEditQuote = (Button) v.findViewById(R.id.employee_edit_button);
        mRemoveCustomer = (Button)v.findViewById(R.id.employee_removeC_button);
        mRemoveQuote = (Button) v.findViewById(R.id.employee_removeQ_button);

        /**
         * Will load the View Quote Frament
         */
        mViewQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = new ViewQuoteFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        /**
         * Will load the Edit Quote Fragment.
         */
        mEditQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = new EditQuoteFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        /**
         * Will load the Remove Customer Fragment.
         */
        mRemoveCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = new RemoveCustomerFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        /**
         * Will load the Remove Quote Fragment.
         */
        mRemoveQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = new DeleteQuoteFragment();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return v;
    }

}
