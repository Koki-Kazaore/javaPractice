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
    

    // Bランク1問目
    Scanner sc = new Scanner(System.in);
    
    // 入力値の代入と配列の作成
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
    */

    /* テスト確認用
    for (int i = 0; i < gondolaMax.length ; i++) {
      System.out.print(gondolaMax[i]);
      }
    */

    // Bランク2問目
    Scanner sc = new Scanner(System.in);
    int times = sc.nextInt();
    int[] position = new int[3];
    for (int k = 0; k < 3; k++){
      position[k] = sc.nextInt();
    }

    // 後々計算しやすくするため、座標軸正方向を+1, 負方向を-1とするint型で格納
    int[] direction = new int[times];
    char[] color = new char[times];

    for (int i = 0; i < times; i++){
      char tempDirection = sc.next().charAt(0);
      if (tempDirection == 'R'){
        direction[i] = 1;
      } else {
        direction[i] = -1;
      }

      color[i] = sc.next().charAt(0);
    }

    // 7色それぞれの場合の含まれている色を設定
    // red:0, green:1, blue:2とする
    int[] R = {0};
    int[] G = {1};
    int[] B = {2};
    int[] Y = {0, 1};
    int[] M = {0, 2};
    int[] C = {1, 2};
    int[] W = {0, 1, 2};

    boolean finish = false;

    // これは動作確認用プログラムです
    /*
    System.out.println("direction[0]:" + direction[0]);
    System.out.println("direction[1]:" + direction[1]);
    System.out.println("direction[2]:" + direction[2]);
    System.out.println("color[0]:" + color[0]);
    System.out.println("color[1]:" + color[1]);
    System.out.println("color[2]:" + color[2]);
    */

    // 点灯する光の色と方向によってカブトムシの位置座標を書き換えていく
    for (int j = 0; j < times; j++){
      // これは動作確認用プログラムです
      /* 
      System.out.println("座標書き換えループ" + j + "回目");
      System.out.println("position[0]:" + position[0]);
      System.out.println("position[1]:" + position[1]);
      System.out.println("position[1]:" + position[2]);
      */

      if (color[j] == 'R'){
        // 入力された色に含まれるRGBの数だけ移動させる
        for (int value : R){
          position[value] += direction[j];
        }
      }
      else if (color[j] == 'G'){
        // 入力された色に含まれるRGBの数だけ移動させる
        for (int value : G){
          position[value] += direction[j];
        }
      }
      else if (color[j] == 'B'){
        // 入力された色に含まれるRGBの数だけ移動させる
        for (int value : B){
          position[value] += direction[j];
        }
      }
      else if (color[j] == 'Y'){
        // 入力された色に含まれるRGBの数だけ移動させる
        for (int value : Y){
          position[value] += direction[j];
        }
      }
      else if (color[j] == 'M'){
        // 入力された色に含まれるRGBの数だけ移動させる
        for (int value : M){
          position[value] += direction[j];
        }
      }
      else if (color[j] == 'C'){
        // 入力された色に含まれるRGBの数だけ移動させる
        for (int value : C){
          position[value] += direction[j];
        }
      }
      else {
        // 入力された色に含まれるRGBの数だけ移動させる
        for (int value : W){
          position[value] += direction[j];
        }
      }
      
      // 全てのカブトムシが同じ座標にいるかどうかの判定
      if (position[0] == position[1] && position[0] == position[2]){
        System.out.println(position[0]);
        finish = true;
        break;
      }

    }

    // 座標が等しくならなかった場合の処理
    if (!finish){
      System.out.println("no");
    }
  }
}