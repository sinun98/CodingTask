import model.IntervalDto;
import service.MergeService;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        List<IntervalDto> intervalDtos = List.of(new IntervalDto(25, 30),
                new IntervalDto(2, 19),
                new IntervalDto(14, 23),
                new IntervalDto(4, 8));



        System.out.print("Merging: ");
        intervalDtos.forEach(System.out::print);

        MergeService service = new MergeService();
        List<IntervalDto> result =  service.merge(intervalDtos);

        System.out.println();

        System.out.print("Result: ");
        result.forEach(System.out::print);



    }
}
