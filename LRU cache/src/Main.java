//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LRU lru =  new LRU(5);

        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        lru.put(4, 40);
        lru.put(5, 50);
        lru.put(6, 60);

        lru.get(1);
        lru.get(3);

        lru.put(7, 70);
        lru.get(2);
    }
}