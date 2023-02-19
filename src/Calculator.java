import java.io.IOException;
import java.util.Scanner;

public class Calculator {

    public static String calc(String input) throws IOException {
        String[] newStroka;
        newStroka = input.toUpperCase().replaceAll(" ", "").split("[+\\-*/]", 2);

        String[] rimskie = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] rimskie1 = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int x = 0;
        int y = 0;
        int arabOrRim = 0;

        for (int i = 0; i < rimskie.length; i++) {
            if (newStroka[0].equals(rimskie[i])) {
                for (int j = 0; j < rimskie.length; j++) {
                    if (newStroka[1].equals(rimskie[j])) {
                        arabOrRim = 1;
                        x = i + 1;
                        y = j + 1;
                    }
                }
            }
        }

        int a = 0;
        int b = 0;
        int result = 0;

        if (arabOrRim == 0) {
            a = Integer.parseInt(newStroka[0]);
            b = Integer.parseInt(newStroka[1]);
        } else if (arabOrRim == 1) {
            a = x;
            b = y;
        }

        char[] znak;
        znak = input.toUpperCase().replaceAll(" ", "").toCharArray();

        if (a <= 10 && a >= 1 && b <= 10 && b >= 1) {
            for (int i = 0; i < znak.length; i++) {
                switch (znak[i]) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
            }
        } else {
            throw new IOException();
        }

        if (arabOrRim == 0) {
            System.out.println(result);
        } else if (arabOrRim == 1) {
            if (result < 1) {
                throw new IOException();
            }
            String result1 = rimskie1[result];
            System.out.println(result1);
        }
        String resultToStroka = Integer.toString(result);
        return resultToStroka;
    }

    public static void main(String[] args) throws IOException {
        Scanner stroka = new Scanner(System.in);
        calc(stroka.nextLine());
    }
}
