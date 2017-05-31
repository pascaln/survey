package survey.android.futuretek.ch.ft_survey;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * This class shows the portrait for Pascal Näf
 * Created by naefp on 31.05.17.
 */
public class PortraitActivity extends NextButtonActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNextButton(PortraitActivity.this, SkillsActivity.class);
    }

    protected void onResume() {
        super.onResume();
        showAnimatedTextWithNextButtonActivation(getPortraitText());
    }

    protected List<String> getPortraitText() {
        List<String> textArray = new ArrayList<>(4);
        textArray.add("Hi my Name is Pascal");
        textArray.add("I'm working at houzy.ch.");
        textArray.add("Before I had the position as CTO at moneyhouse.ch");
        textArray.add("More information about me you find on my webpage: www.pascalnaef.ch");

        return textArray;
    }
}
