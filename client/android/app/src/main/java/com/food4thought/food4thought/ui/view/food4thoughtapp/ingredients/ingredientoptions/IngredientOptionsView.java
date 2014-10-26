package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.food4thought.food4thought.model.ApplicationModel;
import com.food4thought.food4thought.model.Ingredient;
import com.food4thought.food4thought.model.SuggestedIngredients;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Subscriber;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.friendlytext.FriendlyTextView;
import com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption.IngredientOptionView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientOptionsView extends LinearLayout implements Subscriber<SuggestedIngredients> {

    private IngredientOptionView ingredientOptionView;
    //private ArrayList<IngredientOptionView> options = new ArrayList<IngredientOptionView>();


    ScrollView scrollView;
    LinearLayout scrollViewInner;
    List<IngredientOptionView> subviews;

    public IngredientOptionsView(Context context) {
        super(context);

        subviews = new ArrayList<IngredientOptionView>();
        setOrientation(LinearLayout.VERTICAL);

        scrollView = new ScrollView(context);
        addView(scrollView);
        scrollViewInner = new LinearLayout(context);
        scrollViewInner.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(scrollViewInner);
        scrollView.setScrollContainer(false);

    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        scrollView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        for (IngredientOptionView view : subviews) {
            view.setPadding(0, (int) (0.1 * bottom), 0, (int) (0.05 * bottom));
        }
    }

    @Override
    public void update(PublishCode code, SuggestedIngredients publisher) {

        int currentWidth = 0;
        LinearLayout currentLine = new LinearLayout(getContext());
        scrollViewInner.addView(currentLine);
        currentLine.setOrientation(LinearLayout.HORIZONTAL);
        currentLine.setGravity(Gravity.CENTER);
        int noOfThings = 0;
        removeSubviews(publisher);

        subviews = new ArrayList<IngredientOptionView>();
        for(Ingredient i: publisher.getIngredients()) {
            IngredientOptionView view = new IngredientOptionView(getContext());
            view.setIngredient(i);
            subviews.add(view);
            currentLine.addView(view);
            LinearLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f * i.getName().length());
            view.setLayoutParams(lp);
            noOfThings++;
            if (noOfThings == 3 ) {
                noOfThings = 0;
                currentLine = new LinearLayout(getContext());
                scrollViewInner.addView(currentLine);
                currentLine.setOrientation(LinearLayout.HORIZONTAL);
                currentLine.setGravity(Gravity.CENTER);
            }
            //options.add(view);
            //scrollViewInner.addView(view);
        }

        requestLayout();
        if (noOfThings == 0) {
            return;
        }
        for (int i = 0; i < 3 - noOfThings; i++) {
            LinearLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f * (8 + new Random().nextInt(20)));
            View v = new Button(getContext());
            currentLine.addView(v);
            v.setVisibility(INVISIBLE);
            v.setLayoutParams(lp);
        }
    }

    private void removeSubviews(SuggestedIngredients publisher) {
        for (IngredientOptionView subview : subviews) {
            subview.getIngredient().publisher.unsubscribe(subview);
        }
    }
}
