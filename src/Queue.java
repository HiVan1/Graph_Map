public class Queue {
    private int[] array;
    private int size;
    private int head;
    private int tail;
    private int count;

    public Queue(int size) {
        this.size = size;
        array = new int[size];
        head = 0;
        tail = -1;
        count = 0;
    }

    public void insert(int v){
        if (tail == size -1){
            tail = -1;
        }
        array[++tail] = v;
        count ++;
    }

    public int remove(){
        if (head == size){
            head = 0;
        }
        count--;
        return array[head++];

    }

    public boolean isEmpty(){
        return count == 0;
    }
}
