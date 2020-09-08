package xyz.zhuht.algorithm.medium;

import java.util.*;

/**
 * @author haitao zhu
 * @date 2020/8/26 下午5:45
 * 17. 电话号码的字母组合
 */
public class DianHuaHaoMaDeZiMuZuHe {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> letter = new HashMap<>();
        letter.put('2', Arrays.asList("a", "b", "c"));
        letter.put('3', Arrays.asList("d", "e", "f"));
        letter.put('4', Arrays.asList("g", "h", "i"));
        letter.put('5', Arrays.asList("j", "k", "l"));
        letter.put('6', Arrays.asList("m", "n", "o"));
        letter.put('7', Arrays.asList("p", "q", "r", "s"));
        letter.put('8', Arrays.asList("t", "u", "v"));
        letter.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for (Character c : digits.toCharArray()) {
            if (ans.isEmpty()) {
                ans.addAll(letter.get(c));
            } else {
                for (String a : ans) {
                    for (String l : letter.get(c)) {
                        temp.add(a + l);
                    }
                }
                ans.clear();
                ans.addAll(temp);
                temp.clear();
            }
        }
        return ans;
    }
}
