package com.app2.family;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] familyMembers;
    String[] familyAge;
    int[] images={R.drawable.member1, R.drawable.member2,R.drawable.member3,R.drawable.member4,R.drawable.member5} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res=getResources();
        familyMembers=res.getStringArray(R.array.members);
        familyAge=res.getStringArray(R.array.age);
        list= (ListView) findViewById(R.id.listView);
        VivzAdapter adapter=new VivzAdapter(this, familyMembers, images, familyAge)  ;
        list.setAdapter(adapter);
    }
}

