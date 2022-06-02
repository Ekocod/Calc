import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите данные: два операнда и один оператор(+, -, *, /) с пробелами");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        calc(input);
        System.out.println("Результат:");
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        int res;
        String[] mas = input.split(" ");
        if (mas.length != 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор(+, -, *, /) с пробелами");
        }
        try {
            int num1 = Integer.parseInt(mas[0]);
            int num2 = Integer.parseInt(mas[2]);
            if (num1 < 1 || num1 > 10) {
                throw new Exception("Калькулятор принимает только целые числа от 1 до 10 включительно");
            }
            if (num2 < 1 || num2 > 10) {
                throw new Exception("Калькулятор принимает только целые числа от 1 до 10 включительно");
            } else {
                switch (mas[1]) {
                    case "+" -> input = String.valueOf(num1 + num2);
                    case "-" -> input = String.valueOf(num1 - num2);
                    case "*" -> input = String.valueOf(num1 * num2);
                    case "/" -> input = String.valueOf(num1 / num2);
                    default -> throw new Exception("Неверный оператор(+, -, *, /)");
                }
            }
        } catch (Exception e){
            int num1 = romanToArab(mas[0]);
            int num2 = romanToArab(mas[2]);
            if (num1 < 1 || num1 > 10) {
                throw new Exception("Калькулятор принимает только целые числа от 1 до 10 включительно");
            }
            if (num2 < 1 || num2 > 10) {
                throw new Exception("Калькулятор принимает только целые числа от 1 до 10 включительно");
            } else {
                switch (mas[1]) {
                    case "+" -> res = num1 + num2;
                    case "-" -> res = num1 - num2;
                    case "*" -> res = num1 * num2;
                    case "/" -> res = num1 / num2;
                    default -> throw new Exception("Неверный оператор(+, -, *, /)");
                }
                if (res < 1){
                    throw new Exception("В римской системе нет отрицательных чисел");
                }
                input = arabToRoman(res);
            }
        }
        return input;
    }

    private static int romanToArab (String roman) throws Exception {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (Exception e) {
            throw new Exception("Неверный формат данных");
        }
        return -1;
    }

    private static String arabToRoman (int arab) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            return roman[arab];
    }
}
