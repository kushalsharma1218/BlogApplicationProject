package com.example.hp.blogapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    FloatingActionButton add_post_btn;
    private String user_id;

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private NotificationFragment notificationFragment;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        toolBar =  findViewById(R.id.toolbar);
//        setSupportActionBar(toolBar);
//
//        getSupportActionBar().setTitle("Photo Blog");

        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Blog App");

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        if (mAuth.getCurrentUser() != null) {


            bottomNavigationView = findViewById(R.id.mainBottomNav);

            //fragments
            homeFragment = new HomeFragment();
            notificationFragment = new NotificationFragment();
            accountFragment = new AccountFragment();
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


//         fragmentTransaction.replace(R.id.main_container,homeFragment);
//         fragmentTransaction.commit();
            replaceFragment(accountFragment);

            //Onclick on Bottom Nav Bar
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {

                        case R.id.bottomAccount:
                            replaceFragment(accountFragment);
                            return true;


                        case R.id.bottomHome:
                            replaceFragment(homeFragment);
                            return true;


                        case R.id.bottomNotification:
                            replaceFragment(notificationFragment);
                            return true;
                    }
                    return false;
                }
            });


            add_post_btn = findViewById(R.id.addPostButton);

            add_post_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    if (currentUser != null) {
                        user_id = mAuth.getCurrentUser().getUid();
                        final String uid = mAuth.getCurrentUser().getUid();
                        final DatabaseReference databaseReference1 = databaseReference.child(mAuth.getCurrentUser().getUid() + "/profile_Details");
                        DatabaseReference databaseReference2 = databaseReference1.child(uid);
                        ValueEventListener eventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (!dataSnapshot.exists()) {
                                    //create new user
                                    Intent addPost = new Intent(MainActivity.this, NewPost.class);
                                 startActivity(addPost);

                                } else {
                                    Toast.makeText(MainActivity.this, "Please choose profile photo and name", Toast.LENGTH_LONG).show();
                                    Intent main = new Intent(MainActivity.this, AccounrSetup.class);

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Log.e("AccountSetup", databaseError.getMessage()); //Don't ignore errors!
                            }
                        };
                        databaseReference2.addListenerForSingleValueEvent(eventListener);
                    } else {
                        Toast.makeText(MainActivity.this, "Please choose profile photo and name", Toast.LENGTH_LONG).show();
                        Intent main = new Intent(MainActivity.this, AccounrSetup.class);
                        startActivity(main);
                    }


                }
            });

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Check if user logged in
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            sendLogin();
            finish();
        }

    }

    private void sendLogin() {
        Intent ash = new Intent(MainActivity.this, Login.class);
        startActivity(ash);
    }

    //add menu drawable resource to action bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_logout:
                logOut();
                return true;

            case R.id.action_settings:
                Intent acS = new Intent(MainActivity.this, AccounrSetup.class);
                startActivity(acS);

                return true;

            default:
                return false;
        }
    }

    private void logOut() {
        mAuth.signOut();
        sendLogin();
    }

    //Fragment transition to change fragment when pressed
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commitNow();
    }

}
