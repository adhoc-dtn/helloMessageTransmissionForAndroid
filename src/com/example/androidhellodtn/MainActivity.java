package com.example.androidhellodtn;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                String address =
                    ((EditText)findViewById(R.id.txtIPAdress)).getText().toString();
                String strPort =
                    ((EditText)findViewById(R.id.txtPort)).getText().toString();
                int port = Integer.parseInt(strPort);
 
                Socket socket = null;
 
                try {
                    socket = new Socket(address,port);
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
 
                    String sendTxt =
                        ((EditText)findViewById(R.id.txtSend)).getText().toString();
 
                    pw.println(sendTxt);
 
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
 
                if( socket != null){
                    try {
                        socket.close();
                        socket = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
