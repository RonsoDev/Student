package com.solomonron.mystudentvp;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.SchoolViewHolder> {

    private final List<Kita> schoolList;
    private Context mContext;
    private Dialog kitaDialog;


    public SchoolListAdapter(List<Kita> schoolList) {
        this.schoolList = schoolList;
    }


    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_choose_row_item, parent, false);

        SchoolViewHolder holder = new SchoolViewHolder(view);

        holder = openKiotDialog(holder);

        return holder;
    }

    private SchoolViewHolder openKiotDialog(final SchoolViewHolder holder) {
        kitaDialog = new Dialog(mContext);
        kitaDialog.setContentView(R.layout.kitot_dialog_rv);

        holder.schoolName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        TextView title = v.findViewById(R.id.schoolTitle);
        title.setText(schoolList.get(holder.getAdapterPosition()).getSchool());
                kitaDialog.show();
            }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder holder, int position) {

        final Kita kita = schoolList.get(position);
        holder.schoolName.setText(kita.getSchool());

    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    public class SchoolViewHolder extends RecyclerView.ViewHolder{

        ImageView school_choose_bg;
        ImageView school_choose_chkbox_empty;
        ImageView school_choose_chkbox_full;
        TextView schoolName;





        public SchoolViewHolder(@NonNull View itemView) {
            super(itemView);

            school_choose_bg = itemView.findViewById(R.id.school_choose_bg);
            school_choose_chkbox_empty = itemView.findViewById(R.id.school_choose_chkbox_empty);
            school_choose_chkbox_full = itemView.findViewById(R.id.school_choose_chkbox_full);
            schoolName = itemView.findViewById(R.id.schoolTitle);


        }
    }
}
