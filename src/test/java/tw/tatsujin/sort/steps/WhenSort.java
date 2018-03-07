package tw.tatsujin.sort.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import tw.tatsujin.sort.Sort;

public class WhenSort extends Stage<WhenSort> {
    @ExpectedScenarioState
    private Sort sort;

    @ExpectedScenarioState
    private int[] array;

    public WhenSort sort() {
        sort.sort(array);
        return self();
    }

    public WhenSort sort_descending() {
        sort.sort(array, false);
        return self();
    }
}
