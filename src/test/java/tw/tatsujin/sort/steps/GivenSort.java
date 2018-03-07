package tw.tatsujin.sort.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import tw.tatsujin.sort.Sort;
import tw.tatsujin.sort.SortImpl;

public class GivenSort extends Stage<GivenSort>{
    @ProvidedScenarioState
    private Sort sort;

    @ProvidedScenarioState
    private int[] array;

    public GivenSort a_sort() {
        sort = new SortImpl();
        return self();
    }

    public GivenSort an_array(int[] array) {
        this.array = array;
        return self();
    }
}
