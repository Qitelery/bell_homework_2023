public class Main {
    public static void main (String[] args){
        Queue<Integer> queue = new Queue<Integer>(7);
        queue.remove(4);
        for (int i = 1; i<=7; i++){
            queue.add(i);
        }
        System.out.println("Созданная очередь:");
        queue.print();
        queue.remove(4);
        System.out.println("Очередь после удаления элемента из середины:");
        queue.print();
        queue.remove(7);
        System.out.println("Очередь после удаления элемента с конца:");
        queue.print();
    }
}
