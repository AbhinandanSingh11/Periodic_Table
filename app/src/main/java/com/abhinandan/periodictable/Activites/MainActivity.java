package com.abhinandan.periodictable.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.abhinandan.periodictable.Adapters.AdapterRecyclerView;
import com.abhinandan.periodictable.AppData.AppData;
import com.abhinandan.periodictable.Models.Element;
import com.abhinandan.periodictable.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JsonArrayRequest request;
    private RequestQueue queue;
    private AdapterRecyclerView adapter;
    private final String URL = "https://api.nimus.co.in/elements/json/periodic.json";
    private final String TAG = "ErrorListenerMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(getResources().getColor(R.color.pink));

        queue = Volley.newRequestQueue(MainActivity.this);

        recyclerView = findViewById(R.id.recylerview);

        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(12),false));

        setUp();
        new Sync().execute(URL);
    }


    private void fetch(String url){
        request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try{
                    for(int i = 0; i<response.length(); i++){

                        JSONObject object = response.getJSONObject(i);
                        AppData.getInstance().getElement().add(new Element(object.getString("name"),object.getString("symbol"),object.getString("atomicMass"),object.getString("atomicNumber"),object.getString("standardState"),object.getString("atomicRadius"),object.getString("boilingPoint"),object.getString("bondingType"),object.getString("density"),object.getString("electronAffinity"),object.getString("electronegativity"),object.getString("electronicConfiguration"),object.getString("groupBlock"),object.getString("meltingPoint"),object.getString("oxidationStates"),object.getString("vanDelWaalsRadius"),object.getString("yearDiscovered"),object.getString("ionizationEnergy"),object.getString("cpkHexColor")));
                        adapter.notifyDataSetChanged();
                        Log.e(TAG, "length:  " + object.getString("cpkHexColor"));
                    }
                }
                catch (Exception e){
                    Log.e(TAG, "volley Exception "+ e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    Log.e(TAG,"Volley Error " + error);
            }
        });


    }

    void setUp(){
        adapter = new AdapterRecyclerView(MainActivity.this);
        RecyclerView.LayoutManager manager = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }



    class Sync extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... strings) {
            fetch(strings[0]);
            queue.add(request);
            return null;
        }
    }

}
