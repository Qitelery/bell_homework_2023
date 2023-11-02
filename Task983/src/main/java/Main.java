import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static ArrayList<ArrayList<Integer>> lstHumans = new ArrayList<>();

    public static void main (String[] args) {
        calculation(initialize());

    }


    private static ArrayList<ArrayList<Integer>> initialize (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество человек:");
        int humans = Integer.parseInt(sc.nextLine());
        System.out.println("Введите пары чисел скорость/количество ступеней:");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < humans; i++) {
            arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            Collections.addAll(lstHumans, arr);
        }
        return lstHumans;
    }

    private static void calculation(ArrayList<ArrayList<Integer>> array){
        int[] result = new int[array.size()];
        ArrayList<ArrayList<Integer>> sortedArray = new ArrayList<>(lstHumans);
        Arrays.stream(sortPerSpeed(result, sortedArray)).forEach(System.out::println);
    }

    private static int[] sortPerSpeed(int[] result, ArrayList<ArrayList<Integer>> sortedArray){
        ArrayList<ArrayList<Integer>> max = new ArrayList<>();
        max.add(new ArrayList<>(Arrays.asList(0, 0)));
        if (sortedArray.size() > 1){
            for (int i = 0; i < sortedArray.size(); i++){
                if(sortedArray.get(i).get(0) > max.get(0).get(0)){
                    max.set(0, new ArrayList<>(sortedArray.get(i)));
                }
            }
            int lastFoundIndex = 0;
            for (Iterator<ArrayList<Integer>> iterator = sortedArray.iterator(); iterator.hasNext(); ) {
                ArrayList<Integer> list = iterator.next();
                if(list.get(1) >= max.get(0).get(1)) {
                    int index = -1;
                    for (int j = lastFoundIndex; j < lstHumans.size(); j++) {
                        if (lstHumans.get(j).equals(list)) {
                            index = j;
                            lastFoundIndex = j + 1;
                            break;
                        }
                    }
                    result[index] = max.get(0).get(0) * max.get(0).get(1);
                    iterator.remove();
                }
            }
            if(!sortedArray.isEmpty()){
                sortPerSpeed(result, sortedArray);
            }
        } else{
            int index = IntStream.range(0, lstHumans.size())
                    .filter(j -> lstHumans.get(j).equals(sortedArray.get(0)))
                    .findFirst().orElse(-1);
            result[index] = sortedArray.get(0).get(0)*sortedArray.get(0).get(1);
        }
        return result;
    }
}