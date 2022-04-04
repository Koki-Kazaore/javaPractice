import java.util.*;
import java.util.stream.IntStream;

public class Shuffle {
    public static void main(String[] args) {

        // Bランク3問目

        Scanner sc = new Scanner(System.in);

        int allCards = sc.nextInt(); // すべての枚数
        int setCards = sc.nextInt(); // 1セットあたりの枚数
        int times = sc.nextInt(); // shuffleする回数

        int[] startArray = IntStream.rangeClosed(1, allCards).toArray();
        // System.out.println(Arrays.toString(startArray));

        int surplus = allCards % setCards; // セットを組んだときに余りが出るかどうか
        int[] tempArray = new int[setCards]; // シャッフルする配列を格納するための配列
        int changeTimes = (allCards / setCards) / 2; // 前後の入れ替え回数

        if (surplus != 0){
            // System.out.println("余りありの条件分岐に突入しました。");
            int addZero = setCards - surplus; // 配列に加えるゼロの個数
            int[] zeroArray = new int[addZero];
            for (int l = 0; l < addZero; l++){
                zeroArray[l] = 0;
            }

            allCards += addZero;
            changeTimes = (allCards / setCards) / 2;

            for (int i = 0; i < times; i++){
                int[] updateArray = new int[allCards];
                System.arraycopy(startArray, 0, updateArray, 0, allCards - 2);
                System.arraycopy(zeroArray, 0, updateArray, allCards - 2, addZero);

                // System.out.println("---cardセットの入れ替え前の状態を表示---");
                // System.out.println("(" + i + "-before)updateArray = " + Arrays.toString(updateArray));

                // cardセットの入れ替え
                for (int j = 0; j < changeTimes; j++){
                    // tempArrayにstartArrayの前半セットを一時的にコピーする
                    System.arraycopy(updateArray, j * setCards, tempArray, 0, setCards);
                    // startArrayの後半セットを前半セットにコピーする               
                    System.arraycopy(updateArray, allCards - setCards * (j + 1), updateArray, j * setCards, setCards);
                    // tempArrayに一時的にコピーしていた配列をstartArrayの後半セットにコピーする
                    System.arraycopy(tempArray, 0, updateArray, allCards - setCards * (j + 1), setCards);

                    // System.out.println("updateArray:" + Arrays.toString(updateArray));
                    // System.out.println("tempArray:" + Arrays.toString(tempArray));
                }

                // 追加したゼロの削除
                startArray = removeZero(updateArray);
                // System.out.println("途中のAnser: " + Arrays.toString(startArray));
            }

        } else {
            // shuffle実行
            for (int i = 0; i < times; i++){
                // cardセットの入れ替え
                for (int j = 0; j < changeTimes; j++){
                    // tempArrayにstartArrayの前半セットを一時的にコピーする
                    System.arraycopy(startArray, j * setCards, tempArray, 0, setCards);
                    // startArrayの後半セットを前半セットにコピーする               
                    System.arraycopy(startArray, allCards - setCards * (j + 1), startArray, j * setCards, setCards);
                    // tempArrayに一時的にコピーしていた配列をstartArrayの後半セットにコピーする
                    System.arraycopy(tempArray, 0, startArray, allCards - setCards * (j + 1), setCards);

                    // System.out.println("startArray:" + Arrays.toString(startArray));
                    // System.out.println("tempArray:" + Arrays.toString(tempArray));
                }
            }

        }            
        
        // System.out.println(Arrays.toString(startArray));
        // 結果の出力
        for (int n = 0; n < startArray.length; n++){
            System.out.println(startArray[n]);
        }
    }
    


    // zeroの要素を削除するためのメソッド
    static int[] removeZero(int[] containZero) {
        
        int count = 0;
        for (int m = 0; m < containZero.length; m++){
            if (containZero[m] == 0){
                count++;
            }
        }

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