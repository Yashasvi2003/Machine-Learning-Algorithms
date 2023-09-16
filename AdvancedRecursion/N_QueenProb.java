import java.util.*;
class N_QueenProb{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        boolean [][] arr = new boolean[size][size];
        int count=N_Queen(arr,0,size,"");
        System.out.println();
        System.out.print(count);
    }
    public static int N_Queen(boolean [][] arr,int x,int size,String a){
        if(size==0){
            System.out.print(a);
            return  1;
        }
        int count =0;
        for(int y=0;y<arr.length;y++){
            if(safe(arr,x,y)==true){
                arr[x][y]=true;
                count+=N_Queen(arr,x+1,size-1,a+"{"+(x+1)+"-"+(y+1)+"}"+" ");
                arr[x][y]=false;
            }
        }
        return count;
    }
    public static boolean safe(boolean [][] arr,int x,int y){
        int r=x;
        while(r>=0){
            if(arr[r][y]){
                return false;
            }
            r--;
        }
        r=x;
        int c=y;
        while(r>=0 && c>=0){
            if(arr[r][c]){
                return false;
            }
            r--;
            c--;
        }
        r=x;
        c=y;
        while(r>=0 && c<arr.length){
            if(arr[r][c]){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }

}