package www.team4.com.scalefit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;
import java.util.Map;
import www.team4.com.scalefit.userObject;
import www.team4.com.scalefit.LoginForRegisterActivity;

public class weightScreenActivity extends AppCompatActivity {

    private static  final boolean On = true;
    private static  final boolean Off = false;
    private final static String TAG = Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MedicalEula(this).show();
        setContentView(R.layout.activity_weight_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);

        Button mButton = (Button)findViewById(R.id.currentConfirm);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText currentW = (EditText)findViewById(R.id.currentWeight);
                Double weightCurrent = Double.parseDouble(currentW.getText().toString());
                final Firebase ref = new Firebase("https://scalefit.firebaseio.com/users");
                if (On) Log.i(TAG, "MAYBE YOU NOW");
                Map<String, Object> map = new HashMap<String , Object>();
                map.put("Current Weight", weightCurrent);
                if (On) Log.i(TAG, "ErrorRERERERERERERERER?");
                ref.child(LoginActivity.Session_KEY2.getUid()).updateChildren(map);
            }
        });

        Button mButton2 = (Button)findViewById(R.id.targetConfirm);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText targetW = (EditText)findViewById(R.id.targetWeight);
                double weightTarget =  Double.parseDouble(targetW.getText().toString());
                final Firebase ref = new Firebase("https://scalefit.firebaseio.com/users");
                if (On) Log.i(TAG, "MAYBE YOU NOW");
                Map<String, Object> map = new HashMap<String , Object>();
                map.put("Target Weight", weightTarget);

                if (On) Log.i(TAG, "ErrorRERERERERERERERER?");
                ref.child(LoginActivity.Session_KEY2.getUid()).updateChildren(map);
            }
        });

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });

        graph.addSeries(series);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (On) Log.i(TAG, " onCreateOptionsMenu Called");
        getMenuInflater().inflate(R.menu.menu_weight, menu);
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
            Toast.makeText(this, "Hey you just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_about) {
            if (On) Log.i(TAG, "Action About Selected");
            startActivity(new Intent(this, aboutActivity.class));
            Toast.makeText(this, "Hey you just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_team) {
            if (On) Log.i(TAG, "Action Team Option Selected");
            startActivity(new Intent(this, Team4Activity.class));
            Toast.makeText(this, "Hey you just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
