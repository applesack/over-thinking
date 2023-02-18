package xyz.scootaloo.thinking.draft.onlinetesting.meituan;

import java.util.*;

/**
 * 小美最近在玩一款回合制游戏，该游戏中的一个人机关卡共有n个回合，小美所使用的角色并没有主动攻击技能，有且只有一个防御技能——圣光!圣光总共可以使用k次，每回合最多使用一次，如果在某一个回合使用了圣光，那么小美的角色会免疫该回合受到的所有伤害，并且在之后没有释放圣光的回合中每回合恢复1点HP，效果可以叠加，例如在前两个回合都释放了一次圣光，那么第三个回合就会恢复2点HP。
 * <p>
 * 小美只需要在n个回合后HP大于等于0，即可通关，请问小美角色初始最少需要多少HP。（初始HP应该大于等于1，游戏过程中允许部分时刻HP小于0）
 *
 * @author flutterdash@qq.com
 * @since 2022/10/08 - 10:28
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] checkpoint = new int[n];
        for (int i = 0; i<n; i++) {
            checkpoint[i] = scanner.nextInt();
        }
        //  7  3  2  6  4
        //    -3 -2    -4
        //    +1 +1 +1 +2
        //    -2 -3 -2 -4
        int up = 0;
        int hp = 0;
        Set<Integer> set = getMaxK(checkpoint, k);
        for (int i = 0; i<checkpoint.length; i++) {
            if (set.contains(i)) {
                hp += up;
                up++;
            } else {
                hp += up;
                hp -= checkpoint[i];
            }
        }

        if (hp < 0) {
            System.out.println(Math.abs(hp) + 1);
        } else {
            System.out.println(1);
        }
    }

    private static Set<Integer> getMaxK(int[] nums, int k) {
        Integer[] indies = new Integer[nums.length];
        for (int i = 0; i<nums.length; i++) {
            indies[i] = i;
        }
        Arrays.sort(indies, Comparator.comparingInt(i -> nums[i]));
        int start = nums.length - k;
        return new HashSet<>(Arrays.asList(indies).subList(start, nums.length));
    }

}
