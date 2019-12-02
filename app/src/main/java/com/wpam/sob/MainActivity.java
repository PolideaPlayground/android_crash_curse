package com.wpam.sob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.wpam.sob.model.PenguinsRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        PenguinsRepository penguinsRepository = new PenguinsRepository();
        penguinsRepository.fetchAll().forEach(name -> textView.append("\n " + name));
    }
}
