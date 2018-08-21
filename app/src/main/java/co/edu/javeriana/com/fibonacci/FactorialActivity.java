package co.edu.javeriana.com.fibonacci;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class FactorialActivity extends AppCompatActivity {

    Vector<Long> facto;
    long res;
    LinearLayout listFacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        String numero = getIntent().getStringExtra("num");
        int n1 = Integer.parseInt(numero);

        listFacto = findViewById(R.id.listFacto);
        facto = new Vector<>();
        res = 1;

        for (long i =1; i<=n1;i++){
            facto.add(i);
            res = res*i;
        }

        TextView multi= new TextView(this);
        multi.setTextSize(20);
        multi.setTextColor(Color.parseColor("black"));
        multi.setText("Multiplicación = ");
        for (int i =0 ;i<facto.size();i++){
            multi.append(Long.toString(facto.elementAt(i)));
            if (i != facto.size()-1){
                multi.append("*");
            }
        }
        listFacto.addView(multi);
        TextView resultado= new TextView(this);
        resultado.setTextSize(20);
        resultado.setTextColor(Color.parseColor("black"));
        resultado.setText("Resultado = "+Long.toString(res));
        listFacto.addView(resultado);
    }
}
