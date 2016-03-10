package vlad.com.br.gorjeta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupGorjeta;
    RadioButton radioButton10;
    RadioButton radioButton15;
    RadioButton radioButton20;
    EditText editTextInput;
    TextView textViewGorjeta;
    TextView textViewTotal;


    float porcentagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton10 = (RadioButton) findViewById(R.id.radioButton10);
        radioButton15 = (RadioButton) findViewById(R.id.radioButton15);
        radioButton20 = (RadioButton) findViewById(R.id.radioButton20);
        radioGroupGorjeta = (RadioGroup) findViewById(R.id.radioGroupGorjeta);

        radioGroupGorjeta.setOnCheckedChangeListener(this);

        /*radioButton10.setOnCheckedChangeListener(this);
        radioButton15.setOnCheckedChangeListener(this);
        radioButton20.setOnCheckedChangeListener(this);*/

    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        editTextInput = (EditText) findViewById(R.id.editTextInput);
        textViewGorjeta = (TextView) findViewById(R.id.textViewGorjeta);
        textViewTotal = (TextView) findViewById(R.id.textViewTotal);
        float gorjeta, conta;

        switch (checkedId) {
            case R.id.radioButton10:
                porcentagem = 0.1f;
                break;
            case R.id.radioButton15:
                porcentagem = 0.15f;
                break;
            case R.id.radioButton20:
                porcentagem = 0.2f;
                break;
        }
        conta = Float.parseFloat(editTextInput.getText().toString());
        gorjeta = conta * porcentagem;
        textViewGorjeta.setText("R$ " + String.format("%.2f", String.valueOf(gorjeta)));
        textViewTotal.setText("R$ " + String.format("%.2f", String.valueOf(gorjeta + conta)));

    }
}
