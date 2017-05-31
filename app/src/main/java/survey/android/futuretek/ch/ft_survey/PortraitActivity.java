package survey.android.futuretek.ch.ft_survey;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naefp on 31.05.17.
 */

public class PortraitActivity extends NextButtonActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(PortraitActivity.this, SkillsActivity.class));
            }
        });

        View mainTextView = findViewById(R.id.textLayout);

    }

    protected void onResume() {
        super.onResume();

        ((ViewGroup)findViewById(R.id.textLayout)).removeAllViews();
        List<String> textArray;

        textArray = new ArrayList<>(3);
        textArray.add("Hi my Name is Pascal");
        textArray.add("I'm working at houzy.ch.");
        textArray.add("Before I had the position as CTO at moneyhouse.ch");
        animateText(textArray, new AnimationListDone() {
            public void done() {
                activateNextButton();
            }
        });

    }

}
