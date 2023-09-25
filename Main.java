import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        try {
            Shop shop = new Shop();
            int id = 0;
            shop.addNewToy(id++, "Мяч", 45);
            shop.addNewToy(id++, "Лего", 50);
            shop.addNewToy(id++, "Замок", 50);
            shop.addNewToy(id++, "Кукольный домик", 55);
            shop.addNewToy(id++, "Машинка", 55);

            for (int j = 0; j < 10; j++) {
                System.out.println("Разыграна игрушка: " + shop.GetToy());
            }

            String pathFile = "toys.txt";
            FileWriter fw = new FileWriter(pathFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PriorityQueue<Toy> queueToys = shop.getQueueToys();
            while(queueToys.size() > 0){
                Toy t = queueToys.element();
                bw.write(t.toString() + System.lineSeparator());
                queueToys.remove();
            }
            bw.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }
}