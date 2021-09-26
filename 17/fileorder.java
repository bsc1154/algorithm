package test;

import java.util.*;

class fileorder {
    public static void main(String args[]){
        String a [] = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String b [] = solution(a);
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        System.out.println(b[3]);
        System.out.println(b[4]);
        System.out.println(b[5]);
        //좌측값이 큰경우 1
        //같은 경우 0
        //우측값이 큰경우 -1
        //bb aa --> bb가 큰것..

    }
    static int i = 0;
    public static String[] solution(String[] files) {
        //아래 배열을 정렬
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                System.out.println((i++)+"===========================");
                System.out.println(s1);
                System.out.println(s2);
                String[] file1 = detach(s1);//비교대상 1
                String[] file2 = detach(s2);//비교대상 2

                int headValue = file1[0].compareTo(file2[0]);
                //head 비교
                if(headValue == 0) {//head가 같을 경우
                    int num1 = Integer.parseInt(file1[1]);//number 1
                    int num2 = Integer.parseInt(file2[1]);//number 2
                    System.out.println("num"+(num1 - num2));
                    return num1 - num2;//같을 경우는 number로 비교
                } else {
                    System.out.println("headvalue"+headValue);
                    return headValue;//같지 않을경우는 head만 비교 해도 된다.
                }
            }
            //헤드와 넘버 꼬리를 분리하는 메서드
            private String[] detach(String str) {
                String head = "";
                String number = "";
                String tail = "";

                int idx = 0;
                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);//해당 인덱스의 문자열을 추출
                    if(ch >= '0' && ch <= '9') break;//만약 숫자일경우 종료
                    head += ch;//숫자가 아닐경우만 누적
                }

                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    if(!(ch >= '0' && ch <= '9')) break;//숫자가 아닐경우 종료
                    number += ch;//숫자 일경우 누적
                }
                ///두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지
                for( ; idx < str.length() ; ++idx) {
                    char ch = str.charAt(idx);
                    tail += ch;
                }

                String[] file = {head.toLowerCase(), number, tail};
                //head는 대소문자 구별 없으므로 둘다 소문자로 통일, number는 ,
                return file;
            }
        });
        return files;
    }
}
