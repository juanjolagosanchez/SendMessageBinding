package com.example.sendmessageBinding.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sendmessageBinding.R;
import com.example.sendmessageBinding.SendMessageApplication;
import com.example.sendmessageBinding.data.Message;
import com.example.sendmessageBinding.data.User;
import com.example.sendmessageBinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Proyecto SendMessage<h1/>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <ul>
 *     <li>Crear un evento en un componente Buttom en codigo XML<li/>
 *     <li>Crear un escuchador/Listener del evento OnClick()<li/>
 *     <li>Crear un Intent y un elemento bundle para pasar información entre activity<li/>
 *     <li>El ciclo de vida de una activity<li/>
 *     <li>Manejar la pila de Actividades<li/>
 *     <ul/>
 * @author Juanjo Lago
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */

public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG= "SendMessageActivity";
    private ActivitySendMessageBinding binding;

    //region Ciclo de vida activity
    //Metodo que se ejecuta cuando se crea la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //se establece el vinculo entre el boton y su delegado
        //btsend.setOnClickListener(delegate);

        //Establecer el listener al boton mediante una clase anonimmq
        //que implementa la interfaz View.OnCklickListener
        binding.setMessage(new Message(((SendMessageApplication) getApplication()).getUser()));
        binding.btSend.setOnClickListener(view -> sendMessage());
        //btsend.setOnClickListener(view -> Toast.makeText(SendMessageActivity.this, "Es a traves de una clase anonima", Toast.LENGTH_SHORT).show());

        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }

    /**
     * Metodo callback que Crea el menu de opciones en la vista, se devuelve true prara indicar al SO
     * que se ha realizado la opcion de modificar el menú.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void sendMessage() {
        //TODO se modificará este ejercicio para estudiar viewBinding
        //Toast.makeText(this, "Hemos pulsado el boton", Toast.LENGTH_SHORT).show();
        //1. Crear el contenedor para añadir los datos
        Bundle bundle = new Bundle();
        //1.1 Pasar campo a campo
        //bundle.putString("user", etUser.getText().toString());
        //bundle.putString("message",etMessage.getText().toString());
        //1.2 Crear objeto Message
        bundle.putParcelable("message",binding.getMessage());
        //2. vamos a crear el objeto intent Explicito porque se conoce la actividad
        //destino
        Intent intent = new Intent(this,ViewMessageActivity.class);
        intent.putExtras(bundle);

        //3. Inicia la transicion entre una vista y otra
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    /**
     * Este metodo callback se llama cuando se pulsa sobre una de las opciones del menu
     * de la aplicacion
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_aboutus:
            //Toast.makeText(this, "se ha pulsado sobre aboutUs", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
            break;
        }
        return true;
    }

    /**
     * Este metodo se ejecuta cuando se destruye la activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }

    //endregion

    /**
     * Este metodo es el que se llama cuando se pulsa sobre el boton definido en el xml
     * android:onClick="sendMessage"
     * @param view
     */
    public void sendMessage(View view) {
       sendMessage();
    }

    /**
     * esta clase no anonima implementa el listener que responde siempre al evento OnClick
     */
    class sendOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(SendMessageActivity.this, "Es a traves de un delegado", Toast.LENGTH_SHORT).show();

        }
    }
}