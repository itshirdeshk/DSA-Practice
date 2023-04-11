public class dice {
    public static void main(String[] args) {
        Dice("", 4);
        DiceFace("", 10, 8);
    }

    static void Dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            Dice(p + i, target - i);
        }
    }

    static void DiceFace(String p, int target, int face) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++, i++) {
            DiceFace(p + i, target - i, face);
        }
    }
}
