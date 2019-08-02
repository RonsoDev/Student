package com.solomonron.mystudentvp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.solomonron.mystudentvp.room.MyAppDatabase;
import com.solomonron.mystudentvp.room.StudentRoom;
import com.solomonron.mystudentvp.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MyAppDatabase myAppDatabase;
    private List<StudentRoom> citiesList = new ArrayList<>();

 /*   //משתני רשימת בתי ספר-RV
    private RecyclerView schoolListRV;
    private List<StudentRoom> schoolList = new ArrayList<>();
    private SchoolListAdapter mSchoolListAdapter;*/



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#000000"));
       // tabs.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabs.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#000000"));
        FloatingActionButton fab = findViewById(R.id.fab);

  /*      for (int i = 0; i < tabs.getTabCount(); i++) {
            //noinspection ConstantConditions
            TextView tv=(TextView) LayoutInflater.from(this).inflate(R.layout.activity_main,null);
            tv.setTextColor(getResources().getColor(R.color.black));
            tabs.getTabAt(i).setCustomView(tv);

        }*/

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


      //  myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "studentdb").allowMainThreadQueries().build();

        //myAppDatabase.mMyDao().nukeTable();//פלסטר שנוכל להמשיך לעבוד בלי שזה יקרוס כל התקנה. יש למחוק את השורה הזאת בשלב מסוים על מנת להתמודד עם הבעיה שהדאטבייס מיוצר כל פעם מחדש ולכן מקריס את האפליקציה

/*
        final StudentRoom studentRoom = new StudentRoom(0, "מיכל", "שוקר", "א1", "ביאליק", "-", "תל אביב");
        final StudentRoom studentRoom1 = new StudentRoom(1, "רון", "סולומון", "א1", "ביאליק", "-", "חולון");
        final StudentRoom studentRoom2 = new StudentRoom(2, "זיו", "אברמוביץ", "א3", "הס", "-", "תל אביב");
        final StudentRoom studentRoom3 = new StudentRoom(3, "דוד", "זוהר", "גן שושן", "-", "אשכול גנים נחמה", "תל אביב");
        final StudentRoom studentRoom4 = new StudentRoom(4, "סשה", "ברון כהן", "גן חנה", "-", "אשכול גנים ורד", "חולון");
        final StudentRoom studentRoom5 = new StudentRoom(5, "דני", "שובבני", "ב4", "ניב", "-", "תל אביב");
        final StudentRoom studentRoom6 = new StudentRoom(6, "רזיאל", "משהו", "גן כוכבה", "-", "אשכול גנים לילך", "רחובות");
        final StudentRoom studentRoom7 = new StudentRoom(7, "צור", "בן עמי", "א2", "ראשונים", "-", "רחובות");


        myAppDatabase.mMyDao().addStudent(studentRoom);
        myAppDatabase.mMyDao().addStudent(studentRoom1);
        myAppDatabase.mMyDao().addStudent(studentRoom2);
        myAppDatabase.mMyDao().addStudent(studentRoom3);
        myAppDatabase.mMyDao().addStudent(studentRoom4);
        myAppDatabase.mMyDao().addStudent(studentRoom5);
        myAppDatabase.mMyDao().addStudent(studentRoom6);
        myAppDatabase.mMyDao().addStudent(studentRoom7);*/



       // citiesList = myAppDatabase.mMyDao().getDB();
    /*    final List <Kita> tlvSchoolList= new ArrayList<>();


        schoolList = myAppDatabase.mMyDao().getTLVSchools();

        String tlvSchool = "";
        // יוצר רשימת בתי ספר בעיר תל אביב-יפו מהסטיודנטרום ומכניס לתוך רשימה מסוג קיטה
        for (StudentRoom sr : schoolList) {
            while (!sr.getSchool().equals(tlvSchool)) {
                tlvSchool = sr.getSchool();
                tlvSchoolList.add(new Kita(tlvSchool));

            }
        }*/


     /*   schoolListRV = findViewById(R.id.school_choose_RV);

        RecyclerView.LayoutManager schoolLayoutManager = new LinearLayoutManager(getApplicationContext());

        schoolListRV.setLayoutManager(schoolLayoutManager);

        mSchoolListAdapter = new SchoolListAdapter(tlvSchoolList);
        schoolListRV.setAdapter(mSchoolListAdapter);
        mSchoolListAdapter.notifyDataSetChanged();*/










    }
}