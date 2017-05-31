/**
 * Copyright (C) futuretek AG 2016
 * All Rights Reserved
 *
 * @author Artan Veliju
 */
package survey.android.futuretek.ch.ft_survey;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AboutFTActivity extends NextButtonActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNextButton(AboutFTActivity.this, PortraitActivity.class);
    }

    protected void onResume() {
        super.onResume();
        showAnimatedTextWithNextButtonActivation(getAboutText(getDatabase().get("usersName")));
    }

    private List<String> getAboutText(String userName) {
        List<String> textArray = new ArrayList<>();
        textArray.add("Futuretek is growing and growing!");
        textArray.add("The goal for the developer section is to bring the best people together and to build incredible things.");

        if(userName!=null)
            textArray.add(userName);

        textArray.add("Do you think you are one of them?");
        textArray.add("Tell us more about what you know.");

        return  textArray;
    }
}