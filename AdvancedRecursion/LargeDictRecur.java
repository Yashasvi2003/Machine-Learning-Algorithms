import java.util.*;
class LargeDictRecur
{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String array=sc.nextLine();
        char[] c = array.toCharArray();
        Arrays.sort(c);
        String x="";
        for(int i=0;i<c.length;i++){
            x+=c[i];
        }
        DictionarySmaller("",x,array);
    }
    static int y = 0;
    public static void DictionarySmaller(String answer,String str,String tar){

        if(str.length()==0){
            if(answer.equals(tar)){
                y =1;
                return;
            }
            else{
                System.out.println(answer);
            }
        }

        for(int i=0;i<str.length();i++){
            String str1 = str.substring(0,i);
            String str2 = str.substring(i+1);
            char c = str.charAt(i);
            if(y==0){
                DictionarySmaller(answer+c,str1+str2,tar);
            }
        }
    }
}