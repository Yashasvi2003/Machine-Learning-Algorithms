import java.util.*;
public class PathMaze {
    static int count=0;
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        char b[];
        b=new char[10000000];
        for(int i=0;i<10000000;i++){
            b[i]='0';
        }
        Mazepath(0,0,x-1,y-1,b,0);
        Maze(0,0,x-1,y-1,b,0);
        System.out.print("\n"+count);
    }
    public static boolean Path(int r,int c,int eR,int eC){
        if(r<=eR && c<=eC)
            return true;
        return false;
    }
    public static boolean Mazepath(int sR,int sC,int eR,int eC,char b[],int j){
        if(sR>=eR && sC>=eC){
            count++;
            return false;
        }

        boolean istrue=Path(sR+1,sC,eR,eC);
        if(istrue){
            b[j]='V';
            boolean IsSuccess1=Mazepath(sR+1,sC,eR,eC,b,j+1);
            if(IsSuccess1){
                return true;
            }
        }
        boolean IsTrue2=Path(sR,sC+1,eR,eC);
        if(IsTrue2){
            b[j]='H';
            boolean IsSuccess2=Mazepath(sR,sC+1,eR,eC,b,j+1);
            if(IsSuccess2){
                return true;
            }
        }
        b[j]='0';
        return false;

    }
    public static boolean Maze(int sR,int sC,int eR,int eC,char b[],int j){
        if(sR>=eR && sC>=eC){
            for(int i=0;i<j;i++)
                System.out.print(b[i]);
            System.out.print(" ");
            return false;
        }

        boolean istrue=Path(sR+1,sC,eR,eC);
        if(istrue){
            b[j]='V';
            boolean IsSuccess1=Maze(sR+1,sC,eR,eC,b,j+1);
            if(IsSuccess1){
                return true;
            }
        }
        boolean IsTrue2=Path(sR,sC+1,eR,eC);
        if(IsTrue2){
            b[j]='H';
            boolean IsSuccess2=Maze(sR,sC+1,eR,eC,b,j+1);
            if(IsSuccess2){
                return true;
            }
        }
        b[j]='0';
        return false;

    }
}
