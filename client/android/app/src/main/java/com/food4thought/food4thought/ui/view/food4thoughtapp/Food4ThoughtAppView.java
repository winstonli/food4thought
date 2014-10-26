package com.food4thought.food4thought.ui.view.food4thoughtapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.food4thought.food4thought.R;
import com.food4thought.food4thought.model.ApplicationModel;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Subscriber;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.IngredientsView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.simplerecipes.SimpleRecipesView;

/**
 * Created by Roxy on 25/10/14.
 */
public class Food4ThoughtAppView extends LinearLayout implements Subscriber<ApplicationModel> {

    private IngredientsView ingredientsView;
    private TextView youCanMakeView;
    private SimpleRecipesView simpleRecipesView;
    private ApplicationModel applicationModel;


    public Food4ThoughtAppView(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        setBackground(getResources().getDrawable(R.drawable.background_day));
//        setBackground(getResources().getDrawable(R.drawable.background_night));

        ingredientsView = new IngredientsView(context);
        addView(ingredientsView);
        youCanMakeView = new TextView(context);
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Bariol_Regular.otf");
        youCanMakeView.setTypeface(myTypeface);
        youCanMakeView.setGravity(Gravity.CENTER);
        youCanMakeView.setText("You can make: ");
        youCanMakeView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        addView(youCanMakeView);
        simpleRecipesView = new SimpleRecipesView(context);
        addView(simpleRecipesView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ingredientsView.setLayoutParams(new LayoutParams(right, (int) (0.65 * bottom)));
        youCanMakeView.setLayoutParams(new LayoutParams(right, (int) (0.05 * bottom)));
        simpleRecipesView.setLayoutParams(new LayoutParams(right, (int) (0.30 * bottom)));

    }

    public void setApplicationModel(ApplicationModel mainModel) {
        applicationModel = mainModel;
        mainModel.publisher.subscribe(this);
    }

    @Override
    public void update(PublishCode code, ApplicationModel publisher) {
        ingredientsView.setSuggestedIngredients(publisher.getSuggestedIngredients());
        simpleRecipesView.setSuggestedRecipes(publisher.getSuggestedRecipes());
    }
}
