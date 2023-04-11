public class palindrome {
    public static void main(String[] args) {
        System.out.println(rev2(1234));
        System.out.println(palin(1234321));

    }

    static int sum = 0;

    static void rev1(int n) {
        if (n == 0) {
            return;
        }

        sum = sum * 10 + (n % 10);
        rev1(n / 10); 
    }

    static int rev2(int n) {
        int digits = (int)(Math.log10(n) + 1);
        return helper(n, digits);
    }

    static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }

        return (n % 10) * ((int)Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }

    static boolean palin(int n) {
        return n == rev2(n);
    }
}