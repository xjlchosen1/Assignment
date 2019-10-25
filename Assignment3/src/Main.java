import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static String[] lessThan20 = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTING", "FOURTING", "FIFTING", "SIXTING", "SEVENTING", "EIGHTING", "NINETING"};

    private static String[] tens = {"TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};

    private void start() {
        System.out.println("请输入要转换的数字：");
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();

        String stringNum = Double.toString(num);
        String[] str = stringNum.split("\\.");
        int integer = Integer.parseInt(str[0]);
        int decimal = Integer.parseInt(str[1]);
        if (decimal < 10) {
            decimal = decimal * 10;
        }

        if (integer >= 1000) {
            int thousand = integer / 1000;
            //System.out.println(lessThan20[thousand] + "THOUSAND");
            if (integer - thousand * 1000 >= 100) {
                    int hundred = (integer - thousand * 1000) / 100;
                if (integer - thousand * 1000 - hundred * 100 >= 20) {
                    int ten = (integer - thousand * 1000 - hundred * 100) / 10;
                    int single = integer - thousand * 1000 - hundred * 100 - ten * 10;
                    System.out.println(lessThan20[thousand] + " THOUSAND " + lessThan20[hundred] + " HUNDRED " + tens[ten - 2] + " " + lessThan20[single] + " AND " + decimal + "/100");
                }
                else if (integer - thousand * 1000 - hundred * 100 > 10) {
                    int ten = integer - thousand * 1000 - hundred * 100;
                    System.out.println(lessThan20[thousand] + " THOUSAND " + lessThan20[hundred] + " HUNDRED " + lessThan20[ten] + " AND " + decimal + "/100");
                }
                else {
                    int single = integer - thousand * 1000 - hundred * 100;
                    System.out.println(lessThan20[thousand] + " THOUSAND " + lessThan20[hundred] + " HUNDRED " + lessThan20[single] + " AND " + decimal + "/100");
                }
            }
            else if (integer - thousand * 1000 >= 20) {
                int ten = (integer - thousand * 1000) / 10;
                int single = integer - thousand * 1000 - ten * 10;
                System.out.println(lessThan20[thousand] + " THOUSAND " + tens[ten - 2] + " " + lessThan20[single] + " AND " + decimal + "/100");
            }
            else {
                int single = integer - thousand * 1000;
                System.out.println(lessThan20[thousand] + " THOUSAND " + lessThan20[single] + " AND " + decimal + "/100");
            }
        }
        else if (integer >= 100) {
            int hundred = integer / 100;
            if (integer - hundred * 100 >= 20) {
                int ten = (integer - hundred * 100) / 10;
                int single = integer - hundred * 100 - ten * 10;
                System.out.println(lessThan20[hundred] + " HUNDRED " + tens[ten - 2] + " " + lessThan20[single] + " AND " + decimal + "/100");
            }
            else {
                int single = integer - hundred * 100;
                System.out.println(lessThan20[hundred] + " HUNDRED " + lessThan20[single] + " AND " + decimal + "/100");
            }
        }
        else if (integer >= 20) {
            int ten = integer / 10;
            int single = integer - ten * 10;
            System.out.println(tens[ten - 2] + " " + lessThan20[single] + " AND " + decimal + "/100");
        }
        else {
            System.out.println(lessThan20[integer] + " AND " + decimal + "/100");
        }
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        while (true) {
            main.start();
        }

    }
}
