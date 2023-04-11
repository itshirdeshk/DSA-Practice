public class digitSum {
    public static void main(String[] args) {
        int result = DigitSum(123);
        System.out.println(result);
    }

    static int DigitSum(int n) {
        if (n == 0) {
            return 0;
        }

        return (n % 10) + DigitSum(n / 10);
    }
} 