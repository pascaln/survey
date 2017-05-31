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

public class NextButtonActivity extends BaseActivity {

    protected Button nextBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void onResume() {
        super.onResume();
        deactivateNextButton();
    }

    protected void deactivateNextButton() {
        nextBtn.setTextColor(Color.GRAY);
        nextBtn.setEnabled(false);
    }


    protected void activateNextButton() {
        Button nextBtn = ((Button) findViewById(R.id.nextBtn));
        nextBtn.setTextColor(Color.GREEN);
        nextBtn.setEnabled(true);
    }
}
