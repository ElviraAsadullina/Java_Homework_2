package Seminar_2;

import java.util.*;


public class Task_1 {
    public static void main(String[] args) {
        String formula = getString();
        String unique_formula = getUniqueVars(formula);
        String unique_formula1 = unique_formula.replace("[", "").replace("]", "");
        int[] collection = getValues(unique_formula1);
        List<Integer> count = getCount(formula, unique_formula1);
        int sum = getSum(collection, count);
        System.out.println("Результат: "+sum);
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
            chars.add(c);
        }
        return chars.toString();
    }
    public static int[] getValues(String equation) {
        Scanner str = new Scanner(System.in);
        String[] st1 = equation.split(",");
        int[] numbers = new int [st1.length];
        System.out.println("Введите значения для переменных: ");
        for (int i = 0; i < st1.length; i++) {
            System.out.print(st1[i]+ " = ");
            numbers[i] = str.nextInt();
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
}

