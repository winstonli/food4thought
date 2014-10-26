package com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.food4thought.food4thought.R;
import com.food4thought.food4thought.RecipeActivity;
import com.food4thought.food4thought.model.Ingredient;
import com.food4thought.food4thought.model.Recipe;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Subscriber;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.ingredientnumber.IngredientNumberView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipeimage.SimpleRecipeImageView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.simplerecipename.SimpleRecipeNameView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.simplerecipe.timeindicator.TimeIndicatorView;
import com.squareup.picasso.Picasso;

/**
 * Created by Roxy on 25/10/14.
 */
public class SimpleRecipeView extends RelativeLayout implements Subscriber<Recipe> {

    public static final String RECIPE_ID = "RECIPE_ID";
    private ImageView simpleRecipeImageView;
    private TimeIndicatorView timeIndicatorView;
    private IngredientNumberView ingredientNumberView;
    private SimpleRecipeNameView simpleRecipeNameView;
    private Recipe recipe;


    //private LinearLayout containerView;
   // private ImageView imgView;

    //private LinearLayout imgView;
    //private LinearLayout textView;

    public SimpleRecipeView(Context context, Drawable img) {
        super(context);
        //setOrientation(LinearLayout.VERTICAL);
        setPadding(10, 10, 10, 10);

        setClickable(true);
        setGravity(Gravity.CENTER);
        simpleRecipeNameView = new SimpleRecipeNameView(context);

        simpleRecipeImageView = new ImageView(context);
        //simpleRecipeImageView.setBackgroundColor(Color.CYAN);
        //simpleRecipeImageView.setText("Hi");
        simpleRecipeImageView.setImageDrawable(img);
        simpleRecipeImageView.setBackgroundColor(Color.BLACK);
        addView(simpleRecipeImageView);
        addView(simpleRecipeNameView);
        //setBackground(getResources().getDrawable(R.drawable.base));
        //setText("Fried Alpaca Dumplings");

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //Log.wtf("wut", left + " " + top + " " + right + " " + bottom);
        //containerView.setLayoutParams(new ViewGroup.LayoutParams(right, bottom));
        simpleRecipeImageView.setLayoutParams(new LayoutParams(right, (int) (0.80 * bottom)));
        simpleRecipeNameView.setLayoutParams(new LayoutParams(right, (int) (0.20 * bottom)));

    }

    public void setRecipe(Recipe recipe) {
        if (this.recipe != null) {
            this.recipe.publisher.unsubscribe(this);
        }
        this.recipe = recipe;
        recipe.publisher.subscribe(this);
    }

    @Override
    public void update(PublishCode code, final Recipe publisher) {
        Log.wtf("miaow", "recipe update to: " + publisher);
        int total = publisher.getIngredients().size();
        int current = 0;
        for (Ingredient ingredient : Ingredient.selectedIngredients) {
            if (publisher.getIngredients().contains(ingredient)) {
                current++;
            }
        }
        Picasso.with(getContext()).load(publisher.getURL()).into(simpleRecipeImageView);
        simpleRecipeNameView.setText(publisher.getName() + " (" + current + "/" + total + ")");
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), recipe.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), RecipeActivity.class);
                intent.putExtra(RECIPE_ID, publisher.getID());
                getContext().startActivity(intent);
            }
        });
    }

}
