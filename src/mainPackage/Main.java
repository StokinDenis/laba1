package mainPackage;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите колво еды ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Food[] breakfast = new Food[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Введите название еды:");
            String foodStr = scanner.next();
            switch (foodStr.toLowerCase()) {
                case "cheese" -> breakfast[i] = new Cheese();
                case "apple" -> {
                    System.out.println("Введите название размер яблока:");
                    String type = scanner.next();
                    breakfast[i] = new Apple(type);
                }
                case "pie" -> {
                    System.out.println("Введите название начинки пирога:");
                    String type = scanner.next();
                    breakfast[i] = new Pie(type);
                }
            }
        }
        for (Food item : breakfast) {
            item.consume();
        }

        Food food = new Pie("яблочная");
        System.out.println(food + ": " + countFoods(breakfast, food));
        printFoods(breakfast);
        System.out.println("Всего хорошего!");
    }

    static Integer countFoods(Food[] breakfast, Food food) {
        Integer count = 0;
        for (int i = 0; i < breakfast.length; i++) {
            if (food.equals(breakfast[i])) {
                count++;
            }
        }
        return count;
    }

    static void printFoods(Food[] breakfast) {
        int c = 0;
        int a = 0;
        int p = 0;
        for (int i = 0; i < breakfast.length; i++) {

            if (breakfast[i] instanceof Cheese) {
                c++;
            } else if (breakfast[i] instanceof Apple) {
                a++;
            } else if (breakfast[i] instanceof Pie) {
                p++;
            }
        }
        System.out.println("CЫР - " + c);
        System.out.println("ЯБЛОКО - " + a);
        System.out.println("ПИРОГ - " + p);
    }
}





