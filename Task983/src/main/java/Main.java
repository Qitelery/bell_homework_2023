import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static ArrayList<ArrayList<Integer>> lstHumans = new ArrayList<>();

    public static void main (String[] args) {
        Arrays.stream(calculation(initialize())).forEach(System.out::println);

    }


    private static ArrayList<ArrayList<Integer>> initialize (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество человек:");
        int humans = Integer.parseInt(sc.nextLine());
        System.out.println("Введите пары чисел скорость/количество ступеней:");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int human = 0; human < humans; human++) {
            arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
            Collections.addAll(lstHumans, arr);
        }
        return lstHumans;
    }

    private static int[] calculation(ArrayList<ArrayList<Integer>> array){
        int[] result = new int[array.size()];
        ArrayList<ArrayList<Integer>> sortedArray = new ArrayList<>(lstHumans);
        return sortPerSpeed(result, sortedArray);
    }

    private static int[] sortPerSpeed(int[] result, ArrayList<ArrayList<Integer>> sortedArray){
        int NotFound = -1;
        int man = 0;
        int speed = 0;
        int steps = 1;
        ArrayList<ArrayList<Integer>> max = new ArrayList<>();
        max.add(new ArrayList<>(Arrays.asList(speed, steps)));
        if (sortedArray.size() > 1){
            for (int manI = 0; manI < sortedArray.size(); manI++){
                if(sortedArray.get(manI).get(speed) > max.get(man).get(speed)){
                    max.set(man, new ArrayList<>(sortedArray.get(manI)));
                }
            }
            int lastFoundIndex = 0;
            for (Iterator<ArrayList<Integer>> iterator = sortedArray.iterator(); iterator.hasNext(); ) {
                ArrayList<Integer> list = iterator.next();
                if(list.get(steps) >= max.get(man).get(steps)) {
                    int index = -1;
                    for (int j = lastFoundIndex; j < lstHumans.size(); j++) {
                        if (lstHumans.get(j).equals(list)) {
                            index = j;
                            lastFoundIndex = j + 1;
                            break;
                        }
                    }
                    result[index] = max.get(man).get(speed) * max.get(man).get(steps);
                    iterator.remove();
                }
            }
            if(!sortedArray.isEmpty()){
                sortPerSpeed(result, sortedArray);
            }
        } else{
            int index = IntStream.range(0, lstHumans.size())
                    .filter(j -> lstHumans.get(j).equals(sortedArray.get(man)))
                    .findFirst().orElse(NotFound);
            result[index] = sortedArray.get(man).get(speed)*sortedArray.get(man).get(steps);
        }
        return result;
    }
}