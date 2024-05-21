package com.malkinfo.rentalapp;



import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

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

public class HomesActivity extends AppCompatActivity implements ItemListener {

    private RecyclerView topDealRv;
    private HomeAdapter adapter;
    ArrayList<HomeModal> itemList = new ArrayList<HomeModal>();

    private CircleImageView profileImage;
    public TextView username,useremail;

    FirebaseDatabase database;
    DatabaseReference ref;
    Button updateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        topDealRv = findViewById(R.id.top_deal_RV);
        profileImage = findViewById(R.id.profile_image);
        username = findViewById(R.id.user_name);
        // useremail = findViewById(R.id.user_email);
        // updateButton = findViewById(R.id.update_button);

        ref = database.getInstance().getReference().child("users");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                UserClass user=snapshot.getValue(UserClass.class);

                if(user!=null){
                    username.setText(user.getName());
//                    useremail.setText(user.getEmail());
//                    id=snapshot.getKey();
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




//        HomeModal home1 = new HomeModal(1,"$200","Street #1 ,Bangladesh","2 Bedroom","AC room","https://da28rauy2a860.cloudfront.net/completehome/wp-content/uploads/2021/03/03114534/Millbrook-Homes-58series-1.jpg");
//        HomeModal home2 = new HomeModal(2,"$150","Street #2 ,Bangladesh","1 Bedroom","AC room","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhf6YjADHSKkG4zX6-1Dseq00TtJV9AYa2flzI_TWx5WPDyeRDrjKNBsLlnQaN6hk0s9I&usqp=CAU");
//        HomeModal home3 = new HomeModal(3,"$350","Street #4 ,Bangladesh","4 Bedroom","non AC room","https://www.bhg.com/thmb/H9VV9JNnKl-H1faFXnPlQfNprYw=/1799x0/filters:no_upscale():strip_icc()/white-modern-house-curved-patio-archway-c0a4a3b3-aa51b24d14d0464ea15d36e05aa85ac9.jpg");
//        FirebaseDatabase.getInstance().getReference().child("homes").child(String.valueOf(home1.id)).setValue(home1);
//        FirebaseDatabase.getInstance().getReference().child("homes").child(String.valueOf(home2.id)).setValue(home2);
//        FirebaseDatabase.getInstance().getReference().child("homes").child(String.valueOf(home3.id)).setValue(home3);

        FirebaseDatabase.getInstance().getReference().child("homes")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        itemList.clear();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            //Toast.makeText(HomesActivity.this, String.valueOf(dataSnapshot.getValue(HomeModal.class).description), Toast.LENGTH_SHORT).show();

                            HomeModal homeModal = dataSnapshot.getValue(HomeModal.class);
                            if (homeModal != null) {
                                //Toast.makeText(HomesActivity.this, homeModal.description, Toast.LENGTH_SHORT).show();
                                itemList.add(homeModal);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle possible errors
                        Log.e("FirebaseError", "Database error: " + error.getMessage());
                    }
                });








        adapter = new HomeAdapter(HomesActivity.this, itemList, HomesActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomesActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        topDealRv.setLayoutManager(linearLayoutManager);
        topDealRv.setAdapter(adapter);
    }


    @Override
    public void OnItemPosition(int position){


        Intent intent = new Intent(HomesActivity.this, DetailsActivity.class);
        HomeModal homeModal = itemList.get(position);
        // Toast.makeText(this,homeModal.description, Toast.LENGTH_SHORT).show();
        intent.putExtra("price",homeModal.price);
        intent.putExtra("location",homeModal.location);
        intent.putExtra("description",homeModal.description);
        intent.putExtra("shortDescription",homeModal.shortDescription);
        intent.putExtra("image",homeModal.image);
        startActivity(intent);
    }
}
