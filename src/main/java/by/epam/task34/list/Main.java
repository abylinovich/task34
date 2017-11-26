package by.epam.task34.list;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(list);
        System.out.println("add 0...50");
        for(int i = 0; i < 50; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println("add 10...20");
        for(int j = 10; j < 20; j++) {
            list.add(j, j*100);
        }
        System.out.println(list);
        System.out.println("get 0...10");
        for(int k = 0; k < 10; k++) {
            Integer result = list.get(k);
            System.out.print(result);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(list);
        System.out.println("set 0...10");
        for (int m = 0; m < 10; m++) {
            list.set(m, 111);
        }
        System.out.println(list);
        System.out.println("remove 40...rest");
        for (int n = 40; n < list.size(); n++) {
            list.remove(n);
        }
        System.out.println(list);
    }
}
