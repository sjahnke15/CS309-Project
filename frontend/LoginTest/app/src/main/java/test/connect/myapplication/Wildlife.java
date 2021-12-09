package test.connect.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class Wildlife extends AppCompatActivity {
    ImageView back;
    Button send;
    TextView messageOutput;
    EditText messageInput;

    private WebSocketClient wsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildlife2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        int userID = intent.getIntExtra("userID", 0);

        connectWebSocket(username);

        back = (ImageView)findViewById(R.id.btnMapFromWildlife);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Wildlife.this, GoogleMaps.class);
                wsc.close();
                back.putExtra("username", username);
                back.putExtra("email", email);
                back.putExtra("password", password);
                back.putExtra("userID", userID);
                startActivity(back);
            }
        });

        send = findViewById(R.id.b_sendMessage);
        messageOutput = findViewById(R.id.m_output);
        messageInput = findViewById(R.id.m_input);

        messageOutput.setMovementMethod(new ScrollingMovementMethod());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageInput.getText().toString();

                if(message != null && message.length() > 0) {
                    wsc.send(message);
                }
            }
        });
    }

    public void connectWebSocket(String username) {
        String socket = "http://10.0.2.2:8080/chat/" + username;
        Log.i("Connection", socket);
        URI uri;

        try {
            uri = new URI(socket);
        } catch(URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        wsc = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.i("Websocket", "Opened");
            }

            @Override
            public void onMessage(String message) {
                Log.i("Websocket", "Message Received");
                messageOutput.append("\n" + message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.i("Websocket", "Closed: " + reason);
            }

            @Override
            public void onError(Exception ex) {
                Log.i("Websocket", "Error: " + ex.getMessage());
            }
        };

        wsc.connect();
    }
}