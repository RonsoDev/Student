package com.solomonron.mystudentvp;

import com.solomonron.mystudentvp.Kita;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class School extends ExpandableGroup<Kita> {
    public School(String title, List<Kita> items) {
        super(title, items);
    }


}
