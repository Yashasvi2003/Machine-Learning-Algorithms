import java.util.*;
class RecurDict{
    public static void main(String args[]){
        ArrayList<String> a = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String tar=sc.next();
        String []array=new String[tar.length()];
        array=tar.split("");
        Arrays.sort(array);
        String str="";
        for(int i=tar.length()-1;i>=0;i--){
            str+=array[i];
        }
        DictionaryLarger(str,"",tar,a);
        for(int i = a.size()-1 ; i>=0 ; i-- ){
            System.out.println(a.get(i));
        }


    }
    static int y=0;
    public static void DictionaryLarger(String str,String answer,String tar,ArrayList<String> a){
        if(str.length()==0){
            if(answer.equals(tar)){
                y =1;
                return;
            }
            else{
                a.add(answer);
            }
        }
        for(int i=0;i<str.length();i++){

            String m=str.substring(0,i);
            String n=str.substring(i+1);
            char c=str.charAt(i);
            if(y==0){
                DictionaryLarger(m+n,answer+c,tar,a);}}
    }
}
