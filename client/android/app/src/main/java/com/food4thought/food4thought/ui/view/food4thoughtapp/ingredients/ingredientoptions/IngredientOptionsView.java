package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.food4thought.food4thought.model.ApplicationModel;
import com.food4thought.food4thought.model.Ingredient;
import com.food4thought.food4thought.model.SuggestedIngredients;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Subscriber;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.friendlytext.FriendlyTextView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption.IngredientOptionView;

import java.util.ArrayList;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientOptionsView extends LinearLayout implements Subscriber<SuggestedIngredients> {

    private IngredientOptionView ingredientOptionView;
    private ArrayList<IngredientOptionView> options = new ArrayList<IngredientOptionView>();

    ScrollView scrollView;
    LinearLayout scrollViewInner;
    public IngredientOptionsView(Context context) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(Color.LTGRAY);

        scrollView = new ScrollView(context);
        addView(scrollView);
        scrollViewInner = new LinearLayout(context);
        scrollViewInner.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(scrollViewInner);
        scrollView.setScrollContainer(false);

        for(IngredientOptionView i : options) {
            scrollViewInner.addView(i);
        }

    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        scrollView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void update(PublishCode code, SuggestedIngredients publisher) {
        for (Ingredient ingredient : publisher.getIngredients()) {
            Log.wtf("miaow", ingredient.getName());
        }
        for(Ingredient i: publisher.getIngredients()) {
            IngredientOptionView view = new IngredientOptionView(getContext(), i.getName());
            options.add(view);
            scrollViewInner.addView(view);
        }
    }
}
