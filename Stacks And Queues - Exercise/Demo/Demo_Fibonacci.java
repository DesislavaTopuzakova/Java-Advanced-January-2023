import java.util.Scanner;

public class Demo_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ЧИСЛА / РЕДИЦА НА ФИБОНАЧИ = 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ....
        //F1 = F2 = 1
        //F3 = F1 + F2
        //F4 = F2 + F3
        //F5 = F3 + F4
        //F6 = F4 + F5
        //F48 = F46 + F47
        //F49 = F48 + F47
        //F50 = F48 + F49
        //Fn = ?
        int n = Integer.parseInt(scanner.nextLine()); //за кое поред число искам да намеря Fn?
        System.out.println(fib(n));
    }
    public static long fib (int n) {
        //n = 1 -> F1 = 1
        //n = 2 -> F2 = 1
        if (n <= 2) {
            return 1;
        }

        //n = 20
        //F20 = ? = F19 + F18
        return fib(n - 1) + fib (n - 2);
    }
}

