package survey.android.futuretek.ch.ft_survey;


import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example test cases for the PortraiActivity.
 */
public class PortraitActivityTest {

    @Test
    public void testCorrectWithUsername() {
        PortraitActivity portraitActivity = new PortraitActivity();
        List<String> textArray = portraitActivity.getPortraitText();

        assertTrue(textArray.get(0).contains("Pascal"));
    }

    @Test
    public void testTextWithoutUsername() {
        PortraitActivity portraitActivity = new PortraitActivity();
        List<String> textArray = portraitActivity.getPortraitText();

        assertFalse(textArray.get(0).contains("Markus"));
    }
}
