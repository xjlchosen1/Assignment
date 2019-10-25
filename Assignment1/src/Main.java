import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private String[][] grid = new String[4][4];
    private String[][] show = new String[4][4]; //桌上展示的牌面
    private int x1, y1, x2, y2;
    private int count = 8;  //每次匹配成功-1
    private ArrayList<String> cards = new ArrayList<>(16);

    //开始游戏
    public void playGame() {
        cards.add("A");
        cards.add("A");
        cards.add("Q");
        cards.add("Q");
        cards.add("K");
        cards.add("K");
        cards.add("J");
        cards.add("J");
        cards.add("2");
        cards.add("2");
        cards.add("5");
        cards.add("5");
        cards.add("6");
        cards.add("6");
        cards.add("9");
        cards.add("9");
        Collections.shuffle(cards);

        //将打乱顺序的牌放到二维数组中
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = cards.get(temp);
                temp++;
            }
        }

        //桌上的牌面开始都是反着的，全部是$
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                show[i][j] = "$";
            }
        }

        System.out.println("   1  2  3  4");
        for (int i = 0; i < 4; i++) {
            System.out.print(i+1);
            for (int j = 0; j < 4; j++) {
                System.out.print("  $");
            }
            System.out.println();
        }

        //开始翻牌
        while (count > 0) {
            System.out.println("请输入两张牌的坐标，按照“行 列 行 列”的顺序！");
            while (true) {
                Scanner sc = new Scanner(System.in);
                String[] numbers = sc.nextLine().split(" ");
                x1 = Integer.parseInt((numbers[0]));
                y1 = Integer.parseInt((numbers[1]));
                x2 = Integer.parseInt((numbers[2]));
                y2 = Integer.parseInt((numbers[3]));

                if (x1 < 1 || x1 > 4 || y1 < 1 || y1 > 4 || x2 < 1 || x2 > 4 || y2 < 1 || y2 > 4) {
                    System.out.println("输入坐标有误，请重新输入！");
                } else if (x1 == x2 && y1 == y2) {
                    System.out.println("两张牌坐标相同，请重新输入！");
                } else {
                    break;
                }
            }

            //翻开选择的两张牌
            System.out.println("   1  2  3  4");
            for (int i = 0; i < 4; i++) {
                System.out.print(i+1);
                for (int j = 0; j < 4; j++) {
                    if ((i+1 == x1 && j+1 == y1) || (i+1 == x2 && j+1 == y2)) {
                        System.out.print("  " + grid[i][j]);    //被选中的展示牌面
                    } else {
                        System.out.print("  " + show[i][j]);    //没被选中的还是桌上的牌
                    }
                }
                System.out.println();
            }

            //配对成功，将桌上的牌翻过来
            if (grid[x1 - 1][y1 - 1].equals(grid[x2 - 1][y2 - 1])) {
                show[x1 - 1][y1 - 1] = grid[x1 - 1][y1 - 1];
                show[x2 - 1][y2 - 1] = grid[x2 - 1][y2 - 1];
                count--;
                System.out.println("恭喜配对成功，请继续！");
                System.out.println();
            } else {
                //展示3秒
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException ex) {
                }

                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }

                System.out.println("   1  2  3  4");
                for (int i = 0; i < 4; i++) {
                    System.out.print(i+1);
                    for (int j = 0; j < 4; j++) {
                        System.out.print("  " + show[i][j]);
                    }
                    System.out.println();
                }
            }



        }
        System.out.println("恭喜您成功通过了游戏！！！");
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.playGame();
    }

}
