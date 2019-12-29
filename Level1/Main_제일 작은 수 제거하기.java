import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
//      sc = new Scanner(src);
      int N = sc.nextInt();
      int M = sc.nextInt();
      sc.nextLine();

      int map[][] = new int[N][M];
      for (int i = 0; i < N; i++) {
         String line = sc.nextLine();
         for (int j = 0; j < M; j++) {
            map[i][j] = line.charAt(j) - '0';
         }
      }
//      for (int[] a : map)
//         System.out.println(Arrays.toString(a));

      int std = 0;
      if (N > M) {
         std = M - 1;
      } else {
         std = N - 1;
      }

      // 1. 가장 시작점을 기준으로 잡는다.
      // 2. 기준점부터 std에 저장된 값만큼 움직여가며 찾는다. (범위가 넘어가지 않게 조심하자)

      out: for (int i = 0; i < N; i++) {
         if (i != 0) {
            std-=1;
         }
         for (int j = 0; j < M; j++) {
            int temp = map[i][j];

            if (i + std >= N) {
               break out;
            }
            if (j + std >= M) {
               break;
            }

            int a = map[i][j + std];
            int b = map[i + std][j];
            int c = map[i + std][j + std];
//            System.out.println(temp+" "+a+" "+b+" "+c);
            if (temp == a && temp == b && temp == c) {
               System.out.println((std+1)*(std+1));
               break out;
            }

         }
      }

   }

   private static String src = "3 5\r\n" + "42101\r\n" + "22100\r\n" + "22101";

}