import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task648 implements Task {
    int numberOfCards;
    ArrayList<Integer> cardsArray = new ArrayList<>();
    @Override
    public ArrayList<Integer> readInputData() {
        numberOfCards = Integer.parseInt(
                sc.nextLine()
        );
        Integer[] cards = Arrays.stream(
                        sc.nextLine().split(" ")
                )
                .map(
                        Integer::parseInt
                ).
                toArray(Integer[]::new);
        Collections.addAll(cardsArray, cards);
        return cardsArray;
    }

    @Override
    public void executeTask() {
        readInputData();
        JackPot jp = new JackPot();
        jp.JackPot(cardsArray, numberOfCards);
    }

}
