package tw.tatsujin.sort;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import tw.tatsujin.sort.steps.GivenSort;
import tw.tatsujin.sort.steps.ThenSort;
import tw.tatsujin.sort.steps.WhenSort;

public class SortSpec extends ScenarioTest<GivenSort, WhenSort, ThenSort> {
    @Test
    public void should_sort() {
        given().a_sort()
                .and().an_array(new int[] {3, 4, 2, 5, 1});

        when().sort();

        then().the_sorted_array_should_be(new int[] {1, 2, 3, 4, 5});
    }

    @Test
    public void should_sort_descending() {
        given().a_sort()
                .and().an_array(new int[] {3, 4, 2, 5, 1});

        when().sort_descending();

        then().the_sorted_array_should_be(new int[] {5, 4, 3, 2, 1});
    }
}
