package com.food4thought.food4thought;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.food4thought.api.FFTHandler;
import com.food4thought.api.FoodForThoughtAPI;
import com.food4thought.food4thought.model.ApplicationModel;
import com.food4thought.food4thought.ui.view.food4thoughtapp.Food4ThoughtAppView;
import com.google.gson.JsonElement;

import java.util.LinkedList;


public class AlpacaMaker extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Food4ThoughtAppView view = new Food4ThoughtAppView(this);
        view.setTimeBackground();
        setContentView(view);
        view.setApplicationModel(ApplicationModel.mainModel);
        ApplicationModel.mainModel.requestState();

    }

    @Override
    protected void onResume(){
        super.onResume();
      //  ((Food4ThoughtAppView) (getCurrentFocus())).setTimeBackground();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alpaca_maker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
