package www.team4.com.scalefit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class aboutActivity extends AppCompatActivity {

    private static  final boolean On = true;
    private static  final boolean Off = false;
    private final static String TAG = Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (On) Log.i(TAG, " onCreateOptionsMenu Called");
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (On) Log.i(TAG, "onOptionItemSelected");
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {
            if (On) Log.i(TAG, "Action Settings Selected");
            startActivity(new Intent(this, Settings.class));
            return true;
        }
        if (id == R.id.action_about) {
            if (On) Log.i(TAG, "Action About Selected");
            startActivity(new Intent(this, aboutActivity.class));
            return true;
        }
        if (id == R.id.action_team) {
            if (On) Log.i(TAG, "Action Team Selected");
            startActivity(new Intent(this, Team4Activity.class));
            return true;
        }
        if (id == R.id.action_weight) {
            if (On) Log.i(TAG, "Action Weight Option Selected");
            startActivity(new Intent(this, weightScreenActivity.class));
            Toast.makeText(this, "Hey you just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
