package co.edu.javeriana.com.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonPaises;
    Button buttonFib;
    EditText editFib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPaises = (Button) findViewById(R.id.buttonPaises);
        buttonFib = findViewById(R.id.buttonFib);
        editFib = findViewById(R.id.editFib);

        buttonPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListPaisesActivity.class);
                startActivity(intent);
            }
        });

        buttonFib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),FibonacciActivity.class);
                intent.putExtra("num",editFib.getText().toString());
                startActivity(intent);
            }
        });
    }
}
