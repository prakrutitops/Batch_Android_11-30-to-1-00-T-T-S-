package com.example.realmexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ViewActivity extends AppCompatActivity {

    ListView listView;
    List<Model>list;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView=findViewById(R.id.list);
        list=new ArrayList<>();
        realm= Realm.getInstance(Realm.getDefaultConfiguration());

        realm.beginTransaction();

        RealmResults<Model>realmResults=realm.where(Model.class).findAll();

        for(int i=0;i<realmResults.size();i++)
        {
            list.add(realmResults.get(i));
        }

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
        listView.setAdapter(myAdapter);


        realm.commitTransaction();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder alert =new AlertDialog.Builder(ViewActivity.this);
                alert.setTitle("Select Operations?");
                alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i2) {


                        AlertDialog.Builder alert2 =new AlertDialog.Builder(ViewActivity.this);
                        LayoutInflater in=LayoutInflater.from(ViewActivity.this);
                        View view=in.inflate(R.layout.update,null);
                        alert2.setView(view);

                        EditText edt1=view.findViewById(R.id.edt1);
                        EditText edt2=view.findViewById(R.id.edt2);
                        Button btn1=view.findViewById(R.id.btn1);

                        edt1.setText(list.get(i).name);
                        edt2.setText(list.get(i).number);


                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                String name=edt1.getText().toString();
                                String num=edt2.getText().toString();


                                realm.beginTransaction();

                                list.get(i).setName(name);
                                list.get(i).setNumber(num);


                                realm.commitTransaction();
                                Toast.makeText(getApplicationContext(),"Updated", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(ViewActivity.this, ViewActivity.class));
                            }
                        });


                        alert.show();
                        alert2.show();




                    }
                });
                alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i2) {

                        realm.beginTransaction();

                        RealmResults<Model>realmResults=realm.where(Model.class).findAll();
                        realmResults.deleteFromRealm(i);

                        realm.commitTransaction();

                        startActivity(new Intent(ViewActivity.this,ViewActivity.class));

                    }
                });
                alert.show();

            }
        });

    }
}