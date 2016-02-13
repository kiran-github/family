package com.app2.family;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kiran on 13-02-2016.
 */
public class VivzAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] memberArray;
    String[] ageArray;
    VivzAdapter(Context c,String[] members,int imgs[], String[] ages)
    {
        super(c,R.layout.single_row,R.id.textView,members);
        this.context=c;
        this.images=imgs;
        this.memberArray=members;
        this.ageArray=ages;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row, parent, false)  ;
        ImageView myImage=(ImageView) row.findViewById(R.id.imageView);
        TextView myMember=(TextView)  row.findViewById(R.id.textView)  ;
        TextView myAge=(TextView) row.findViewById(R.id.textView2);

        myImage.setImageResource(images[position]);
        myMember.setText(memberArray[position]);
        myAge.setText(ageArray[position]);

        return row;
    }
}
