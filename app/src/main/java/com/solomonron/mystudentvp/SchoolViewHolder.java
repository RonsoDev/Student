package com.solomonron.mystudentvp;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class SchoolViewHolder extends GroupViewHolder {
    private TextView mTextView;


    public SchoolViewHolder(View itemView) {
        super(itemView);

        mTextView=itemView.findViewById(R.id.textView2);
    }

    public void bind (School school){

        mTextView.setText(school.getTitle());
    }


}
