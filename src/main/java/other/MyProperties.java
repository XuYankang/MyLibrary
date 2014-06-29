package other;

/**
 * Created by Administrator on 2014/6/25.
 */
public class MyProperties {
    public static void main(String[] args) {
        int x = 3;
        int y = (x++) + (x++) + (x++);
        System.out.println(new MyProperties().getValue(2));
    }

    public int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }


}
