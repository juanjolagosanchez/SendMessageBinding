package com.example.sendmessageBinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sendmessageBinding.R;
import com.example.sendmessageBinding.data.Message;
import com.example.sendmessageBinding.databinding.ActivityViewMessageBinding;

/**
 * clase que muestra un mensaje de un usuario. Recoge un mensaje que implementa la interfaz Parcelable
 */
public class ViewMessageActivity extends AppCompatActivity {

    private static final String TAG = "ViewMessageActivity";
    private ActivityViewMessageBinding binding;
    //regio cilo de vida
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //1. Recoger el Bundle que me han enviado en el intent que a iniciado
        //esta activa

        Bundle bundle = getIntent().getExtras();
        Message message = bundle.getParcelable("message");
        binding.setMessage(message);
        //binding.tvUserContent.setText(message.getUser().getName());
        //binding.tvMessageContent.setText(message.getContent());
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewMessageActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewMessageActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessageActivity -> onPause()");
    }

    /**
     * Este metodo se ejecuta cuando se destruye la activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
        Log.d(TAG, "ViewMessageActivity -> onDestroy()");
    }

    //endregion
}