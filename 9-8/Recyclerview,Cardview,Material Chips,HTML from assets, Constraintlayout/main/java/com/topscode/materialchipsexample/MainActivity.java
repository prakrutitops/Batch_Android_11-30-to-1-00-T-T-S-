package com.topscode.materialchipsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

/**
 * Created By Nikesh Nayak
 */

public class MainActivity extends AppCompatActivity {

    ChipGroup chipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipGroup = (ChipGroup) findViewById(R.id.chipGroup_id);

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int i) {

                Chip chip = chipGroup.findViewById(i);
                Toast.makeText(MainActivity.this, chip.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
