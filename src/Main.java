import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");
        checkLeapYear(2016);

        System.out.println("Task 2");
        System.out.println(checkOSAndYearDevice(1, 2015));

        System.out.println("Task 3");
        int deliveryDays = calculateDeliveryDays(55);

        if (deliveryDays != -1) {
            System.out.println("Для доставки потребуется " + calculateDeliveryDays(55) + " " + pluralizeDays(deliveryDays));
        } else {
            System.out.println("На это расстояние мы не возим.");
        }

        System.out.println("Task 4");
        String str = "aabccddefgghiijjjkk";
        findDuplicate(str);

        System.out.println("Task 5");
        int[] array = {3, 2, 1, 6, 5};
        System.out.println(Arrays.toString(array));
        reverseArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Task 6");
        int[] accountBook = generateRandomArray();
        System.out.println("Средняя сумма трат за месяц составила " + calculateAverageSum(accountBook) + " рублей");
    }

    private static void checkLeapYear(int year) {
        if (year%100 != 0 & year%4 == 0 || year%400 == 0) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }

    private static String checkOSAndYearDevice(int clientOS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 0 & clientDeviceYear == currentYear) {
            return "Установите версию приложения для iOS по ссылке";
        } else if (clientOS == 0 & clientDeviceYear < currentYear) {
            return "Установите облегченную версию приложения для iOS по ссылке";
        } else if (clientOS == 1 & clientDeviceYear == currentYear) {
            return "Установите версию приложения для Android по ссылке";
        } else if (clientOS == 1 & clientDeviceYear < currentYear) {
            return "Установите облегченную версию приложения для Android по ссылке";
        } else {
            return "Такой клиент не найден.";
        }
    }

    public static int calculateDeliveryDays(int deliveryDistance) {
        if (deliveryDistance < 20) {
            return 1;
        } else if (deliveryDistance < 60) {
            return 2;
        } else if (deliveryDistance < 100) {
            return 3;
        } else {
            return -1;
        }
    }

    private static String pluralizeDays(int num) {
        int end10 = num%10;
        int end100 = num%100;

        if ((end10 >= 2) & (end10 <= 4)) {
            return "дня";
        } else if (end100 >= 5 || end10 >= 5){
            return  "дней";
        } else return "день";
    }

    private static void findDuplicate(String str) {
        char[] charArray = str.toCharArray();

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1] ) {
                System.out.println("Найден дубль: " + charArray[i]);
                return;
            }
        }
        System.out.println("Дублей не найдено");

    }

    private static void reverseArray(int[] array) {
        for (int temp, i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private static double calculateAverageSum(int[] array) {
        return (double) sumAllElements(array) / array.length;
    }

    private static int sumAllElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    private static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
