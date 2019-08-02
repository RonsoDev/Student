package com.solomonron.mystudentvp;

import android.view.View;
import android.widget.TextView;

import com.solomonron.mystudentvp.Kita;
import com.solomonron.mystudentvp.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class KitaViewHolder extends ChildViewHolder {
    private TextView mTextView;

    public KitaViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView2);
    }

    public void bind(Kita kita){
        mTextView.setText(kita.getSchool());

    }
}
