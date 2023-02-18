package xyz.scootaloo.thinking.leet;

/**
 * @author AppleSack
 * @since 2023/02/15
 */
@SuppressWarnings("unused")
public class LCP01 {

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i<answer.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

}
