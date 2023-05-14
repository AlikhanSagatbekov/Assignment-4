import java.util.Random;

public class TestClass{
    MyHashTable<String, Integer> table;
    public TestClass(){
        table = new MyHashTable<>();
    }

    public void addThousand(){
        Random rn = new Random();
        for(int j = 0; j < 200; j++){
            table.put("askar", rn.nextInt(1000));
        }
        for(int j = 0; j < 200; j++){
            table.put("jalil", rn.nextInt(2000));
        }
        for(int j = 0; j < 200; j++){
            table.put("aslan", rn.nextInt(3000));
        }
        for(int j = 0; j < 200; j++){
            table.put("alisher", rn.nextInt(4000));
        }
        for(int j = 0; j < 200; j++){
            table.put("alex", rn.nextInt(5000));
        }
    }
}