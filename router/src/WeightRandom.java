/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/2/27 17:31
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightRandom {

    static List<WeightCategory> categorys = new ArrayList<WeightCategory>();
    private static Random random = new Random();

    public static void main(String[] args) {
        initData();
        Integer weightSum = 0;

        //累加合计取值范围区间，本次结果即为[0-100]内的数据
        for (WeightCategory wc : categorys) {
            weightSum += wc.getWeight();
        }

        //在[0-100]取值区间内，取一个随机数n
        Integer n = random.nextInt(weightSum); // n in [0, weightSum)
        System.out.println("the random number is :"+ n);
        Integer m = 0;
        for (WeightCategory wc : categorys) {
            //随机数n落在谁的领地，就是谁。领地越大，概率越高。
            if (n >= m && n < m + wc.getWeight()) {
                System.out.println("This Random Category is " + wc.getCategory());
                break;
            }
            //若未能落到此地，越过此人范围，去判断下一个
            m += wc.getWeight();
        }

    }
    //创建实体及其权重分配，权重比为60:30:10
    public static void initData() {
        WeightCategory wc1 = new WeightCategory("A",60);
        WeightCategory wc2 = new WeightCategory("B",30);
        WeightCategory wc3 = new WeightCategory("C",10);
        categorys.add(wc1);
        categorys.add(wc2);
        categorys.add(wc3);
    }

    //定义对象实体内部类
    static class WeightCategory {
        private String category;
        private Integer weight;


        public WeightCategory() {
            super();
        }

        public WeightCategory(String category, Integer weight) {
            super();
            this.setCategory(category);
            this.setWeight(weight);
        }


        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }
}

