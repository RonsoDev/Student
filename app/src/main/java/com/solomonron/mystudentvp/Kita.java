package com.solomonron.mystudentvp;

import android.os.Parcel;
import android.os.Parcelable;

public class Kita implements Parcelable{

    private int id;
    private String firstName;

    private String lastName;
    private String kita;
    private String school;
    private String kindergarden;
    private String city;

    private boolean isSelected = false;





    public Kita(String city) {
        this.city = city;
    }

    public Kita(String city, String school) {
        this.school = school;
        this.city = city;
    }

    public Kita(String kita, String school, String city) {
        this.kita = kita;
        this.school = school;
        this.city = city;
    }

    public Kita(int id, String firstName, String lastName, String kita, String school, String kindergarden, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kita = kita;
        this.school = school;
        this.kindergarden = kindergarden;
        this.city = city;
    }

    protected Kita(Parcel in) {
        id = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        kita = in.readString();
        school = in.readString();
        kindergarden = in.readString();
        city = in.readString();
        isSelected = in.readByte() != 0;
    }

    public static final Creator<Kita> CREATOR = new Creator<Kita>() {
        @Override
        public Kita createFromParcel(Parcel in) {
            return new Kita(in);
        }

        @Override
        public Kita[] newArray(int size) {
            return new Kita[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getKita() {
        return kita;
    }

    public void setKita(String kita) {
        this.kita = kita;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getKindergarden() {
        return kindergarden;
    }

    public void setKindergarden(String kindergarden) {
        this.kindergarden = kindergarden;
    }


    public Kita() {

    }

    public Kita(int id, String city) {
        this.id = id;
        this.city = city;

    }

    public Kita(int id) {
        this.id = id;
    }

    public Kita(int id, boolean isSelected, String city) {
        this.id = id;
        this.isSelected = isSelected;
        this.city = city;
    }



    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(school);

    }
}
