package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.viewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

//        MainViewModel mainViewModel = new MainViewModel();
        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Log.i("MainActivity","MainViewModel is initialized.");

        bind.txtAge.setText(String.valueOf(mainViewModel.score));

        bind.btnDecrement.setEnabled(false);
        bind.btnIncrement.setOnClickListener(view -> {
            bind.btnDecrement.setEnabled(true);
            mainViewModel.score ++;
            bind.txtAge.setText(String.valueOf(mainViewModel.score));
            if(mainViewModel.score ==95){
                bind.btnIncrement.setEnabled(false);
                Toast.makeText(this, "Cannot Increment more than Ninety Five.", Toast.LENGTH_SHORT).show();
            }

        });
        bind.btnDecrement.setOnClickListener(view -> {
            bind.btnIncrement.setEnabled(true);
            mainViewModel.score --;
            bind.txtAge.setText(String.valueOf(mainViewModel.score));
            if (mainViewModel.score == 0){
                bind.btnDecrement.setEnabled(false);
                Toast.makeText(this, "Cannot Decrement less than Zero.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}