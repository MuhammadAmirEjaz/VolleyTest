package pucit.edu.pk.volleytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://192.168.8.100:8888/api/Project/GetAllProjects";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("isResponse", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError e){
                Toast toast=Toast.makeText(MainActivity.this, "Something's not good", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
