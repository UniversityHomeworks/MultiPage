package top.jonakls.multipage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import top.jonakls.multipage.adapter.UserListAdapter;
import top.jonakls.multipage.user.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView userListView = findViewById(R.id.userListRecyclerView);
        userListView.setLayoutManager(new LinearLayoutManager(this));

        final List<User> users = new ArrayList<>();
        users.add(new User("John Doe", "jhon.doe@test.com", "1234567890"));
        users.add(new User("Jane Doe", "jane.doe@test.com", "0987654321"));
        users.add(new User("Jon Snow", "jon.snow@test.com", "1234567890"));
        users.add(new User("Arya Stark", "arya.stark@test.com", "0987654321"));
        users.add(new User("Sansa Stark", "sansa.stark@test.com", "1234567890"));


        final UserListAdapter adapter = new UserListAdapter(users);
        userListView.setAdapter(adapter);
    }
}