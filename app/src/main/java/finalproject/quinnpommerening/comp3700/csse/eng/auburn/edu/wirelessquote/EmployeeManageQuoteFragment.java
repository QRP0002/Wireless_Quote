package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 *
 */
public class EmployeeManageQuoteFragment extends Fragment {

    private EditText mUsername;

    public static EmployeeManageQuoteFragment newInstance() {
        EmployeeManageQuoteFragment f = new EmployeeManageQuoteFragment();
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
        View v = inflater.inflate(R.layout.fragment_employee_manage_quote, container, false);
        mUsername = (EditText) v.findViewById(R.id.employee_enter_user);
        Button mEditQuote = (Button) v.findViewById(R.id.employee_edit_button);
        Button mViewQuote = (Button) v.findViewById(R.id.employee_view_button);
        Button mRemoveCustomer = (Button) v.findViewById(R.id.employee_removeC_button);
        Button mRemoveQuote = (Button) v.findViewById(R.id.employee_removeQ_button);
        Button mLogOff = (Button) v.findViewById(R.id.employee_logoff_button);

        /**
         * Will load the Edit Quote Fragment.
         */
        mEditQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mUsername.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(),
                            R.string.not_found,
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Fragment display = EditQuoteFragment.newInstance(mUsername.getText().toString());
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        /**
         * Will load the View Quote Fragment
         */
        mViewQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mUsername.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(),
                            R.string.not_found,
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Fragment display = ViewQuoteFragment.newInstance(mUsername.getText().toString());
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
                Fragment display = RemoveCustomerFragment.newInstance();
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
                Fragment display = DeleteQuoteFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });

        mLogOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment display = LoginFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .addToBackStack("fragment")
                        .replace(R.id.fragment_container, display, "display")
                        .commit();
            }
        });
        return v;

    }

}
