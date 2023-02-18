package xyz.scootaloo.thinking.draft.onlinetesting.quna;

import java.util.*;

/**
 * @author flutterdash@qq.com
 * @since 2022/10/12 - 17:06
 */
public class Main3 {

    // 花色 -> 面值
    private final Map<Character, Set<Integer>> colorMap = new HashMap<>();

    // 面值 -> 数量
    private final Map<Integer, Integer> countMap = new HashMap<>();

    private String ansName = "";

    public String showDown(String inHand) {
        String[] parts = inHand.split(" ");
        for (String part : parts) {
            char color = part.charAt(0);
            char number = part.charAt(1);
            int value = 0;
            if (number == 'J') {
                value = 11;
            } else if (number == 'Q') {
                value = 12;
            } else if (number == 'K') {
                value = 13;
            } else if (number == 'A') {
                value = 1;
            } else {
                if (part.length() == 3) {
                    value = 10;
                } else {
                    value = number - '0';
                }
            }

            if (colorMap.containsKey(color)) {
                colorMap.get(color).add(value);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(value);
                colorMap.put(color, set);
            }

            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                countMap.put(value, 1);
            }
        }

        if (selectHuangJiaTongHuaShun()) {
            return ansName;
        }

        if (selectTongHuaShun()) {
            return ansName;
        }

        if (selectSiTiao()) {
            return ansName;
        }

        if (selectHulu()) {
            return ansName;
        }

        if (selectTongHua()) {
            return ansName;
        }

        if (selectShunZi()) {
            return ansName;
        }

        if (selectSanTiao()) {
            return ansName;
        }

        if (selectLiangDui()) {
            return ansName;
        }

        if (selectYiDui()) {
            return ansName;
        }

        return "GaoPai";
    }

    private boolean selectHuangJiaTongHuaShun() {
        for (Map.Entry<Character, Set<Integer>> entry : colorMap.entrySet()) {
            Set<Integer> set = entry.getValue();
            if (set.contains(1) &&
                    set.contains(11) && set.contains(12) &&
                    set.contains(13) && set.contains(10)
            ) {
                String huangJiaTongHuaShun = "HuangJiaTongHuaShun";
                select(huangJiaTongHuaShun);
                return true;
            }
        }
        return false;
    }

    private boolean selectTongHuaShun() {
        for (Map.Entry<Character, Set<Integer>> entry : colorMap.entrySet()) {
            Set<Integer> set = entry.getValue();
            for (int i = 1; i<=(13 - 5); i++) {
                if (set.contains(i) &&
                        set.contains(i + 1) && set.contains(i + 2) &&
                        set.contains(i + 3) && set.contains(i + 4)
                ) {
                    String huangJiaTongHuaShun = "TongHuaShun";
                    select(huangJiaTongHuaShun);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean selectSiTiao() {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            if (count == 4) {
                select("SiTiao");
                return true;
            }
        }
        return false;
    }

    private boolean selectHulu() {
        for (Map.Entry<Integer, Integer> entry1 : countMap.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : countMap.entrySet()) {
                if (!Objects.equals(entry1.getKey(), entry2.getKey()) &&
                        entry1.getValue() >= 3 && entry2.getValue() >= 2) {
                    select("HuLu");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean selectTongHua() {
        for (Map.Entry<Character, Set<Integer>> entry : colorMap.entrySet()) {
            if (entry.getValue().size() >= 5) {
                select("TongHua");
                return true;
            }
        }
        return false;
    }

    private boolean selectShunZi() {
        for (int i = 0; i<=(13-5); i++) {
            if (
                    countMap.containsKey(i) &&
                    countMap.containsKey(i + 1) &&
                    countMap.containsKey(i + 2) &&
                    countMap.containsKey(i + 3) &&
                    countMap.containsKey(i + 4)
            ) {
                select("ShunZi");
                return true;
            }
        }
        return false;
    }

    private boolean selectSanTiao() {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 3) {
                select("SanTiao");
                return true;
            }
        }
        return false;
    }

    private boolean selectLiangDui() {
        for (Map.Entry<Integer, Integer> entry1 : countMap.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : countMap.entrySet()) {
                if (!Objects.equals(entry1.getKey(), entry2.getKey()) &&
                        entry1.getValue() >= 2 && entry2.getValue() >= 2) {
                    select("LiangDui");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean selectYiDui() {
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 2) {
                select("YiDui");
                return true;
            }
        }
        return false;
    }

    private void select(String name) {
        ansName = name;
    }

    public static void main(String[] args) {
        Main3 main = new Main3();
        System.out.println(main.showDown("SA SK SQ SJ S10 H10 C9"));
    }

}
