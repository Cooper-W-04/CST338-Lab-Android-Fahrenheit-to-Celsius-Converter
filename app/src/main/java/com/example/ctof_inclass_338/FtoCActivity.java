package com.example.ctof_inclass_338;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ctof_inclass_338.databinding.ActivityFtoCactivityBinding;

public class FtoCActivity extends AppCompatActivity {

    private ActivityFtoCactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFtoCactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        binding.FtoCConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertValueFromDisplay();
            }
        });

        binding.FtoCConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(FtoCActivity.this, ActivityFtoCactivityBinding.class);
                startActivity(intent);
                return true;
            }
        });
    }

    private void convertValueFromDisplay() {
        double fahrenheitValue = 0.0;
        String enteredValue = binding.FtoCEnteredValueEditText.getText().toString();
        if (!enteredValue.isEmpty()) {
            fahrenheitValue = Double.parseDouble(enteredValue);
        }
        double celsiusValue = (fahrenheitValue - 32) * 5.0 / 9.0; // Correct F to C conversion
        binding.FtoCConvertedValueTextView.setText(String.format("%.2f", celsiusValue)); // Format to 2 decimal places
    }
}