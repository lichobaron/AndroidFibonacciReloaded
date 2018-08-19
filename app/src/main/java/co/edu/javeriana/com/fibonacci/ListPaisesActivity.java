package co.edu.javeriana.com.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListPaisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_paises);

        try {

            JSONObject json = new JSONObject(loadJSONFromAsset());
            final JSONArray paisesJasonArray = json.getJSONArray("paises");
            ArrayList<String> paises = getPaisesFromJSONArray(paisesJasonArray);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paises);
            ListView listPaises = (ListView) findViewById(R.id.listPaises);
            listPaises.setAdapter(adapter);

            listPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    try {
                        Intent intent = new Intent(getBaseContext(),PaisActivity.class);
                        Bundle pais = new Bundle();
                        pais.putInt("id",i+1);
                        pais.putString("capital",getPaisDataFromJSONArray(paisesJasonArray,"capital",i));
                        pais.putString("nombre_pais",getPaisDataFromJSONArray(paisesJasonArray,"nombre_pais",i));
                        pais.putString("nombre_pais_int",getPaisDataFromJSONArray(paisesJasonArray,"nombre_pais_int",i));
                        pais.putString("sigla",getPaisDataFromJSONArray(paisesJasonArray,"sigla",i));
                        intent.putExtra("pais",pais);
                        startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private String loadJSONFromAsset(){
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    private  ArrayList<String> getPaisesFromJSONArray(JSONArray array) throws JSONException {
        ArrayList<String> list =new ArrayList<String>();

        for(int i=0; i< array.length();i++){
            list.add(array.getJSONObject(i).getString("nombre_pais"));
        }

        return list;
    }

    private  String getPaisDataFromJSONArray(JSONArray array, String data, int pos) throws JSONException {

        return array.getJSONObject(pos).getString(data);
    }

}
