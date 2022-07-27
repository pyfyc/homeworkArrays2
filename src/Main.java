import java.util.Arrays;
import java.util.OptionalInt;

public class Main {

    // Метод инициализирует ваш массив и заполнит его случайными значениями
    // от 100_000 до 200_000.
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    // Метод отзеркаливает массив с помощью перестановки элементов массива.
    // Т.е. первый элемент меняется местами с последним, второй - с предпоследним, и т.д.
    static char[] reverseBySwapping(char array[], int arrayLen) {
        int i, k;
        char t;
        for (i = 0; i < arrayLen / 2; i++) {
            t = array[i];
            array[i] = array[arrayLen - i - 1];
            array[arrayLen - i - 1] = t;
        }
        return array;
    }

    // Метод отзеркаливает массив с помощью другого массива.
    static char[] reverseByTempArray(char array[], int arrayLen) {
        char[] arrayRev = new char[arrayLen];
        int j = arrayLen;
        for (int i = 0; i < arrayLen; i++) {
            arrayRev[j - 1] = array[i];
            j = j - 1;
        }
        return arrayRev;
    }

    public static void main(String[] args) {

        // Инициализация массива и его распечатка
        int[] arr = generateRandomArray();

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + arr[i]);
        }
        System.out.println();

        // Task 1:
        // Первым делом бухгалтеры попросили посчитать сумму всех выплат за месяц.
        // Нужно написать программу, которая решит эту задачу, и вывести в консоль результат
        // в формате: «Сумма трат за месяц составила … рублей».

        int totalAmt = 0;

        for (int i = 0; i < arr.length; i++) {
            totalAmt += arr[i];
        }
        System.out.println("Сумма трат за месяц составила " + totalAmt + " рублей");

        // Task 2:
        // Следующая задача — найти минимальную и максимальную трату за день.
        // Нужно написать программу, которая решит эту задачу, и вывести в консоль результат
        // в формате: «Минимальная сумма трат за день составила … рублей.
        // Максимальная сумма трат за день составила … рублей».

        int maxAmt = arr[0];
        int minAmt = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxAmt) {
                maxAmt = arr[i];
            }
            else if (arr[i] < minAmt) {
                minAmt = arr[i];
            }
        }
        System.out.println("Минимальная сумма трат за день составила " + minAmt + " рублей");
        System.out.println("Максимальная сумма трат за день составила " + maxAmt + " рублей");

        // Task 3:
        // А теперь нам нужно понять, какую в среднем сумму наша компания тратила в течение данных 30 дней.
        // Нужно написать программу, которая посчитает среднее значение трат за месяц
        // (то есть сумму всех трат за месяц поделить на количество дней), и вывести в консоль результат
        // в формате: «Средняя сумма трат за месяц составила … рублей».
        // Важно помнить: подсчет среднего значения может иметь остаток
        // (то есть быть не целым, а дробным числом).

        double avgAmt = totalAmt / arr.length;
        System.out.println("Средняя сумма трат за месяц составила " + avgAmt + " рублей");

        // Task 4:
        // В нашей бухгалтерской книге появился баг. Что-то пошло нет так, и Ф.И.О. сотрудников
        // начали отображаться в обратную сторону. Т.е. вместо «Иванов Иван Иванович» мы имеем
        // «чивонавИ навИ вонавИ».
        // Данные с именами сотрудников хранятся в виде массива символов (char[]).
        // Напишите код, который в случае такого бага будет выводить Ф.И.О. сотрудников в корректном виде.
        // В качестве данных для массива используйте:
        // char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        // В результате в консоль должно быть выведено "Ivanov Ivan".
        // Важно: не используйте дополнительные массивы для решения этой задачи.
        // Необходимо корректно пройти по массиву циклом и распечатать его элементы в правильном порядке.

        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        reverseFullName = reverseBySwapping(reverseFullName, reverseFullName.length);

        for (int i = 0; i < reverseFullName.length; i++) {
            System.out.print(reverseFullName[i]);
        }
    }
}