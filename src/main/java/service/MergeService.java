package service;

import lombok.NoArgsConstructor;
import model.IntervalDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service that provides the merge method
 */
@NoArgsConstructor
public class MergeService {

    public static final String AT_LEAST_ONE_INTERVAL_IS_INAVLID = "At least one interval is inavlid!";

    /**
     * Method to generate a list without overlapping values
     * @param intervalDtos Raw input list
     * @return List without overlapping values
     */
    public List<IntervalDto> merge(List<IntervalDto> intervalDtos) {

        //Fail fast
        if (intervalDtos == null || intervalDtos.isEmpty()) {
            return new ArrayList<>();
        }

        validateInput(intervalDtos);

        //Map the interval objects into an immutable list according to the min values to get the start interval
        List<IntervalDto> sortedList = intervalDtos.stream()
                .sorted(Comparator.comparingInt(IntervalDto::getMin))
                .collect(Collectors.toUnmodifiableList());

        List<IntervalDto> result = new ArrayList<>();
        IntervalDto comparedIntervalDto = sortedList.get(0);


        for (int i = 1; i < sortedList.size(); i++) {
            IntervalDto currentIntervalDto = sortedList.get(i);

            //Check if there is an overlap
            if (currentIntervalDto.getMin() <= comparedIntervalDto.getMax()) {
                //Set new max value if currentIntervalDto.max is greater
                comparedIntervalDto.setMax(Math.max(comparedIntervalDto.getMax(), currentIntervalDto.getMax()));
            } else {
                result.add(comparedIntervalDto);
                comparedIntervalDto = currentIntervalDto;
            }
        }

        result.add(comparedIntervalDto);

        return result;
    }

    /**
     * Validate interval list
     * Assume min value must be greater than max value
     * @param intervalDtos Raw input list
     */
    private void validateInput(List<IntervalDto> intervalDtos){
        intervalDtos.stream().filter(i -> i.getMin() >= i.getMax()).findFirst().ifPresent(s-> {
            throw new RuntimeException(AT_LEAST_ONE_INTERVAL_IS_INAVLID);
        });
    }

}
