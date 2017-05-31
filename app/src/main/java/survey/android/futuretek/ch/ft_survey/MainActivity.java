/**
 * Copyright (C) futuretek AG 2016
 * All Rights Reserved
 *
 * @author Artan Veliju
 */
package survey.android.futuretek.ch.ft_survey;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends NextButtonActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNextButton(MainActivity.this, AboutFTActivity.class);

        View mainTextView = findViewById(R.id.textLayout);
        mainTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                requestUserName();
            }
        });
    }

    protected void onResume() {
        super.onResume();
        String userName = getDatabase().get("usersName");

        if (userName != null) {
            showAnimatedTextWithNextButtonActivation(getWelcomeWithUsernameText(userName));
        } else {
            animateText(getWelcomeWithoutUsernameText(), new AnimationListDone() {
                public void done() {
                    requestUserName();
                }
            });
        }
    }

    private void requestUserName() {
        openInputDialog(new View.OnClickListener() {
            public void onClick(View v) {
                String userName = ((EditText) v.findViewById(R.id.userInput)).getText().toString();
                if (userName == null || userName.isEmpty()) {
                    List<String> textArray = new ArrayList<String>(1);
                    textArray.add("Didn't get your name...");
                    animateText(textArray);
                } else {
                    getDatabase().storeUsername(userName);
                    List<String> textArray = new ArrayList<String>(2);
                    textArray.add("Ah, nice.");
                    textArray.add("Hi " + userName + "!");
                    showAnimatedTextWithNextButtonActivation(textArray);
                }
            }
        });
    }

    private List<String> getWelcomeWithUsernameText(String userName) {
        List<String> textArray = new ArrayList<>(3);
        textArray.add("Hi " + userName + "!");
        textArray.add("Welcome back to the survey of Futuretek.");
        textArray.add("If you want to know more about Futuretek touch the 'NEXT \u25B7' button.");

        return textArray;
    }

    private List<String> getWelcomeWithoutUsernameText() {
        List<String> textArray = new ArrayList<>(3);
        textArray.add("Hi there!");
        textArray.add("This is the survey of Futuretek.");
        textArray.add("What's your name?");

        return textArray;
    }
}

