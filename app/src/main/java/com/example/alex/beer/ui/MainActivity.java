package com.example.alex.beer.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alex.beer.Constants;
import com.example.alex.beer.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Bind(R.id.findLiquorsButton) Button mfindLiquorsButton;
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mfindLiquorsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mfindLiquorsButton) {
            String name = mNameEditText.getText().toString();
//            if(!(name).equals("")) {
//                addToSharedPreferences(name);
//            }
            Intent intent = new Intent(MainActivity.this, BeerListActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }

    private void addToSharedPreferences(String name) {
        mEditor.putString(Constants.PREFERENCES_NAME_KEY, name).apply();
    }
}

