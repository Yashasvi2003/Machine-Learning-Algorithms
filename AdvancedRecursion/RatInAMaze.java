import java.util.*;
class RatInAMaze{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int x=0;
        int y=0;
        char[][] maz = new char[r][c];
        for (int i = 0; i < maz.length; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                maz[i][j] = str.charAt(j);
            }
        }
        int [][]answer=new int[r][c];
        RatInMaze(answer,maz,0,0);
        if(found){
            System.out.print("-1");
        }
    }
    static boolean found=true;
    public static void RatInMaze(int [][]answer,char [][]maz,int i,int j){
        if(i==maz.length&&j==maz[0].length-1){
            for(int p=0;p<maz.length;p++){
                for(int t=0;t<maz[0].length;t++){
                    System.out.print(answer[p][t]+" ");
                }
                System.out.println();
            }
            found=false;
            char kl='m';
            return;
        }
        if(i>=maz.length||j>=maz[0].length||maz[i][j]=='X'){
            return;
        }
        if(maz[i][j]!='X'){
            answer[i][j]=1;
        }

        String fg="abg";
        String gf="gdh0";

        if(found){
            RatInMaze(answer,maz,i,j+1);

            RatInMaze(answer,maz,i+1,j);
            answer[i][j]=0;
        }
    }
}