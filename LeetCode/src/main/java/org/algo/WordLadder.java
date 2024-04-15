package org.algo;


import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/11/24 19:57
 * https://github.com/youngyangyang04/leetcode-master/blob
 * /master/problems/0127.%E5%8D%95%E8%AF%8D%E6%8E%A5%E9%BE%99.md
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 *
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，
 * 找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 * 求最短路径： 想到bfs
 * 1）图中的线是如何连在一起的
 * 2）起点和终点的最短路径长度
 *
 * 首先题目中并没有给出点与点之间的连线，而是要我们自己去连，
 * 条件是字符只能差一个，所以判断点与点之间的关系，要自己判断是不是差一个字符，如果差一个字符，那就是有edge。
 **/
public class WordLadder {

    public static Map<String,String> edgeMap = new HashMap<>();

    public static  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll(); //取出队头单词
            int path = map.get(word); //获取到该单词的路径长度
            for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
                char[] chars = word.toCharArray(); //将单词转换为char array，方便替换
                for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
                    chars[i] = k; //替换第i个字符
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
                        edgeMap.put(endWord,word);
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        edgeMap.put(newWord,word);
                        queue.offer(newWord);//加入队尾
                    }
                }

            }
        }
        return 0;
    }

    public static Iterable<String> pathTo(String endWord,String beginWord){

        Stack<String>  path = new Stack<>();
        for(String x = endWord;x != beginWord;x = edgeMap.get(x)){
            path.push(x);
        }
        path.push(beginWord);
        return  path;
    }

    public static void main(String[] args) {

//        String beginWord = "hit";
//        String endWord ="cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
//        int count = ladderLength(beginWord,endWord,wordList);
//        System.out.println("==============>"+ count);

        String[] words = {"hot","dot","dog","lot","log","cog"};
        Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());
        List<String> wordlist = Arrays.stream(words).collect(Collectors.toList());
        System.out.println("set:"+wordSet);
        System.out.println("list:"+wordlist);
//        for(String x : pathTo(endWord,beginWord)){
//            if(x==beginWord){
//                System.out.print(x);
//            } else{
//                System.out.print("-"+x);
//            }
//        }
    }
}