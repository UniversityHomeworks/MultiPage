package top.jonakls.multipage.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.jonakls.multipage.DetailUser;
import top.jonakls.multipage.R;
import top.jonakls.multipage.user.User;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private final List<User> users;

    public UserListAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_items, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = this.users.get(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView email;
        private final TextView phone;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.viewUserName);
            this.email = itemView.findViewById(R.id.viewUserEmail);
            this.phone = itemView.findViewById(R.id.viewUserPhone);

            final Button sendButton = itemView.findViewById(R.id.sendButton);
            sendButton.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailUser.class);
                intent.putExtra("name", name.getText());
                intent.putExtra("email", email.getText());
                intent.putExtra("phone", phone.getText());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}