package com.example.timetable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    TextView textView1;
    Button button;
    String[] sunday={"YEET","YEET","YEET","YEET","YEET","YEET","YEET"};
    String[] monday={"DM","OOP","DSL E2","DSL E2","HSS E2","FDS"};
    String[] tuesday={"_","CG","FDS","DM","OOP LAB E2","OOP LAB E2"};
    String[] wednesday={"DEL Lab E2","DEL Lab E2","OOP","DELD","DM","_"};
    String[] thursday={"OOP","DELD","DSL LAB E2","DSL LAB E2","CG","CG"};
    String[] friday={"OOP LAB E2","OOP LAB E2","BCSL E2","BCSL E2","DELD","FDS"};
    String[] saturday={"_","_","_","_","MENTOR MEETING","PROFESSIONAL DEV"};
    //    String[] monday={"8-9 CCA","9-10 A1 - Maths","10.15 - 11.15 PPS","11.15 - 12.15 CHEMISTRY","1-2 MATHS","2-3 CCA","3-4 PBL"};
    //    String[] tuesday={"8-9 EG","9-10 Maths","10.15 - 11.15 CHEMISTRY","11.15 - 12.15 B1 - MATHS","1-2 BXE","2-3 PPS","3-4 _"};
    //    String[] wednesday={"8-9 PPS","9-10 CHEMISTRY","10.15 - 11.15 EG","11.15 - 12.15 MATHS","1-2 BXE","2-3 C1 - MATHS","3-4 _"};
    //    String[] thursday={"8-9 PPS","9-10 CCA","10.15 - 11.15 CHEMISTRY","11.15 - 12.15 BXE","1-2 EG","2-3 MATHS","3-4 _"};
    //    String[] friday={"8-9 MATHS","9-10 BXE","10.15 - 11.15 EG","11.15 - 12.15 CS","1-2 CHEMISTRY","2-3 CCA","3-4 _"};
    //    String[] saturday={"8-10 PBL-2HR","10.15-11.15 APTITUDE","11.15 - 12.15 CCA","1 - 2 CCA","2-3 CODING CLASS","_"};


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView3);
        textView1 = findViewById(R.id.textView4);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.list);
        List<String[]> listDays = new ArrayList<>();
        listDays.add(sunday);
        listDays.add(monday);
        listDays.add(tuesday);
        listDays.add(wednesday);
        listDays.add(thursday);
        listDays.add(friday);
        listDays.add(saturday);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int min= LocalDateTime.now().getMinute();
        if(hour>=15 )
            day+=1;
        if(day==8)
            day=1;
        String[] array = listDays.get(day - 1);
        textView1.setText(dayOfWeek(day));

        switch (hour) {
            case 9:
                textView.setText(array[1]);
                break;
            case 10:
                textView.setText(array[2]);
                break;
            case 11:
                if(min<=15)
                    textView.setText(array[2]);
                else
                    textView.setText(array[3]);
                break;
            case 12:
                if(min<=15)
                    textView.setText(array[3]);
                else
                    textView.setText(array[4]);
                break;
            case 13:
                textView.setText(array[4]);
                break;
            case 14:
                textView.setText(array[5]);
                break;
            default:textView.setText(array[0]);
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listDays.get(day-1));
        listView.setAdapter(ad);

        button.setOnClickListener(v -> {
            try {
                Intent i;
                PackageManager managerClock = getPackageManager();
                i = managerClock.getLaunchIntentForPackage("com.microsoft.teams");
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
            }
            catch (Exception e){
                Toast.makeText(this, "Cannot open Teams", Toast.LENGTH_SHORT).show();
            }
        });




    }

    public String dayOfWeek(int no) {
        switch (no) {
            case 2:
                return "MONDAY";
            case 3:
                return "TUESDAY";
            case 4:
                return "WEDNESDAY";
            case 5:
                return "THURSDAY";
            case 6:
                return "FRIDAY";
            case 7:
                return "SATURDAY";
            case 1:
                return "SUNDAY";
        }
        return "meh";
    }

    public void tt(View view) {
        Intent intent = new Intent(this, image.class);
        startActivity(intent);
    }
    public void exam(View v) {
        Toast.makeText(this, "CHILL BRO", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(this,exam.class));
    }
}