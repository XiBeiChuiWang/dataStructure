import java.util.Arrays;
import java.util.Comparator;
//非最优解
public class page0_1 {

    Thing[] things;
    Comparator comparator;

    public page0_1(Thing[] things, Comparator comparator) {
        this.things = things;
        this.comparator = comparator;
        Arrays.sort(things,comparator);
    }

    public void select(int page){
        int values = 0;
        for (int i = 0;i < things.length;i++){
            if (page < things[i].weight){
                continue;
            }
            System.out.println(things[i]);
            page -= things[i].weight;
            values += things[i].value;
        }
        System.out.println(values);
    }



    static class Thing{
        int id;
        int value;
        int weight;



        public Thing(int id, int value, int weight) {
            this.id = id;
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Thing{" +
                    "id=" + id +
                    ", value=" + value +
                    ", weight=" + weight +", v/w="
                    +(float)value/weight+
                    '}';
        }
    }

    public static void main(String[] args) {

        page0_1 page0_1 = new page0_1(new Thing[]{
                new Thing(1, 10, 35), new Thing(2, 40, 30),
                new Thing(3, 30, 60), new Thing(4, 50, 50),
                new Thing(5, 35, 40), new Thing(6, 40, 10),
                new Thing(7, 30, 25)
        }, new c());

        page0_1.select(150);
    }
}
class c implements Comparator<page0_1.Thing>{

    @Override
    public int compare(page0_1.Thing o1, page0_1.Thing o2) {
        return o2.value/o2.weight - o1.value/o1.weight;
    }
}

