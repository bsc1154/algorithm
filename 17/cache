package test;

import java.util.LinkedList;
//도시 검색 --> 해당 도시와 관련된 맛집 게시물들을 데이터베이스에서 읽어 보여주는 서비스 개발
//게시물을 가져오는 부분 실행시간 너무 오래걸림 db 캐시를 적용하여 성능 개선 시도
//캐시 크기에 따른 실행시간 측정
//cache hit 시간 1, cache miss 5
public class cache {
    public static void main(String args[]){
        int cacheSize = 3;
        String cities [] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        solution(cacheSize,cities);
    }
        static final int CACHE_HIT = 1;
        static final int CACHE_MISS = 5;

        public static int solution(int cacheSize, String[] cities) {
            if(cacheSize == 0) return 5 * cities.length;//캐시 사이즈가 0이면 (캐시가 가득찬것) --> 도시갯수 * 캐시미스 시간 리턴

            int answer = 0;

            LinkedList<String> cache = new LinkedList<>();

            for(int i = 0 ; i < cities.length ; ++i){
                String city = cities[i].toUpperCase();

                // cache hit
                if(cache.remove(city)){//캐시에서 해당 도시를 지웠다면 캐시 맨 앞부분에 추가하고 시간은 +1
                    cache.addFirst(city);
                    answer += CACHE_HIT;

                    // cache miss
                } else {
                    int currentSize = cache.size();

                    if(currentSize == cacheSize){//캐시 max 사이즈와 캐시에 담긴 사이즈가 같다면 마지막것을 지운다.
                        cache.pollLast();
                    }

                    cache.addFirst(city);  //다시 맨앞에 삽입
                    answer += CACHE_MISS;
                }
            }
            return answer;
        }
}
