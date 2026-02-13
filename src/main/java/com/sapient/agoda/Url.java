package com.sapient.agoda;

public class Url {

    public static String urlify(String str, int length){
        char[] ch = new char[length];
        int j =0;
        boolean initialChar = false;
        for(int i=0; i < str.length()&& j<length; i++){
            while(str.charAt(i) == ' ' && !initialChar){
                i++;
            }
            if(str.charAt(i) == ' '){
                ch[j] = '%';
                ch[++j] = '2';
                ch[++j] = '0';
            }else{
                initialChar = true;
                ch[j] = str.charAt(i);
            }
            j++;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(urlify("        a b     ", 5));
    }
}
