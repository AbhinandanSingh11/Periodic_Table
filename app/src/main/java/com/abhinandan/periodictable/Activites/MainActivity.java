package com.abhinandan.periodictable.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.ligl.android.widget.iosdialog.IOSDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JsonArrayRequest request;
    private RequestQueue queue;
    private EditText searchBar;
    private Button search;
    private ImageView close;
    private String query = "empty";
    private ProgressBar progressBar;
    private AdapterRecyclerView adapter;
    private final String URL = "https://api.nimus.co.in/elements/json/periodic.json";
    private final String TAG = "ErrorListenerMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(getResources().getColor(R.color.pink,getTheme()));

        queue = Volley.newRequestQueue(MainActivity.this);

        recyclerView = findViewById(R.id.recylerview);
        searchBar = findViewById(R.id.searchBar);
        close = findViewById(R.id.close);
        search = findViewById(R.id.search);
        progressBar = findViewById(R.id.progressBar);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IOSDialog.Builder(MainActivity.this)
                        .setTitle("Alert!")
                        .setMessage("Do you really want to exit")
                        .setPositiveButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false)
                        .show();
            }
        });


        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG,"Before "+ s.toString().length());
                Log.d(TAG,"start "+ start);
                Log.d(TAG,"count "+ count);
                Log.d(TAG,"after "+ after);

                if(s.toString().length() == 1 && after == 0){
                    AppData.getInstance().getElement().clear();
                    adapter.notifyDataSetChanged();
                    query = null;
                    query = "empty";
                    new Sync().execute(URL,query);
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                query = null;
                query = searchBar.getText().toString().toLowerCase().trim();
                if(query.length()>0){
                    AppData.getInstance().getElement().clear();
                    adapter.notifyDataSetChanged();
                    Log.d(TAG,"Value of Query: "+ query);
                    new Sync().execute(URL,query);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setUp();
    }


    private void fetch(String url, final String query){
        request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try{
                    for(int i = 0; i<response.length(); i++){

                        JSONObject object = response.getJSONObject(i);

                        if(query.equals("empty")){
                            AppData.getInstance().getElement().add(new Element(object.getString("name"),object.getString("symbol"),object.getString("atomicMass"),object.getString("atomicNumber"),object.getString("standardState"),object.getString("atomicRadius"),object.getString("boilingPoint"),object.getString("bondingType"),object.getString("density"),object.getString("electronAffinity"),object.getString("electronegativity"),object.getString("electronicConfiguration"),object.getString("groupBlock"),object.getString("meltingPoint"),object.getString("oxidationStates"),object.getString("vanDelWaalsRadius"),object.getString("yearDiscovered"),object.getString("ionizationEnergy"),object.getString("cpkHexColor")));
                            adapter.notifyDataSetChanged();
                        }

                        else{
                            if(object.getString("name").toLowerCase().contains(query)|| object.getString("atomicMass").contains(query) || object.getString("atomicNumber").contains(query)){
                                AppData.getInstance().getElement().add(new Element(object.getString("name"),object.getString("symbol"),object.getString("atomicMass"),object.getString("atomicNumber"),object.getString("standardState"),object.getString("atomicRadius"),object.getString("boilingPoint"),object.getString("bondingType"),object.getString("density"),object.getString("electronAffinity"),object.getString("electronegativity"),object.getString("electronicConfiguration"),object.getString("groupBlock"),object.getString("meltingPoint"),object.getString("oxidationStates"),object.getString("vanDelWaalsRadius"),object.getString("yearDiscovered"),object.getString("ionizationEnergy"),object.getString("cpkHexColor")));
                                adapter.notifyDataSetChanged();
                            }
                        }


                    }

                    Log.d(TAG,"Size of the the Adapter App List: "+ AppData.getInstance().getElement().size());

                    progressBar.setVisibility(View.GONE);
                }
                catch (Exception e){
                    Log.e(TAG, "volley Exception "+ e);
                    progressBar.setVisibility(View.GONE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    Log.e(TAG,"Volley Error " + error);
                    progressBar.setVisibility(View.GONE);
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
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(String... strings) {

            fetch(strings[0],strings[1]);
            queue.add(request);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        searchBar.setText(null);
        searchBar.clearFocus();
        query = null;
        query = "empty";
        AppData.getInstance().getElement().clear();
        adapter.notifyDataSetChanged();
        new Sync().execute(URL,query);
    }
}
