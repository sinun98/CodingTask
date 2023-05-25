package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 */
@Data
@AllArgsConstructor
public class IntervalDto {
    private Integer min;
    private Integer max;

    @Override
    public String toString(){
        return "[" + min + "," + max +"]";
    }
}
