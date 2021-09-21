package test;

import java.util.*;
import java.util.logging.Logger;

class candidateKey {
    private final static Logger log = Logger.getGlobal();
    static ArrayList<HashSet<Integer>> candidateKey;

    public static void main(String args[]){


        String [][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        solution(relation);

    }

    public static int solution(String[][] relation){
        candidateKey = new ArrayList<>();
        int colSize = relation[0].length;

        for(int i = 1 ; i <= colSize ; ++i) {
            //후보키 추가
            makeKeySet(-1, colSize - 1, 0, i, new HashSet<>(), relation);
        }

        return candidateKey.size();
    }


   private static void makeKeySet(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet, String[][] relation) {
        System.out.println("candidatekey!!"+candidateKey);
        if(idx == size) {

            /*for(int i : keySet) System.out.print(i + " ");*/

            for(HashSet<Integer> key : candidateKey) {
                System.out.println("keySet :"+keySet);
                System.out.println("key :"+key);
                if(keySet.containsAll(key)) {
                    System.out.println("는 " + key + "를 포함합니다.");
                    return;
                }
            }
            //최소성

            //유일성
            if(isUnique(keySet, relation)) {
                System.out.println("는 후보키 입니다.");
                candidateKey.add(keySet);
            } else {
                System.out.println("는 후보키가 아닙니다.");
            }
            return;
        }

        //후보키 추가
        for(int i = attr + 1 ; i <= maxAttr ; ++i) {
            HashSet<Integer> newKeySet = new HashSet<>(keySet);
            newKeySet.add(i);
            makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
        }
    }

    private static boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
        HashMap<String, String> map = new HashMap<>();

        for(int r = 0 ; r < relation.length ; ++r) {
            String key = "";

            for(int c : keySet) {
                key += relation[r][c];
            }

            if(map.containsKey(key)) return false;//유일한지 검사
            else map.put(key, key);//유일하지 않으면 맵에 넣는다.
        }
        return true;
    }
}
