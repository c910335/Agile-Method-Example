package tw.tatsujin.sort.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import tw.tatsujin.sort.Sort;

import java.util.Arrays;

public class ThenSort extends Stage<ThenSort> {
    @ExpectedScenarioState
    private Sort sort;

    @ExpectedScenarioState
    private int[] array;

    public ThenSort the_sorted_array_should_be(int[] array) {
        assertThat(this.array).isEqualTo(array);
        return self();
    }
}
