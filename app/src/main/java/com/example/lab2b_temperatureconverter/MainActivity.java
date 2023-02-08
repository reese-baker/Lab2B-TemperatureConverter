package com.example.lab2b_temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lab2b_temperatureconverter.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private EditText fahrenheitInput;
    private EditText celsiusInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        fahrenheitInput = binding.fahrenheitInput;
        celsiusInput = binding.celsiusInput;

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                if (!fahrenheitInput.getText().toString().isEmpty() && fahrenheitInput.isFocused()) {
                    try {
                        double fahrenheit = Double.parseDouble(fahrenheitInput.getText().toString());
                        double celsius = (fahrenheit - 32) * 5 / 9;
                        celsiusInput.setText(String.format("%.2f", celsius));
                    }
                    catch (NumberFormatException e) {
                        celsiusInput.setText(getResources().getString(R.string.invalidInput));
                    }

                } else if (!celsiusInput.getText().toString().isEmpty() && celsiusInput.isFocused()) {
                    try {
                        double celsius = Double.parseDouble(celsiusInput.getText().toString());
                        double fahrenheit = celsius * 9 / 5 + 32;
                        fahrenheitInput.setText(String.format("%.2f", fahrenheit));
                    }
                    catch (NumberFormatException e) {
                        fahrenheitInput.setText(getResources().getString(R.string.invalidInput));
                    }
                }
            }
        });
    }
}
