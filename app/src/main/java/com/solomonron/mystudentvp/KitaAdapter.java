package com.solomonron.mystudentvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class KitaAdapter extends ExpandableRecyclerViewAdapter<SchoolViewHolder, KitaViewHolder> {
    public KitaAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public SchoolViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recycler_school, parent, false);
        return new SchoolViewHolder(v);
    }

    @Override
    public KitaViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recycler_classes, parent, false);

        return new KitaViewHolder(v);

    }

    @Override
    public void onBindChildViewHolder(KitaViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

        final Kita kita =(Kita) group.getItems().get(childIndex);
        holder.bind(kita);

    }

    @Override
    public void onBindGroupViewHolder(SchoolViewHolder holder, int flatPosition, ExpandableGroup group) {
        final School school =(School) group;
        holder.bind(school);


    }
}
