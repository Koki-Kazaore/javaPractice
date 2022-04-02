import java.util.*;

public class Hello {
  public static void main(String[] args) {
    /*
    // Dランク1問目
    System.out.println("hello, world!");

    // Dランク2問目
    Scanner sc = new Scanner(System.in);
    System.out.print("N: ");
    int N = sc.nextInt();
    System.out.print("M: ");
    int M = sc.nextInt();
    System.out.print("N*M = ");
    System.out.println(N * M);

    // Cランク1問目
    String S = sc.nextLine();
    
    // Cランク2問目
    
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    

    for (int i = 0; i < N; i++){
      String present = "";
      int id = i + 1;
      
      if (id % X != 0 && id % Y != 0){
        present += "N";
      } else {
        if (id % X == 0){
          present += "A";
        }
        if (id % Y == 0){
          present += "B";
        }
      }

      System.out.println(present);
    }
    

    // Cランク3問目
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int D = sc.nextInt();
    int sum = 0;

    for (int i = 0; i < N - 1; i++){
      int input = sc.nextInt();
      sum += input;
    }

    int area = D * (D * N - sum);
    System.out.println(area);
    */

    // Bランク1問目
    Scanner sc = new Scanner(System.in);
    
    /*入力値の代入と配列の作成*/
    int gondola = sc.nextInt();
    int group = sc.nextInt();

    int[] gondolaMax = new int[gondola];
    int[] groupMember = new int[group];
    int[] gondolaSum = new int[gondola];

    for (int i = 0; i < gondola; i++){
      gondolaMax[i] = sc.nextInt();
      gondolaSum[i] = 0;
    }

    for (int j = 0; j < group; j++){
      groupMember[j] = sc.nextInt();
    }

    int gondolaID = 0;
    // グループの数だけループを回す
    for (int k = 0; k < group; k++){
      //System.out.println("(親)ゴンドラID:" + gondolaID);
      int rider = groupMember[k];
      // グループのメンバー数がゴンドラのMAX人数を超えた場合は次のゴンドラに移る
      while (rider > gondolaMax[gondolaID]){
        gondolaSum[gondolaID] += gondolaMax[gondolaID];
        rider -= gondolaMax[gondolaID];
        gondolaID = (gondolaID + 1) % gondola;
        // System.out.println("(子)ゴンドラID:" + gondolaID);
      }
      // グループのメンバーが全員乗り切る処理
      gondolaSum[gondolaID] += rider;
      gondolaID = (gondolaID + 1) % gondola;
    }
    // 最後に結果を出力
    for (int l = 0; l < gondola; l++){
      System.out.println(gondolaSum[l]);
    }

    /* テスト確認用
    for (int i = 0; i < gondolaMax.length ; i++) {
      System.out.print(gondolaMax[i]);
      }
    */
  }
}