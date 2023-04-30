public class Queue<T> extends Node<T> {

    private Node<T> start = null;

    private Node<T> end = null;

    // count - длинна очереди
    private int count = 0;

    public Queue(T value) {
        super(value);
    }

    public void add (T value){
        Node<T> node = new Node<T>(value);
        if (start == null){
            start = node;
            end = node;
        } else{
            end.setNext(node);
            end = node;
        }

        count++;
    }

    public boolean remove(T item){
        Node<T> previous = null;
        Node<T> current = start;

        if (count == 0){
            System.out.println("Очередь пуста");
            return false;
        }

        while (current != null){
            if (current.getValue().equals(item)){
                // удаление элемента из середины списка
                if (previous != null){
                    previous.setNext(current.getNext());

                    // если элемент был в конце очереди
                    if (current.getNext() == null){
                        end = previous;
                    }
                }
                else{
                    //удаление первого элемента очереди
                    start = start.getNext();

                    //если в очереди был один элемент
                    if (start.getNext() == null){
                        end = null;
                    }
                }
                //уменьшение длинны очереди
                count--;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public void print (){
        Node list = start;
        while (list != null){
            System.out.println(list.getValue());
            list = list.getNext();
        }
    }

}
