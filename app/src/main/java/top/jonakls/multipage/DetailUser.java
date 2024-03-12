package top.jonakls.multipage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        TextView name = findViewById(R.id.userNameDetail);
        TextView email = findViewById(R.id.emailDetail);
        TextView phone = findViewById(R.id.phoneDetail);
        Button back = findViewById(R.id.backButton);

        Intent intent = getIntent();

        if (intent == null) {
            return;
        }

        name.setText(intent.getStringExtra("name"));
        email.setText(intent.getStringExtra("email"));
        phone.setText(intent.getStringExtra("phone"));

        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(DetailUser.this, MainActivity.class);
            startActivity(backIntent);
        });
    }
}