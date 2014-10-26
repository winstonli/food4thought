package com.food4thought.food4thought;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.food4thought.food4thought.model.ApplicationModel;
import com.food4thought.food4thought.ui.view.food4thoughtapp.Food4ThoughtAppView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.SimpleRecipeView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.RecipeView;

/**
 * Created by Roxy on 26/10/14.
 */
public class RecipeActivity extends Activity {


    private RecipeView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int id = getIntent().getIntExtra(SimpleRecipeView.RECIPE_ID, -1);

        view = new RecipeView(this);
        setContentView(view);

        view.setRecipe(ApplicationModel.mainModel.getSuggestedRecipes().getRecipes().get(id));


    }

    @Override
    protected void onDestroy() {
        view.setRecipe(null);
        super.onDestroy();
    }

}


