package co.edu.javeriana.com.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class FibonacciActivity extends AppCompatActivity {

    Button bioFibo;
    LinearLayout listFibo;
    Vector<Integer> fibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        String numero = getIntent().getStringExtra("num");
        int n1 = Integer.parseInt(numero);

        bioFibo = findViewById(R.id.bioFibo);

        bioFibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), biografiaFibo.class);
                startActivity(intent);
            }
        });

        listFibo = findViewById(R.id.listFibo);
        fibo = new Vector<Integer>();

        fibo.add(0);
        fibo.add(1);
        for (int k = 0; k < n1; k++)
        {
            if (k == 0){
                TextView x = new TextView(this);
                x.setText(Integer.toString(0));
                x.setTextSize(20);
                listFibo.addView(x);
            }
            if (k==1){
                TextView y = new TextView(this);
                y.setText(Integer.toString(1));
                y.setTextSize(20);
                listFibo.addView(y);
            }
            if (k>1) {
                TextView n = new TextView(this);
                fibo.add(fibo.elementAt(fibo.size() - 1) + fibo.elementAt(fibo.size() - 2));
                n.setText(Integer.toString(fibo.elementAt(fibo.size() - 1)));
                n.setTextSize(20);
                listFibo.addView(n);
            }
        }
    }
}
