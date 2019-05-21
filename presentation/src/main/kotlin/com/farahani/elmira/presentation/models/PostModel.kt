package com.farahani.elmira.presentation.models

import android.os.Parcel
import android.os.Parcelable

data class PostModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : Parcelable {
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PostModel> = object : Parcelable.Creator<PostModel> {
            override fun createFromParcel(source: Parcel): PostModel = PostModel(source)
            override fun newArray(size: Int): Array<PostModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
        source.readInt(),
        source.readInt(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(userId)
        writeInt(id)
        writeString(title)
        writeString(body)
    }
}