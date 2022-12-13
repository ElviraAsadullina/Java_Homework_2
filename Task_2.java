package Seminar_2;

import java.text.DecimalFormat;
import java.util.*;


public class Task_2 {
    public static void main(String[] args) {
        String formula = getString();
        String unique_formula = getUniqueVars(formula);
        System.out.println(unique_formula);
        String unique_formula1 = unique_formula.replace("[", "").replace("]", "");
        System.out.println(unique_formula1);
        char[] collection = getValues(unique_formula1);
        System.out.println(collection);
        String unique_formula2 = getReadyEquation(collection);
        System.out.println(unique_formula2);
        List<Integer> count = getCount(formula, unique_formula1);
//        int sum = getSum(collection, count);
//        System.out.println("Результат: "+sum);
    }

    public static String getString() {
        Scanner str = new Scanner(System.in);
        String equation;
        System.out.println("Введите формулу для подсчета суммы: ");
        equation = str.nextLine();
        return equation;
    }
    public static String getUniqueVars(String line) {
        Set<Character> chars = new TreeSet<>();
        for( char c : line.toCharArray() ) {
            if (c == '+') continue;
            if (c == '=') continue;
            chars.add(c);
        }
        return chars.toString();
    }
    public static char[] getValues(String equation) {
        Scanner str = new Scanner(System.in);
        String[] st1 = equation.split(",");
        char numbers[] = {};
        System.out.println("Введите значения для переменных: ");
        for (int i = 0; i < st1.length; i++) {
            System.out.print(st1[i]+ " = ");
            numbers[i] = str.next().charAt(0);
        }
        return numbers;
    }

    public static List<Integer> getCount(String line, String line1) {
        int count = 0;
        List<Integer> counts = new ArrayList<Integer>();
        for (int i = 0; i < line1.length(); i++) {
            char needed = line1.charAt(i);
            if (needed == ',') continue;
            if (needed == ' ') continue;
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '+') continue;
                if (line.charAt(j) == needed) {
                    count++;
                }
            }
            counts.add(count);
            count = 0;
        }
        return counts;
    }
    public static int getSum(int[] values, List<Integer> counts) {
        int sums = 0;
        for (int i = 0, j = 0; i < values.length & j < counts.size(); i++, j++) {
            sums += values[i] * counts.get(j);
        }
        return sums;
    }
    public static String getReadyEquation(char[] characters) {
        String equation = "";
        for (int i = 0; i < characters.length; i++) {
            if (i < characters.length - 2) {
                equation += characters[i]+"+";
            }
            else if (i == characters.length - 2) {
                equation += characters[i]+"=";
            }
            else {
                equation += characters[i];
            }
        }
        return equation;
    }
//    public static String MissingDigit(String[] line) {
//        DecimalFormat format = new DecimalFormat("0.#");
//        double result;
//        String res;
//        if (line[2].contains("?")) {
//            if (operand == '+') {
//                result = Double.parseDouble(line[0]) + Double.parseDouble(line[1]);
//                line[2] = format.format(result) + "";
//            } else if (operand == '-') {
//                result = Double.parseDouble(line[0]) - Double.parseDouble(line[1]);
//                line[2] = format.format(result) + "";
//            } else if (operand == '*') {
//                result = Double.parseDouble(line[0]) * Double.parseDouble(line[1]);
//                line[2] = format.format(result) + "";
//            } else if (operand == '/') {
//                result = Double.parseDouble(line[0]) / Double.parseDouble(line[1]);
//                line[2] = format.format(result) + "";
//            }
//        }
//        else if (line[0].contains("?")) {
//            if (operand == '+') {
//                result = Double.parseDouble(line[2]) - Double.parseDouble(line[1]);
//                line[0] = format.format(result) + "";
//            }
//            if (operand == '-') {
//                result = Double.parseDouble(line[2]) + Double.parseDouble(line[1]);
//                line[0] = format.format(result) + "";
//            }
//            if (operand == '*') {
//                result = Double.parseDouble(line[2]) / Double.parseDouble(line[1]);
//                line[0] = format.format(result) + "";
//            }
//            if (operand == '/') {
//                result = Double.parseDouble(line[2]) * Double.parseDouble(line[1]);
//                line[0] = format.format(result) + "";
//            }
//        }
//        else if (line[1].contains("?")) {
//            if (operand == '+') {
//                result = Double.parseDouble(line[2]) - Double.parseDouble(line[0]);
//                line[1] = format.format(result) + "";
//            } else if (operand == '-') {
//                result = Double.parseDouble(line[0]) - Double.parseDouble(line[2]);
//                line[1] = format.format(result) + "";
//            } else if (operand == '*') {
//                result = Double.parseDouble(line[2]) / Double.parseDouble(line[0]);
//                line[1] = format.format(result) + "";
//            } else if (operand == '/') {
//                result = Double.parseDouble(line[0]) / Double.parseDouble(line[2]);
//                line[1] = format.format(result) + "";
//            }
//        }
//        res = line[0]+operand+line[1]+"="+line[2];
//        return res;
//    }
}
