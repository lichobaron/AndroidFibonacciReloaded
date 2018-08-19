package co.edu.javeriana.com.fibonacci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PaisActivity extends AppCompatActivity {

    TextView textId;
    TextView textNombre;
    TextView textNombreInt;
    TextView textCapital;
    TextView textSigla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        textId = (TextView) findViewById(R.id.textId);
        textNombre = (TextView) findViewById(R.id.textNombre);
        textNombreInt = (TextView) findViewById(R.id.textNombreInt);
        textCapital = (TextView) findViewById(R.id.textCapital);
        textSigla = (TextView) findViewById(R.id.textSigla);

        Bundle pais = getIntent().getBundleExtra("pais");

        textId.setText(Integer.toString(pais.getInt("id")));
        textNombre.setText(pais.getString("nombre_pais"));
        textNombreInt.setText(pais.getString("nombre_pais_int"));
        textCapital.setText(pais.getString("capital"));
        textSigla.setText(pais.getString("sigla"));
    }
}
