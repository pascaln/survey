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
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends NextButtonActivity {
    private String userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

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
        List<String> textArray;
        if((userName=getDatabase().get("usersName"))!=null){
            textArray = new ArrayList<>(3);
            textArray.add("Hi "+userName+"!");
            textArray.add("Welcome back to the survey of Futuretek.");
            textArray.add("If you want to know more about Futuretek touch the 'NEXT \u25B7' button.");
            animateText(textArray, new AnimationListDone() {
                public void done() {
                    activateNextButton();
                }
            });
        }else{
            textArray = new ArrayList<>(3);
            textArray.add("Hi there!");
            textArray.add("This is the survey of Futuretek.");
            textArray.add("What's your name?");
            animateText(textArray, new AnimationListDone() {
                public void done() {
                    requestUserName();
                }
            });
        }
    }

    private void requestUserName(){
        if(userName==null){
            openInputDialog(new View.OnClickListener() {
                public void onClick(View v) {
                    userName = ((EditText) v.findViewById(R.id.userInput)).getText().toString();
                    if (userName == null || userName.isEmpty()) {
                        List<String> textArray = new ArrayList<String>(1);
                        textArray.add("Didn't get your name...");
                    } else {
                        getDatabase().put("usersName", userName);
                        List<String> textArray = new ArrayList<String>(2);
                        textArray.add("Ah, nice.");
                        textArray.add("Hi " + userName + "!");
                        animateText(textArray, new AnimationListDone() {
                            public void done() {
                                activateNextButton();
                            }
                        });
                    }
                }
            });
        }
    }

}

