package com.solomonron.mystudentvp.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.solomonron.mystudentvp.R;

public class DialogFragKitotChoose extends DialogFragment {

    private static final String TAG = "DialogKitot";

    public interface OnItemListener{

        void sendKita(String input);
    }

    public OnItemListener mOnItemListener;

    private TextView schoolTitle;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.kitot_dialog_rv, container, false);
        schoolTitle = view.findViewById(R.id.schoolTitle);


        String input = schoolTitle.getText().toString();

        mOnItemListener.sendKita(input);

        getDialog().dismiss();


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mOnItemListener = (OnItemListener) getActivity();
        }catch (ClassCastException e){



        }
    }
}


