package com.malkinfo.rentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.malkinfo.rentalapp.listeners.ItemListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * HomesActivity displays a list of homes available for rental.
 * It retrieves data from the Firebase Realtime Database and populates a RecyclerView with home items.
 */
public class HomesActivity extends AppCompatActivity implements ItemListener {

    private RecyclerView topDealRv;
    private HomeAdapter adapter;
    ArrayList<HomeModal> itemList = new ArrayList<HomeModal>();

    private CircleImageView profileImage;
    public TextView username, useremail;

    FirebaseDatabase database;
    DatabaseReference ref;
    Button updateButton;
    String uname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        topDealRv = findViewById(R.id.top_deal_RV);
        profileImage = findViewById(R.id.profile_image);
        username = findViewById(R.id.user_name);

        uname = getIntent().getStringExtra("username");
        username.setText(uname);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomesActivity.this, ProfileActivity.class);
                intent.putExtra("username", uname);
                startActivity(intent);
            }
        });

        ref = database.getInstance().getReference().child("users");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                UserClass user = snapshot.getValue(UserClass.class);

                if (user != null) {
                    Glide.with(HomesActivity.this)
                            .load(user.getImage())
                            .centerCrop()
                            .placeholder(R.drawable.baseline_account_circle_24)
                            .into(profileImage);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {}

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        FirebaseDatabase.getInstance().getReference().child("homes")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        itemList.clear();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            HomeModal homeModal = dataSnapshot.getValue(HomeModal.class);
                            if (homeModal != null) {
                                itemList.add(homeModal);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("FirebaseError", "Database error: " + error.getMessage());
                    }
                });

        adapter = new HomeAdapter(HomesActivity.this, itemList, HomesActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomesActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        topDealRv.setLayoutManager(linearLayoutManager);
        topDealRv.setAdapter(adapter);
    }

    /**
     * Invoked when an item in the RecyclerView is clicked.
     * Launches the DetailsActivity to display detailed information about the selected home item.
     *
     * @param position The position of the clicked item in the RecyclerView.
     */
    @Override
    public void OnItemPosition(int position) {
        Intent intent = new Intent(HomesActivity.this, DetailsActivity.class);
        HomeModal homeModal = itemList.get(position);
        intent.putExtra("price", homeModal.price);
        intent.putExtra("location", homeModal.location);
        intent.putExtra("description", homeModal.description);
        intent.putExtra("shortDescription", homeModal.shortDescription);
        intent.putExtra("image", homeModal.image);
        startActivity(intent);
    }
}
