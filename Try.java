import java.util.*;

public class Try {
    public static void main(String[] args) {
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            points.add(i + 1);
        }

        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0};

        System.out.println(Arrays.toString(removeZero(test1)));


    }


    static int[] removeZero(int[] containZero) {
        
        int count = 0;
        for (int m = 0; m < containZero.length; m++){
            if (containZero[m] == 0){
                count++;f

        int[] newArray= new int[containZero.length - count];
        int index = 0;
        for (int m = 0; m < containZero.length; m++){
            if (containZero[m] == 0){
                continue;
            } else {
                newArray[index] = containZero[m];
                index++;
            }
        }

        return newArray;
    }
}
