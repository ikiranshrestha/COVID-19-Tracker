package np.com.shresthakiran.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    CardView cvInfectedNepal, cvRecoveredNepal, cvDeathNepal,
            cvInfectedWorld, cvRecoveredWorld, cvDeathWorld;
    TextView tvNepalInfectedCount, tvNepalRecoveredCount, tvNepalDeathCount,
            tvNepalInfectedCountToday, tvNepalRecoveredCountToday, tvNepalDeathCountToday,
            tvWorldInfectedCount, tvWorldRecoveredCount, tvWorldDeathCount,
            tvWorldInfectedCountToday, tvWorldRecoveredCountToday, tvWorldDeathCountToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchCovid19Data();
    }

    public void  fetchCovid19Data(){
        final String URLNEPAL = "https://corona.lmao.ninja/v2/countries/Nepal";
        final String URLWORLD = "https://corona.lmao.ninja/v2/all";

        tvNepalInfectedCount = findViewById(R.id.tvNepalInfectedCount);
        tvNepalRecoveredCount = findViewById(R.id.tvNepalRecoveredCount);
        tvNepalDeathCount = findViewById(R.id.tvNepalDeathCount);
        tvNepalInfectedCountToday = findViewById(R.id.tvNepalInfectedCountToday);
        tvNepalRecoveredCountToday = findViewById(R.id.tvNepalRecoveredCountToday);
        tvNepalDeathCountToday = findViewById(R.id.tvNepalDeathCountToday);



        tvWorldInfectedCount = findViewById(R.id.tvWorldInfectedCount);
        tvWorldRecoveredCount = findViewById(R.id.tvWorldRecoveredCount);
        tvWorldDeathCount = findViewById(R.id.tvWorldDeathCount);
        tvWorldInfectedCountToday = findViewById(R.id.tvWorldInfectedCountToday);
        tvWorldRecoveredCountToday = findViewById(R.id.tvWorldRecoveredCountToday);
        tvWorldDeathCountToday = findViewById(R.id.tvWorldDeathCountToday);

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URLNEPAL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String NepalInfectedCount = response.getString("cases");
                    String NepalRecoveredCount = response.getString("recovered");
                    String NepalDeathCount = response.getString("deaths");
                    String NepalInfectedCountToday = response.getString("todayCases");
                    String NepalRecoveredCountToday = response.getString("todayRecovered");
                    String NepalDeathCountToday = response.getString("todayDeaths");

                    tvNepalInfectedCount.setText(NepalInfectedCount);
                    tvNepalRecoveredCount.setText(NepalRecoveredCount);
                    tvNepalDeathCount.setText(NepalDeathCount);
                    tvNepalInfectedCountToday.setText(NepalInfectedCountToday);
                    tvNepalRecoveredCountToday.setText(NepalRecoveredCountToday);
                    tvNepalDeathCountToday.setText(NepalDeathCountToday);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, URLWORLD, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String WorldInfectedCount = response.getString("cases");
                    String WorldRecoveredCount = response.getString("recovered");
                    String WorldDeathCount = response.getString("deaths");
                    String WorldInfectedCountToday = response.getString("todayCases");
                    String WorldRecoveredCountToday = response.getString("todayRecovered");
                    String WorldDeathCountToday = response.getString("todayDeaths");

                    tvWorldInfectedCount.setText(WorldInfectedCount);
                    tvWorldRecoveredCount.setText(WorldRecoveredCount);
                    tvWorldDeathCount.setText(WorldDeathCount);
                    tvWorldInfectedCountToday.setText(WorldInfectedCountToday);
                    tvWorldRecoveredCountToday.setText(WorldRecoveredCountToday);
                    tvWorldDeathCountToday.setText(WorldDeathCountToday);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest1);
    }
}