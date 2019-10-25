/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.toIntExact;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * NumberToWords class takes an input and converts it into words
 *
 * @author kavya
 */
public class NumberToWords {

    private double money;

    private static final String[] THOUSAND_ABOVE = {
            "",
            " thousand",
            " million",
            " billion"
    };

    private static final String[] TENS = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninty"
    };

    private static final String[] ONES = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    /**
     * This method takes an input which is a decimal and prints the word format
     * of this number
     */
    public void takeInput() {
        String number = "", decimal = "";
        String money;
        long moneyLong;
        Scanner out = new Scanner(System.in);
        System.out.println("Please enter a dollar amount:");
        this.money = out.nextDouble();
        if (validateMoney(this.money)) {
            money = BigDecimal.valueOf(this.money).toPlainString();
            StringTokenizer token = new StringTokenizer(money, ".");
            while (token.hasMoreElements()) {
                number = decimal;
                decimal = token.nextToken();
            }
            moneyLong = Double.valueOf(this.money).longValue();
            if (validateLong(moneyLong)) {
                System.out.print(convertNumber(moneyLong));
                if (!decimal.equals("0")) {
                    System.out.println("AND " + convertDecimal(decimal));
                }
            } else {
                System.out.println("Please enter a number within the billion range");
            }
        }
    }

    private boolean validateLong(Long money) {
        return String.valueOf(money).length() <= 12;
    }

    /**
     * validates the money entered
     *
     * @param money
     * @return
     */
    public boolean validateMoney(Double money) {
        if (money < 0) {
            System.out.println("Number is negative");
            return false;
        }
        return true;
    }

    /**
     * This method converts the money less than 1000
     *
     * @param number
     * @return String
     */
    public String convertNumberLessThanThousand(int number) {
        String word;
        if (number % 100 < 20) {
            word = ONES[number % 100];
            number /= 100;
        } else {
            word = ONES[number % 10];
            number /= 10;

            word = TENS[number % 10] + " " + word;
            number /= 10;
        }
        if (number == 0) {
            return word;
        } else {
            return ONES[number] + " hundred " + word;
        }
    }

    /**
     * This method converts a given number
     *
     * @param number
     * @return String
     */
    public String convertNumber(Long number) {
        if (number == 0) {
            return "zero ";
        }
        String word = "";
        int place = 0;

        do {
            int n = toIntExact(number % 1000);
            if (n != 0) {
                String s = convertNumberLessThanThousand(n);
                word = s + THOUSAND_ABOVE[place] + " " + word;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return word;
    }

    /**
     * This method converts the decimal part of the number entered
     *
     * @param decimal
     * @return String
     */
    public String convertDecimal(String decimal) {

        String denominator = getDenominator(decimal.length());
        return String.format("%s/%s", decimal, denominator);

    }

    private String getDenominator(int numberOfZeroes) {
        String result = "1";
        for (int i = 0; i < numberOfZeroes; i++) {
            result += "0";
        }
        return result;
    }
}
