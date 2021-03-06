package survey.android.futuretek.ch.ft_survey;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * Implements all functions about from the next button
 */

public class NextButtonActivity extends BaseActivity {

    protected Button nextBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
    }

    protected void onResume() {
        super.onResume();
        deactivateNextButton();
    }

    protected void createNextButton(final Activity fromActivity, final Class<?> toActivity) {
        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(fromActivity, toActivity));
            }
        });
    }

    protected void deactivateNextButton() {
        nextBtn.setTextColor(Color.GRAY);
        nextBtn.setEnabled(false);
    }

    protected void activateNextButton() {
        nextBtn.setTextColor(Color.GREEN);
        nextBtn.setEnabled(true);
    }

    protected void showAnimatedTextWithNextButtonActivation(List<String> textArray) {
        animateText(textArray, new AnimationListDone() {
            public void done() {
                activateNextButton();
            }
        });
    }
}
