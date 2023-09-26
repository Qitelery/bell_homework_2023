import java.util.*;
import java.util.stream.IntStream;

public class main {

    static int amountMessages;

    public static void main(String [] args){
        System.out.println(lenHemming(executeTask()));
    }

    public static Map<Integer, int[]> executeTask(){
        Scanner sc = new Scanner(System.in);

        Integer[] messageS = Arrays.stream(
                sc.nextLine().split(" ")
                )
                .map(
                        Integer::parseInt
                ).
                toArray(Integer[]::new);

        amountMessages = Integer.parseInt(sc.nextLine());

        Map<Integer, int[]> comparedArrays = new HashMap<>();

        for (int i = 1; i <= amountMessages; i++ ){
            Integer[] message = Arrays.stream(
                            sc.nextLine().split(" ")
                    )
                    .map(
                            Integer::parseInt
                    ).
                    toArray(Integer[]::new);
            int[] comparedArray = IntStream.range(0, messageS.length)
                    .map(j -> Integer.compare(message[j], messageS[j]))
                    .toArray();

            comparedArrays.put(i, comparedArray);
        }

        return comparedArrays;
    }

    public static ArrayList lenHemming(Map<Integer, int[]> comparedArrays){
        ArrayList<Integer> distHemming = new ArrayList<>();
        ArrayList<Integer> hemmingArray = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry: comparedArrays.entrySet()){
            long hemming = Arrays.stream(entry.getValue()).filter(x -> x == 0).count();
            hemmingArray.add((int) hemming);
        }
        int hemmingMin = hemmingArray.stream().max(Integer::compare).get();
        for (int i = 1; i <= amountMessages; i++){
            if(hemmingArray.get(i - 1) == hemmingMin){
                distHemming.add(i);
            }
        }
        return distHemming;
    }
}
