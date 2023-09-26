import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class JackPot {

    public void JackPot(ArrayList<Integer> value, int numberOdcards){
        Optional<Integer> shrek = value.stream().sorted().skip(numberOdcards/2).reduce((x, y)->x+y);
        Optional<Integer> all = value.stream().reduce((x, y)->x+y);
        System.out.println(shrek.get() - (all.get() - shrek.get()));
    }
}
