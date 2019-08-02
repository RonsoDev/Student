package com.solomonron.mystudentvp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {StudentRoom.class}, version = 2, exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {


    public abstract MyDao mMyDao();
}
