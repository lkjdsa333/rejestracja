package com.example.rejestracja;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText repeatPasswordEditText;
    private TextView messageTextView;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        messageTextView = findViewById(R.id.messageTextView);
        titleTextView = findViewById(R.id.titleTextView);
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(v -> validateForm());
        messageTextView.setText("Autor: Victoria Dudek");;
    }

    private void validateForm() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String repeatPassword = repeatPasswordEditText.getText().toString();
        if (!email.contains("@")) {
            messageTextView.setText("Niepoprawny adres email");
        } 
        else if (password.length() == 0) {
            messageTextView.setText("hasło jest puste");
        } 
        else if (password.length() < 4) {
            messageTextView.setText("hasło jest za krótkie");
        } 
        else if (!password.equals(repeatPassword)) {
            messageTextView.setText("Hasła się różnią");
        } 
        else {
            messageTextView.setText("Witaj " + email);
        }
    }
}
