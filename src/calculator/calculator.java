package calculator;
import java.util.InputMismatchException;
import java.util.Scanner;


public class calculator {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите арабские либо римские целые числа + действие + Enter ");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        num1 = romanTonum(stable00);
        num2 = romanTonum(string03);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calculated(num1, num2, operation);
            System.out.println("Результат для римских цифр");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(stable00);
        num2 = Integer.parseInt(string03);
        result = calculated(num1, num2, operation);
        System.out.println("Результат для арабских цифр");
        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };
        final String s = roman[numArabian];
        return s;
    }


        public void method(String[] args) {
            int num1 = 0;
            int nim2 = 0;
            String operation = null;
    
            System.out.println("Введите 2  целых числа: ");
            Scanner scanner = new Scanner(System.in);
            if (num1 > 0 || num1 < 10) {
                num1 = scanner.nextInt();
                operation = scanner.next();
                num2 = scanner.nextInt();
            }
    }


    private static int romanTonum (String roman) {
        switch(roman) {
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
            
        default :
        return 0;
        }
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Допускаются только целые числа");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}