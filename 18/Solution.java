package test;

import java.util.*;

public class Solution {
    public static void main(String args[]){
        String [][] a = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(a));

    }
    static ArrayList<HashSet<Integer>> candidateKey;

    public static int solution(String[][] relation){
        candidateKey = new ArrayList<>();
        int colSize = relation[0].length;//1개원소의 원소개수 (열의 개수)

        for(int i = 1 ; i <= colSize ; ++i) {
            makeKeySet(-1, colSize - 1, 0, i, new HashSet<>(), relation);
            //-1, 열의개수, 0, 인덱스, keyset, 배열
        }

        return candidateKey.size();
    }

    public static void makeKeySet(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet, String[][] relation) {
        System.out.println("키셋"+keySet);
        if(idx == size) {

            for(int i : keySet) System.out.print(i + " ");//

            for(HashSet<Integer> key : candidateKey) {
                if(keySet.containsAll(key)) {
                    System.out.println("는 " + key + "를 포함합니다.");
                    return;
                }
            }

            if(isUnique(keySet, relation)) {
                System.out.println("는 후보키 입니다.");
                candidateKey.add(keySet);
            } else {
                System.out.println("는 후보키가 아닙니다.");
            }
            return;
        }

        for(int i = attr + 1 ; i <= maxAttr ; ++i) {
            HashSet<Integer> newKeySet = new HashSet<>(keySet);
            newKeySet.add(i);
            makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
        }
    }

    //
    private static boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
        HashMap<String, String> map = new HashMap<>();
        //length 6(2차원 배열에서는 열)
        for(int r = 0 ; r < relation.length ; ++r) {
            String key = "";

            for(int c : keySet) {
                key += relation[r][c];
            }

            if(map.containsKey(key)) return false;
            else map.put(key, key);
        }
        return true;
    }
}