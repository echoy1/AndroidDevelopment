package com.example.uibasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtHello;
    private EditText edtTxtName;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHello:
                //Toast.makeText(this, "Hello Button Clicked", Toast.LENGTH_SHORT).show();
                txtHello.setText("Hello " + edtTxtName.getText().toString());
                break;
            case R.id.edtTxtName:
                Toast.makeText(this, "Attempting to type something", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtName.setOnClickListener(this);

        txtHello = findViewById(R.id.txtHello);

    }
}