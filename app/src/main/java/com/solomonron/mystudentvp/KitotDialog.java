package com.solomonron.mystudentvp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class KitotDialog extends Dialog {

    public KitotDialog(Context context, myOnClickListener myclick) {
        super(context);
        this.myListener = myclick;
    }


    public myOnClickListener myListener;

    public interface myOnClickListener {
        void onButtonClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.kitot_dialog_rv);

        Button btn = (Button) findViewById(R.id.kitotList);
        btn.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                myListener.onButtonClick(); // I am giving the click to the
                // interface function which we need
                // to implements where we call this
                // class

            }
        });
    }
}
