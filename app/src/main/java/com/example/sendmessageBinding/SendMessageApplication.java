package com.example.sendmessageBinding;

import android.app.Application;

import com.example.sendmessageBinding.data.User;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


public class SendMessageApplication extends Application {
    //usuario que ha iniciado sesion. DATO GLOBAL porque siempre se va a acceder a el
    //mediante el metodo getApplication().getUser()
    private User user;


    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Se ha iniciado el objeto Application");
        user =  new User("pepe","ejemplo@ejemplo.com");

    }
    public User getUser() {
        return user;
    }

}
