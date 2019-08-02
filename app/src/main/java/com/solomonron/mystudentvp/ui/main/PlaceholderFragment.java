package com.solomonron.mystudentvp.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.solomonron.mystudentvp.Kita;
import com.solomonron.mystudentvp.KitaAdapter;
import com.solomonron.mystudentvp.R;
import com.solomonron.mystudentvp.School;
import com.solomonron.mystudentvp.SchoolListAdapter;
import com.solomonron.mystudentvp.room.MyAppDatabase;
import com.solomonron.mystudentvp.room.StudentRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    public MyAppDatabase myAppDatabase;

    private RecyclerView schoolListRV;
    private List<StudentRoom> schoolList = new ArrayList<>();
    private SchoolListAdapter mSchoolListAdapter;


    private static final String ARG_SECTION_NUMBER = "0";

    private PageViewModel pageViewModel;
    private Context mContext;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.recyclerview);

        myAppDatabase = Room.databaseBuilder(getContext(), MyAppDatabase.class, "studentdb").allowMainThreadQueries().build();

        myAppDatabase.mMyDao().nukeTable();//פלסטר שנוכל להמשיך לעבוד בלי שזה יקרוס כל התקנה. יש למחוק את השורה הזאת בשלב מסוים על מנת להתמודד עם הבעיה שהדאטבייס מיוצר כל פעם מחדש ולכן מקריס את האפליקציה


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
        myAppDatabase.mMyDao().addStudent(studentRoom7);



        final List <Kita> tlvSchoolList= new ArrayList<>();

        ArrayList<School> schools = new ArrayList<>();



        schoolList = myAppDatabase.mMyDao().getTLVSchools();

        String tlvSchool = "";
        // יוצר רשימת בתי ספר בעיר תל אביב-יפו מהסטיודנטרום ומכניס לתוך רשימה מסוג קיטה
        for (StudentRoom sr : schoolList) {
            while (!sr.getSchool().equals(tlvSchool) && !sr.getSchool().equals("-")) {
                tlvSchool = sr.getSchool();
                String kita= sr.getKita();
                tlvSchoolList.add(new Kita("TLV", tlvSchool));



            }
        }

        schoolListRV = root.findViewById(R.id.school_choose_RV);

        RecyclerView.LayoutManager schoolLayoutManager = new LinearLayoutManager(getContext());

        schoolListRV.setLayoutManager(schoolLayoutManager);

        mSchoolListAdapter = new SchoolListAdapter(tlvSchoolList);

        schoolListRV.setAdapter(mSchoolListAdapter);
        mSchoolListAdapter.notifyDataSetChanged();
/*
        KitaAdapter adapter = new KitaAdapter(schools);

        recyclerView.setAdapter(adapter);*/


        return root;
    }
}