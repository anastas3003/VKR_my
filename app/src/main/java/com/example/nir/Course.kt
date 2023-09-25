package com.example.nir

import android.os.Parcel
import android.os.Parcelable

data class Course(var Name: String, var Img: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeInt(Img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Course> {
        override fun createFromParcel(parcel: Parcel): Course {
            return Course(parcel)
        }

        override fun newArray(size: Int): Array<Course?> {
            return arrayOfNulls(size)
        }
    }
}