package com.example.prak4;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {

    private String name, desc;
    private int image;

    public Hero() { }

    public Hero(Parcel parcel) {
        this.name = parcel.readString();
        this.desc = parcel.readString();
        this.image = parcel.readInt();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel parcel) {
            return new Hero(parcel);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeInt(image);
    }
}
