import java.util.*;
public class MazePath {
    static int cnt;
    static void Mathmaze(int array[][],int ab,int bc,int da,int cb,String a)
    {
        if(ab==da-1&&bc==cb-1)
        {
            System.out.print(a+" ");
            cnt++;
            return;
        }
        if(ab<0||bc<0||ab>=da||bc>=cb)
            return;
        Mathmaze(array,ab+1,bc,da,cb,a+"V");
        Mathmaze(array,ab,bc+1,da,cb,a+"H");
        Mathmaze(array,ab+1,bc+1,da,cb,a+"D");
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int array[][]=new int[p][q];
        Mathmaze(array,0,0,p,q,"");
        System.out.println("\n"+cnt);
    }
}
