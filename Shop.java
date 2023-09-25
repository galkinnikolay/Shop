import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.PriorityQueue;

public class Shop {
    private List<Toy> toys;

    private PriorityQueue<Toy> queueToys;

    public PriorityQueue<Toy> getQueueToys() {
        return queueToys;
    }

    public Shop() {
        toys = new ArrayList<>();
        queueToys = new PriorityQueue<>();
    }

    public void addNewToy(int id, String name, int weight) throws RuntimeException {
        toys.add(new Toy(id, name, weight));
    }

    public Toy GetToy() throws RuntimeException {
        if (toys.size() == 0) {
            throw new RuntimeException("Коллекция игрушек для розыгрыша пуста. Добавьте элементы");
        }
        int sumWeigths = 0;
        for (Toy t : toys) {
            sumWeigths += t.getWeight();
        }
        Random rnd = new Random();
        int randomValue = rnd.nextInt(sumWeigths);

        sumWeigths = 0;
        for (Toy t : toys) {
            sumWeigths += t.getWeight();
            if (sumWeigths > randomValue) {
                queueToys.add(t);

                return t;
            }
        }
        throw new RuntimeException("Shop::GetToy(), ошибка алгоритма");
    }
}