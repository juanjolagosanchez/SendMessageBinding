package com.example.sendmessageBinding.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Clase modelo que contiene el dato del usuario y el mensaje que manda
 * @author Juanjo
 * @version 1.0
 */
public class Message implements Serializable, Parcelable {
    private User user;
    private String content;
    //Por defecto si no se declara un constructor, java implementa el constructor vacio
    //Se debe implementar


    public Message(User user){
        this.user = user;
        this.content = content;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Este metodo devuelve la representacion de un objero Message
     * @return
     */
    @NonNull
    @Override
    public String toString() {
        return getUser()+ "->"+ getContent();
    }

    //region Metodos creados de la interfaz parcelable



    public Message(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        content = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(user, i);
        parcel.writeString(content);
    }
    //endregion
}
