package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.graphics.Color;
import android.util.Log;
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

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientOptionsView extends LinearLayout implements Subscriber<SuggestedIngredients> {

    private IngredientOptionView ingredientOptionView;
    //private ArrayList<IngredientOptionView> options = new ArrayList<IngredientOptionView>();


    ScrollView scrollView;
    LinearLayout scrollViewInner;
    public IngredientOptionsView(Context context) {
        super(context);

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
    }

    @Override
    public void update(PublishCode code, SuggestedIngredients publisher) {
    /*    int maxWidth = this.getWidth();
        int currentWidth = 0;
        LinearLayout currentLine = new LinearLayout(getContext());
        addView(currentLine);
        currentLine.setOrientation(LinearLayout.HORIZONTAL);
        for(Ingredient i: publisher.getIngredients()) {
            IngredientOptionView view = new IngredientOptionView(getContext(), i.getName(), i.getId());
            int buttonWidth = view.getWidth();
            if (maxWidth >= (currentWidth + buttonWidth)) {
            } else {
                currentLine = new LinearLayout(getContext());
                addView(currentLine);
                currentLine.setOrientation(LinearLayout.HORIZONTAL);
                currentWidth = 0;
            }
            currentLine.addView(view);
            currentWidth += buttonWidth;

            view.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), ((IngredientOptionView) view).getFudName(), Toast.LENGTH_LONG).show();
                }
            });
            //options.add(view);
            scrollViewInner.addView(view);
        }*/
    }
}
