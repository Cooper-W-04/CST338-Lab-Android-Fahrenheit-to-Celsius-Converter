package com.example.ctof_inclass_338;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ctof_inclass_338.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        binding.CtoFConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertValueFromDisplay();
            }
        });

        binding.CtoFConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(MainActivity.this, FtoCActivity.class);
                intent.putExtra("celsiusValue", binding.CtoFConvertedValueTextView.getText().toString());
                startActivity(intent);
                return true;
            }
        });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("fahrenheitValue")) {
            String fahrenheitValue = intent.getStringExtra("fahrenheitValue");
            binding.CtoFEnteredValueEditText.setText(fahrenheitValue);
            convertValueFromDisplay();
        }
    }

    private void convertValueFromDisplay() {
        double celciusValue = 0.0;
        String enteredValue = binding.CtoFEnteredValueEditText.getText().toString();
        if (!enteredValue.isEmpty()) {
            celciusValue = Double.parseDouble(enteredValue);
        }
        double fahrenheitValue = Utils.cTof(celciusValue);
        binding.CtoFConvertedValueTextView.setText(String.format("%.2f", fahrenheitValue));
    }
}