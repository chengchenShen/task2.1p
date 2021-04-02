package com.example.task21p;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
public class MainActivity extends AppCompatActivity {
    EditText txtone;
    TextView txtre1,txtre2,txtre3,one,two,three;
    ImageView img1,img2,img3;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtone = findViewById(R.id.txtone);
        sp = findViewById(R.id.sp);
        txtre1 = findViewById(R.id.txtre1);
        txtre2 = findViewById(R.id.txtre2);
        txtre3 = findViewById(R.id.txtre3);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Integer.parseInt(String.valueOf(txtone.getText()));
                double cm,foot,inch;
                cm = num*100;
                foot =num*(518.37/158);
                inch = num*(6220.48/158);
                BigDecimal bgcm = new BigDecimal(cm);
                BigDecimal bgfoot = new BigDecimal(foot);
                BigDecimal bginch = new BigDecimal(inch);
                double fcm = bgcm.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                double ffoot = bgfoot.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                double finch = bginch.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

                if(sp.getSelectedItem().toString().equals("Metre")){
                    txtre1.setText(String.valueOf(fcm));
                    txtre2.setText(String.valueOf(ffoot));
                    txtre3.setText(String.valueOf(finch));
                    one.setText("centimetre");
                    two.setText("foot");
                    three.setText("inch");
                } else{
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Integer.parseInt(String.valueOf(txtone.getText()));
                double gram,ounce,pound;
                gram = num*1000;
                ounce =num*(4232.88/120);
                pound = num*(264.55/120);
                BigDecimal bggram = new BigDecimal(gram);
                BigDecimal bgounce = new BigDecimal(ounce);
                BigDecimal bgpound = new BigDecimal(pound);
                double fgram = bggram.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                double founce = bgounce.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                double fpound = bgpound.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

                if(sp.getSelectedItem().toString().equals("Celsius")){
                    txtre1.setText(String.valueOf(fgram));
                    txtre2.setText(String.valueOf(founce));
                    txtre3.setText(String.valueOf(fpound));
                    one.setText("Gram");
                    two.setText("Ounce(Oz)");
                    three.setText("Pound");
                } else{
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Integer.parseInt(String.valueOf(txtone.getText()));
                double fahrenheit,kelvin;
                fahrenheit = num*(98.6/37);
                kelvin =num*(310.15/37);
                BigDecimal bgfahrenheit = new BigDecimal(fahrenheit);
                BigDecimal bgkelvin = new BigDecimal(kelvin);
                double ffahrenheit = bgfahrenheit.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                double fkelvin = bgkelvin.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

                if(sp.getSelectedItem().toString().equals("Kilograms")){
                    txtre1.setText(String.valueOf(ffahrenheit));
                    txtre2.setText(String.valueOf(fkelvin));
                    txtre3.setText("");
                    one.setText("Fahrenheit");
                    two.setText("Kelvin");
                    three.setText("");
                } else{
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,R.array.name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);




    }


}