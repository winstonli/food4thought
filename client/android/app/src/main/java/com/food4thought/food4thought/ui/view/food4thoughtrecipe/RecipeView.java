package com.food4thought.food4thought.ui.view.food4thoughtrecipe;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.food4thought.food4thought.model.Recipe;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Subscriber;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeimage.RecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeingredients.RecipeIngredientsView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.recipeinstructions.RecipeInstructionsView;
import com.food4thought.food4thought.ui.view.food4thoughtrecipe.time.TimeView;

/**
 * Created by Fiona on 25/10/2014.
 */
public class RecipeView extends LinearLayout implements Subscriber<Recipe> {

    //private RecipeImageView recipeImageView;
    //private TimeView timeView;
    private TextView recipeNameView;
    //private RecipeIngredientsView recipeIngredientsView;
    private RecipeInstructionsView recipeInstructionsView;
    private RecipeProfileView recipeProfileView;
    private Recipe recipe;

    public RecipeView(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.MAGENTA);

        /*recipeImageView = new RecipeImageView(context);
        addView(recipeImageView);
        timeView = new TimeView(context);
        addView(timeView);
        recipeIngredientsView = new RecipeIngredientsView(context);
        addView(recipeIngredientsView); */
        recipeNameView = new TextView(context);
        recipeProfileView = new RecipeProfileView(context);
        recipeInstructionsView = new RecipeInstructionsView(context);
        addView(recipeNameView);
        addView(recipeProfileView);
        addView(recipeInstructionsView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        recipeNameView.setLayoutParams(new LayoutParams(right, (int) (0.10 * bottom)));
        recipeProfileView.setLayoutParams(new LayoutParams(right, (int) (0.50 * bottom)));
        recipeInstructionsView.setLayoutParams(new LayoutParams(right, (int) (0.40 * bottom)));
    }

    public void setRecipe(Recipe recipe) {
        if (this.recipe != null) {
            this.recipe.publisher.unsubscribe(this);
        }
        this.recipe = recipe;
        recipe.publisher.subscribe(this);
    }

    @Override
    public void update(PublishCode code, Recipe publisher) {
        recipeNameView.setText(publisher.getName());

    }
}
