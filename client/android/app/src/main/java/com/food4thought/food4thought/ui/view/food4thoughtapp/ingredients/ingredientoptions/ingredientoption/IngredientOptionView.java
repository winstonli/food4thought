package com.food4thought.food4thought.ui.view.food4thoughtapp.ingredients.ingredientoptions.ingredientoption;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.food4thought.food4thought.R;
import com.food4thought.food4thought.model.Ingredient;
import com.food4thought.food4thought.model.pubsub.PublishCode;
import com.food4thought.food4thought.model.pubsub.Subscriber;

/**
 * Created by Roxy on 25/10/14.
 */
public class IngredientOptionView extends Button implements Subscriber<Ingredient> {

    //public static final int FUD_ID = 1;

    private Ingredient ingredient;

    public IngredientOptionView(Context context) {
        super(context);
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Bariol_Regular.otf");
        setTypeface(myTypeface);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredient.invertSelected();
                Toast.makeText(getContext(), ingredient.getName(), Toast.LENGTH_LONG).show();

            }
        });
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        ingredient.publisher.subscribe(this);
    }

    @Override
    public void update(PublishCode code, Ingredient publisher) {
        setText(publisher.getName());
        if (publisher.isSelected()) {
            setBackgroundColor(Color.argb(50, 255, 0, 0));
        } else {
            setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
    }

    public Ingredient getIngredient() {
        return ingredient;
    }
}
