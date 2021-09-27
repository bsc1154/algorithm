package test;

public class notation {

    public static void main(String args[]){
        notation a = new notation();
        a.solution(3,1,2,3);
    }
    //https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-n%EC%A7%84%EC%88%98-%EA%B2%8C%EC%9E%84-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
    public String solution(int n, int t, int m, int p) { // n진법, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p

        StringBuilder answer = new StringBuilder("");
        StringBuilder binaryStr = new StringBuilder("0"); // 0부터 시작하기 때문에 0을 미리 넣어놓는다.

        String[] alpaForMoreThan10 = {"A", "B", "C", "D", "E", "F"}; // 16진수일 경우에 바꿔줄 알파벳들

        int num = 1;

        while (binaryStr.length() - 1 < t * m) { // 미리 구할 숫자의 갯수 * 인원의 길이까지 답이 나올만큼 반복한다.

            StringBuilder subBinarys = new StringBuilder("");
            int quot = num; // 몫
            int remain; // 나머지

            while (quot > 0) {
                remain = quot % n;
                quot = quot / n;

                if (remain >= 10 && remain <= 15) { // 알파벳으로 바꿔야 하는 경우
                    subBinarys.append(alpaForMoreThan10[remain-10]);
                } else {
                    subBinarys.append(remain);
                }
            }
            binaryStr.append(subBinarys.reverse());
            num++;
        }

        int tubePlace = p;

        for (int i = 0; i < t; i++) {
            answer.append(binaryStr.charAt(tubePlace - 1));
            tubePlace += m; // 튜브 차례
        }

        return answer.toString();
    }
}