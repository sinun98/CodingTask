package service;

import model.IntervalDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MergeServiceTest {

    private MergeService service = new MergeService();

    /**
     * Tests the merge method with null input
     */
    @Test
    void mergeWithNullInput(){
        assertThat(service.merge(null)).isEmpty();
    }

    /**
     * Tests the merge method with empty input
     */
    @Test
    void mergeWithEmptyInput(){
        assertThat(service.merge(new ArrayList<>())).isEmpty();
    }

    /**
     * Tests the merge method with invalid input
     */
    @Test
    void mergeWithInvalidInput(){

        List<IntervalDto> input = List.of(new IntervalDto(10,1));

        assertThatThrownBy(() -> service.merge(input)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining(MergeService.AT_LEAST_ONE_INTERVAL_IS_INAVLID);
    }

    /**
     * Tests the merge method for technical correctness
     * @param input Raw input list
     * @param expected Expected result list
     */
    @ParameterizedTest
    @MethodSource("provideTestData")
    void merge(List<IntervalDto> input,List<IntervalDto> expected) {

        List<IntervalDto> result = service.merge(input);
        assertThat(result.size()).isEqualTo(expected.size());

        for(int i = 0;i < result.size(); i++){

            IntervalDto resultInterval = result.get(i);
            IntervalDto expectedInterval = expected.get(i);

            assertThat(resultInterval.getMax()).isEqualTo(expectedInterval.getMax());
            assertThat(resultInterval.getMin()).isEqualTo(expectedInterval.getMin());

        }
    }

    /**
     * Provides test data
     * @return Stream with test data
     */
    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(List.of(new IntervalDto(25, 30),new IntervalDto(2, 19),new IntervalDto(14, 23),new IntervalDto(4, 8)), List.of(new IntervalDto(2, 23),new IntervalDto(25, 30))),
                Arguments.of(List.of(new IntervalDto(1, 50),new IntervalDto(12, 20),new IntervalDto(70, 84),new IntervalDto(10, 15)), List.of(new IntervalDto(1, 50),new IntervalDto(70, 84))),
                Arguments.of(List.of(new IntervalDto(1, 20),new IntervalDto(10, 30),new IntervalDto(20, 40),new IntervalDto(50, 60)), List.of(new IntervalDto(1, 40),new IntervalDto(50, 60))),
                Arguments.of(List.of(new IntervalDto(1, 2),new IntervalDto(99, 100)), List.of(new IntervalDto(1, 2),new IntervalDto(99, 100)))

        );
    }
}