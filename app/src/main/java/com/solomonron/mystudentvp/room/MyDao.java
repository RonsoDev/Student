package com.solomonron.mystudentvp.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {


    @Insert
    public void addStudent(StudentRoom studentRoom);

    @Query("select * from StudentRoom")
    public List<StudentRoom> getDB();

    @Query("DELETE FROM StudentRoom")
    public void nukeTable();



   @Query("SELECT kindergarden, city, school, last_name, first_name, is_selected, id, kita FROM StudentRoom WHERE city is 'תל אביב'")
    public List<StudentRoom> getTLVSchools();


    @Query("SELECT kindergarden, city, school, last_name, first_name, is_selected, id, kita FROM StudentRoom WHERE city is 'חולון'")
    public List<StudentRoom> getHLNSchools();

    @Query("SELECT kindergarden, city, school, last_name, first_name, is_selected, id, kita FROM StudentRoom WHERE city is 'רחובות'")
    public List<StudentRoom> getRHVTSchools();


    @Query("SELECT kindergarden, city, school, last_name, first_name, is_selected, id, kita FROM StudentRoom " +
            "WHERE school is 'ביאליק' and city is 'TLV'")
    public List<StudentRoom> getTLVbialic();


}
