package com.example.projectrentalz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {
    //Khoi tao bien Initialize variable
    EditText dtpropertytype,dtbedrooms,dtdateandtime,dtmonthlyrentprice,dtfurnituretypes,dtnotes,dtreporter;
    Button btsubmit;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assgin Bien

        dtbedrooms=findViewById(R.id.dt_bedrooms);
        dtpropertytype=findViewById(R.id.dt_propertytype);
        dtdateandtime=findViewById(R.id.dt_dateandtime);
        dtmonthlyrentprice=findViewById(R.id.dt_monthlyrentprice);
        dtfurnituretypes=findViewById(R.id.dt_furnituretypes);
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

        btsubmit.setOnClickListener(new View.OnClickListener(   ){






            @Override
            public void onClick(View view){
                AlertDialog.Builder activity_main = new AlertDialog.Builder(MainActivity.this);
                activity_main.setTitle("Confirm!!!");
                activity_main.setMessage("Are you sure ???");
//                activity_main.setIcon(R.drawable.warning);
                activity_main.setPositiveButton("“Yes”", new DialogInterface.OnClickListener()
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
                activity_main.setNegativeButton("“No”", new DialogInterface.OnClickListener()
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


