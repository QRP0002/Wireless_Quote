package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 *
 */
public class ManageQuoteFragment extends Fragment {
    private EditText mUsername;

    public static ManageQuoteFragment newInstance() {
        ManageQuoteFragment f = new ManageQuoteFragment();
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
        View v = inflater.inflate(R.layout.fragment_manage_quote, container, false);
        mUsername = (EditText) v.findViewById(R.id.customer_enter_user);
        Button mViewQuote = (Button) v.findViewById(R.id.customer_view_button);
        Button mEditQuote = (Button) v.findViewById(R.id.customer_edit_button);
        Button mLogOff = (Button) v.findViewById(R.id.customer_logoff_button);

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

                Fragment display = CViewQuoteFragment.newInstance(mUsername.getText().toString());
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
