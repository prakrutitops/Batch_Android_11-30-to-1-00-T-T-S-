package com.example.dialogsex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if(view==btn1)
        {
            MyDateClass m =new MyDateClass();
            m.show(getSupportFragmentManager(),"Select Date");
        }
        if(view==btn2)
        {
            MyTimeClass m =new MyTimeClass();
            m.show(getSupportFragmentManager(),"Select Time");
        }
    }
    public static class MyDateClass extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
        {
            Calendar c =Calendar.getInstance();

            int date=c.get(Calendar.DATE);
            int month=c.get(Calendar.DAY_OF_MONTH);
            int year=c.get(Calendar.YEAR);

            return new DatePickerDialog(getActivity(),this,year,month,date);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
        {
            Toast.makeText(getActivity(), ""+i+"-"+i1+"-"+i2, Toast.LENGTH_SHORT).show();
        }
}


    public static class MyTimeClass extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
        {
            Calendar c =Calendar.getInstance();

            int hour=c.get(Calendar.HOUR_OF_DAY);
            int minute=c.get(Calendar.MINUTE);

            //DateFormat.is24HourFormat(getActivity())
            return new TimePickerDialog(getActivity(),this,hour,minute,true);
        }


        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1)
        {
            Toast.makeText(getActivity(), ""+i+":"+i1, Toast.LENGTH_SHORT).show();
        }
    }

}