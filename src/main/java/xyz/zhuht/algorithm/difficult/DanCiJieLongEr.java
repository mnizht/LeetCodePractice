package xyz.zhuht.algorithm.difficult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author haitao zhu
 * @date 2020/6/7 11:15
 * 126.单词接龙2
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DanCiJieLongEr {

  private static final int INF = 1 << 20;
  private Map<String, Integer> wordId; // 单词到id的映射
  private ArrayList<String> idWord; // id到单词的映射
  private ArrayList<Integer>[] edges; // 图的边

  public DanCiJieLongEr() {
    wordId = new HashMap<>();
    idWord = new ArrayList<>();
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    int id = 0;
    // 将wordList所有单词加入wordId中 相同的只保留一个 // 并为每一个单词分配一个id
    for (String word : wordList) {
      if (!wordId.containsKey(word)) {
        wordId.put(word, id++);
        idWord.add(word);
      }
    }
    // 若endWord不在wordList中 则无解
    if (!wordId.containsKey(endWord)) {
      return new ArrayList<>();
    }
    // 把beginWord也加入wordId中
    if (!wordId.containsKey(beginWord)) {
      wordId.put(beginWord, id++);
      idWord.add(beginWord);
    }

    // 初始化存边用的数组
    edges = new ArrayList[idWord.size()];
    for (int i = 0; i < idWord.size(); i++) {
      edges[i] = new ArrayList<>();
    }
    // 添加边
    for (int i = 0; i < idWord.size(); i++) {
      for (int j = i + 1; j < idWord.size(); j++) {
        // 若两者可以通过转换得到 则在它们间建一条无向边
        if (transformCheck(idWord.get(i), idWord.get(j))) {
          edges[i].add(j);
          edges[j].add(i);
        }
      }
    }

    int dest = wordId.get(endWord); // 目的ID
    List<List<String>> res = new ArrayList<>(); // 存答案
    int[] cost = new int[id]; // 到每个点的代价
    for (int i = 0; i < id; i++) {
      cost[i] = INF; // 每个点的代价初始化为无穷大
    }

    // 将起点加入队列 并将其cost设为0
    Queue<ArrayList<Integer>> q = new LinkedList<>();
    ArrayList<Integer> tmpBegin = new ArrayList<>();
    tmpBegin.add(wordId.get(beginWord));
    q.add(tmpBegin);
    cost[wordId.get(beginWord)] = 0;

    // 开始广度优先搜索
    while (!q.isEmpty()) {
      ArrayList<Integer> now = q.poll();
      int last = now.get(now.size() - 1); // 最近访问的点
      if (last == dest) { // 若该点为终点则将其存入答案res中
        ArrayList<String> tmp = new ArrayList<>();
        for (int index : now) {
          tmp.add(idWord.get(index)); // 转换为对应的word
        }
        res.add(tmp);
      } else { // 该点不为终点 继续搜索
        for (int i = 0; i < edges[last].size(); i++) {
          int to = edges[last].get(i);
          // 此处<=目的在于把代价相同的不同路径全部保留下来
          if (cost[last] + 1 <= cost[to]) {
            cost[to] = cost[last] + 1;
            // 把to加入路径中
            ArrayList<Integer> tmp = new ArrayList<>(now);
            tmp.add(to);
            q.add(tmp); // 把这个路径加入队列
          }
        }
      }
    }
    return res;
  }

  // 两个字符串是否可以通过改变一个字母后相等
  boolean transformCheck(String str1, String str2) {
    int differences = 0;
    for (int i = 0; i < str1.length() && differences < 2; i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        ++differences;
      }
    }
    return differences == 1;
  }


}
