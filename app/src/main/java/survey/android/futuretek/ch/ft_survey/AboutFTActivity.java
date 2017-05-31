/**
 * Copyright (C) futuretek AG 2016
 * All Rights Reserved
 *
 * @author Artan Veliju
 */
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

public class AboutFTActivity extends NextButtonActivity {
    private String userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        createNextButton(AboutFTActivity.this, PortraitActivity.class);
    }

    protected void onResume() {
        super.onResume();

        userName=getDatabase().get("usersName");
        List<String> textArray;

        textArray = new ArrayList<>();
        textArray.add("Futuretek is growing and growing!");
        textArray.add("The goal for the developer section is to bring the best people together and to build incredible things.");
        if(userName!=null)
            textArray.add(userName);
        textArray.add("Do you think you are one of them?");
        textArray.add("Tell us more about what you know.");
        animateText(textArray, new AnimationListDone() {
            public void done() {
                activateNextButton();
            }
        });
    }
}