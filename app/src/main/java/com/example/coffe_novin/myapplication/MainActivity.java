package com.example.coffe_novin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private EditText contactNameEt;
private EditText contactphonenumberEt;
private Button addContactbtn;
private RecyclerView recyclerView;
private ContactAdoptor contactAdoptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    private void setupViews() {
        recyclerView=findViewById(R.id.rc_contat);
        recyclerView.setLayoutManager(new LinearLayoutManager(

                this,LinearLayoutManager.VERTICAL,false
        ));
            contactAdoptor=new ContactAdoptor(this);
            recyclerView.setAdapter(contactAdoptor);
contactNameEt=findViewById(R.id.et_main_name);

contactphonenumberEt=findViewById(R.id.et_main_Phone);
            addContactbtn=findViewById(R.id.bt_addContact);
            addContactbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(contactNameEt.length()>0){
                        if (contactphonenumberEt.length()==11){
                            contactAdoptor.addContact(new Contact(
                                    contactNameEt.getText().toString(),
                                    contactphonenumberEt.getText().toString()
                            ));


                        }
                        else {
                            contactphonenumberEt.setError("phoneNumber isn't valid");
                        }
                    }else {
                        contactNameEt.setError("Name isn't valid");

                    }
                }
            });
        final ImageView viewTypeChanger=findViewById(R.id.iv_main_viewTypeChanger);
        viewTypeChanger.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (contactAdoptor.gettype()==ContactAdoptor.TYPE_ROW) {
                    contactAdoptor.settype(ContactAdoptor.TYPE_GRID);
                    viewTypeChanger.setImageResource(R.drawable.ic_grid_on_black_24dp);
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2,LinearLayoutManager.VERTICAL,false
                    ));
                }
                else{
                    contactAdoptor.settype(ContactAdoptor.TYPE_ROW);
                    viewTypeChanger.setImageResource(R.drawable.ic_list_black_24dp);
                    recyclerView.setLayoutManager(new LinearLayoutManager(
                            MainActivity.this,LinearLayoutManager.VERTICAL,false

                    )); }
            }

        });
    }
}
