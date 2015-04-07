package finalproject.quinnpommerening.comp3700.csse.eng.auburn.edu.wirelessquote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;



public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (f == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new LoginFragment(), "Login")
                    .commit();
        }
    }
}
