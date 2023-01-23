package com.ankit.algorithms.recursion.hackerrank;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CrosswordPuzzle {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] crossword =/* new String[10];
        crossword = */{
                "+-++++++++",
                "+-++++++++",
                "+-++++++++",
                "+-----++++",
                "+-+++-++++",
                "+-+++-++++",
                "+++++-++++",
                "++------++",
                "+++++-++++",
                "+++++-++++"
        };

//        for (int i = 0; i < 10; i++) {
//            String crosswordItem = scanner.nextLine();
//            crossword[i] = crosswordItem;
//        }

//        String words = scanner.nextLine();
        String[] words = {"LONDON",  "DELHI", "ICELAND", "ANKARA"};
        /*String[] result = */crosswordPuzzle(crossword, words);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(result[i]);
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

    private static void crosswordPuzzle(String[] crossword, String[] words) {
        char[][] ch =  new char[10][10];
        for(int i=0; i<crossword.length; i++){
            ch[i] = crossword[i].toCharArray();
        }
       Map<Integer, List<int[]>> map = prepareMap(ch);
       /* map.entrySet().forEach(e ->{
            System.out.print(e.getKey()+" = ");
            List<int[]> l = e.getValue();
            l.stream()
                    .map(a -> Arrays.stream(a).boxed().collect(Collectors.toList()))
                    .forEach(System.out::print);
            System.out.println();
        });*/

        List<int[]> l = map.values().stream().flatMap(x-> x.stream()).collect(Collectors.toList());
        int[][] c = new int[l.size()][4];
        for(int p =0; p<l.size(); p++){
                c[p] = l.get(p);
        }

        f(c,0, Arrays.stream(words).collect(Collectors.toList()), ch);

        printgrid(ch);

    }


    private static void f(int[][] cordinates,int c, List<String> words, char[][]ch){

        if(cordinates.length == c ){
            return;
        }
        int[] a = cordinates[c];
        for(int i=0; i<words.size(); i++){
            String word = words.get(i);
            char[][] ch1 = ch.clone();
            if( isFit(a, word,ch1) ){
                words.remove(word);
                f(cordinates, c+1, words, ch1);
            }
        }
    }

    private static void printgrid(char[][] ch) {
        for(int i=0; i<ch.length; i++){
            System.out.println(ch[i]);
        }
    }


    private static boolean isFit(int[] a, String word, char[][] ch) {
//        int[][]ch = c.clone();
        int length = (a[0] == a[2]) ? a[3]-a[1]+1 : a[2]-a[0]+1;

        if(word.length() != length) {
            return false;
        }

        boolean isHorizontal = (a[0] == a[2]);
        for(int i=0; i<word.length(); i++){
            int x = isHorizontal ? a[0] : a[0]+i;
            int y = isHorizontal ? a[1]+i : a[1];
            if(ch[x][y] == '-'){
                ch[x][y] = word.charAt(i);
            }else if(ch[x][y] != word.charAt(i)){
                return false;
            }
        }
        return true;

    }


    private static Map<Integer, List<int[]>> prepareMap(char[][] ch){
        Map<Integer, List<int[]>> map = new TreeMap<>();
        List<int[]> coordinates = getList(ch, true);
        coordinates.addAll(getList(ch, false));

        map = coordinates.stream().collect(Collectors.groupingBy(i -> (i[0]) ) ) ;
        return map;
    }

    private static List<int[]> getList(char[][] ch, boolean isHorizontal ) {
        List<int[]> coordinates = new ArrayList<>();
        for(int i=0; i<ch.length; i++){
            int start = -1;
            int end = -1;
            for(int j=0; j<ch[i].length; j++){
                char c;
                if(isHorizontal){
                    c = ch[i][j];
                }else{
                    c = ch[j][i];
                }

                if(c == '-' && start == -1){
                    start = j;
                }else if(c == '+' && start != -1&& end ==-1){
                    end = j-1;
                    if(end ==start){
                        start =-1;
                        end = -1;
                    }
                }
            }
            if(start != end){
                if(isHorizontal){
                    coordinates.add(new int[]{i, start, i, end});
                }else{
                    coordinates.add(new int[]{start, i, end, i});
                }
            }
        }
        return coordinates;
    }


}
