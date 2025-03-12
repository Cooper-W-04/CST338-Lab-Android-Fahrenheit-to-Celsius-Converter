package com.example.ctof_inclass_338;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ctof_inclass_338.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        binding.CtoFConvertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                convertValueFromDisplay();
            }
        });
    }

    private void convertValueFromDisplay(){
        double celciusValue = 0.0;
        String enteredValue = binding.CtoFEnteredValueEditText.getText().toString;
        if(!enteredValue.isEmpty()){
            celciusValue = Double.parseDouble(enteredValue);
        }
        double fahrenheitValue = Utils.cTof(celciusValue);
        binding.CtoFConvertedValueTextView.setText(fahrenheitValue + " ")
    }
}