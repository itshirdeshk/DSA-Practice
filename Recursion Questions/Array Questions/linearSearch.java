import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 45,67, 778, 67, 67};
        System.out.println(find(arr, 67, 0));
        System.out.println(findAllIndex(arr, 67, 0, new ArrayList<>()));
        System.out.println(findAllIndex2(arr, 67, 0));
    }

    static boolean find(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }

        return arr[index] == target || find(arr, target, index + 1);
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndex(arr, target, index + 1, list);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index) {

        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        ArrayList<Integer> answerFromBelowCalls = findAllIndex2(arr, target, index + 1);

        list.addAll(answerFromBelowCalls);

        return list;
    }
}
