public class countZero {
    public static void main(String[] args) {
        countZeros(100100, 0);
    }

    static void countZeros(int n, int count) {
        if (n == 0) {
            System.out.println(count);
            return; 
        }
    
        if (n % 10 == 0) {
            count++;
        }

        countZeros(n / 10, count);
    }
}
