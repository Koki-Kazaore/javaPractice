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
    */
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
  }
}