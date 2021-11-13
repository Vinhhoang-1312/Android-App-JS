package com.example.projectrentalz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {
    //Khoi tao bien Initialize variable
    EditText dtpropertytype,dtdateandtime,dtmonthlyrentprice,dtnotes,dtreporter;
    Button btsubmit;
    AwesomeValidation awesomeValidation;
    String[] dtbedrooms = {"1","2","3"};
    String[] dtfurnituretypes = {"Fully Furnished","Unfurnished", "Semi Furnished"};

    AutoCompleteTextView dtabedrooms,dtafurnituretypes;

    ArrayAdapter<String> adapterItems_bedrooms;
    ArrayAdapter<String> adapterItems_furnituretypes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assgin Bien
        dtabedrooms = findViewById(R.id.dt_bedrooms);
        dtafurnituretypes = findViewById(R.id.dt_furnituretypes);
        dtpropertytype=findViewById(R.id.dt_propertytype);
        dtdateandtime=findViewById(R.id.dt_dateandtime);
        dtmonthlyrentprice=findViewById(R.id.dt_monthlyrentprice);
        dtnotes=findViewById(R.id.dt_notes);
        dtreporter=findViewById(R.id.dt_reporter);
        btsubmit=findViewById(R.id.bt_submit);
        //Khoi tao bien validation style
        awesomeValidation= new AwesomeValidation(ValidationStyle.BASIC);
        //add validation vao ...
        //add validation vao ...
        awesomeValidation.addValidation(this,R.id.dt_propertytype,
                RegexTemplate.NOT_EMPTY,R.string.invalid_propertytype);
        awesomeValidation.addValidation(this,R.id.dt_bedrooms,
                RegexTemplate.NOT_EMPTY,R.string.invalid_bedrooms);
        awesomeValidation.addValidation(this,R.id.dt_dateandtime,
                RegexTemplate.NOT_EMPTY,R.string.invalid_dateandtime);
        awesomeValidation.addValidation(this,R.id.dt_monthlyrentprice,
                RegexTemplate.NOT_EMPTY,R.string.invalid_monthlyrentprice);

        awesomeValidation.addValidation(this,R.id.dt_reporter,
                RegexTemplate.NOT_EMPTY,R.string.invalid_reporter);

        adapterItems_furnituretypes = new ArrayAdapter<>(this, R.layout.data, dtfurnituretypes);
        adapterItems_bedrooms = new ArrayAdapter<>(this, R.layout.data, dtbedrooms);

        dtabedrooms.setAdapter(adapterItems_bedrooms);

        dtabedrooms.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });

        dtafurnituretypes.setAdapter(adapterItems_furnituretypes);

        dtafurnituretypes.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Choose: " +item, Toast.LENGTH_SHORT).show();
        });


        btsubmit.setOnClickListener(new View.OnClickListener(   ){






            @Override
            public void onClick(View view){
                AlertDialog.Builder activity_main = new AlertDialog.Builder(MainActivity.this);
                activity_main.setTitle("Confirm!!!");
                activity_main.setMessage("Are you sure ???");
//                activity_main.setIcon(R.drawable.warning);
                activity_main.setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        //Kiem tra validation
                        if (awesomeValidation.validate()){
                            Toast.makeText(getApplicationContext()
                                    ,"Form Validation Successfully... " ,Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getApplicationContext()
                                    ,"Validation Fail", Toast.LENGTH_SHORT).show();
                        }
                    }});
                activity_main.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                });
                activity_main.create().show();
            }
        });

    }
}


