import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Set<Integer> integers = Set.of(1, 2, 3, 4, 5);
        integers.
    }

//    class Solution {
//
//        boolean[] choosed;
//
//        public int[] solution(int[][] dice) {
//            int N = dice.length;
//            System.out.println("주사위 개수: " + N);
//
//            choosed = new boolean[N];
//            chooseDice(0, 0, N, dice);
//
//// 결과에 + 1씩 해서 리턴해야 함.
//            return null;
//        }
//
//        private void chooseDice(int L, int S, int N, int[][] dice) {
//            if (L == N / 2) {
//                calWinningPercent(dice, N);
//            } else {
//                for (int i = S; i < N; i++) {
//                    choosed[i] = true;
//                    chooseDice(L + 1, i + 1, N, dice);
//                    choosed[i] = false;
//                }
//            }
//        }
//
//        private void calWinningPercent(int[][] dice, int N) {
//            int[] ADice = new int[N / 2];
//            int[] BDice = new int[N / 2];
//            int aIndex = 0;
//            int bIndex = 0;
//            for (int i = 0; i < N; i++) {
//                if (choosed[i]) ADice[aIndex++] = i;
//                else BDice[bIndex++] = i;
//            }
//
//
//
//            // System.out.println("A가 선택한 주사위");
//            // for (int i = 0; i < N / 2; i++) {
//            //     System.out.print(ADice[i] + 1 + " ");
//            // }
//            // System.out.println();
//        }
//    }
//
//    class Solution {
//        public int[] solution(int[][] dice) {
//            int len = dice.length;
//            int[][] mem = new int[len][len];
//            for (int i = 0; i < len; i++) {
//                int count = 0;
//                for (int j = i + 1; j < len; j++) {
//                    for (int k = 0; k < 6; k++) {
//                        for (int l = 0; l < 6; l++) {
//                            if (dice[i][k] < dice[j][l]) count--;
//                            else if(dice[i][k] > dice[j][l]) count++;
//                        }
//                    }
//                    mem[i][j] = count;
//                }
//            }
//
//            for (int i = 0; i < len; i++) {
//                for (int j = 0; j < len; j++) {
//                    System.out.print(mem[i][j] + " ");
//                }
//                System.out.println();
//            }
//
//            List<int[]> result = new ArrayList<>(); // [ index, row 합]
//            for (int i = 0; i < len; i++) {
//                int count = 0;
//                for (int j = 0; j < len; j++) {
//                    count += mem[i][j];
//                }
//                result.add(new int[]{i, count});
//            }
//
//            // Collections.sort(result, (a, b) -> b[1] - a[1]);
//            // for (int[] r : result) {
//            //     System.out.println(r[0] + " : " + r[1]);
//            // }
//
//            int[] answer = new int[len / 2];
//            for (int i = 0 ; i < len / 2; i++) {
//                answer[i] = result.get(i)[0] + 1;
//            }
//
//            Arrays.sort(answer);
//
//            return answer;
//        }
//    }
}