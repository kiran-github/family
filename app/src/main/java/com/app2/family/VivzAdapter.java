package com.app2.family;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;


public class VivzAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] memberArray;
    String[] ageArray;
     Firebase firebaseref;
    VivzAdapter(Context c,String[] members,int imgs[], String[] ages)
    {
        super(c,R.layout.single_row,R.id.textView,members);
        this.context=c;
        this.images=imgs;
        this.memberArray=members;
        this.ageArray=ages;
        Firebase.setAndroidContext(getContext());
        firebaseref = new Firebase("https://assignmentfamily.firebaseio.com") ;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row, parent, false)  ;
        final ImageView myImage=(ImageView) row.findViewById(R.id.imageView);
        final TextView myMember=(TextView)  row.findViewById(R.id.textView)  ;
        final TextView myAge=(TextView) row.findViewById(R.id.textView2);

        myImage.setImageResource(images[position]);
        myMember.setText(memberArray[position]);
        myAge.setText(ageArray[position]);


        firebaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                 myMember.setText(String.valueOf(dataSnapshot.child("relation").child(String.valueOf(position)).child("Name").getValue()));
                myAge.setText(String.valueOf(dataSnapshot.child("relation").child(String.valueOf(position)).child("relation").getValue()));
                Picasso.with(getContext()).load(String.valueOf(dataSnapshot.child("relation").child(String.valueOf(position)).child("image").getValue())).into(myImage);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        return row;
    }
}
