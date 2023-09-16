import java.util.Scanner;
public class RatChasesCheese
{
    private static int N, M;
    private static char[][] g;
    private static int[][] p;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        g = new char[N][M];
        p = new int[N][M];
        for (int i = 0; i < N; i++)
        {
            String r = sc.next();
            for (int j = 0; j < M; j++)
            {
                g[i][j] = r.charAt(j);
                p[i][j] = 0;
            }
        }
        boolean pathExists = Cheese(0, 0);
        if (pathExists)
        {
            Path();
        } else
        {
            System.out.println("NO PATH FOUND");
        }
    }
    private static boolean Cheese(int i, int j)
    {
        if (i < 0 || j < 0 || i >= N || j >= M)
        {
            return false;
        }
        if (g[i][j] == 'X')
        {
            return false;
        }
        if (p[i][j] == 1)
        {
            return false;
        }
        p[i][j] = 1;
        if (i == N - 1 && j == M - 1)
        {
            return true;
        }

        if (Cheese(i - 1, j) || Cheese(i + 1, j) || Cheese(i, j - 1) || Cheese(i, j + 1))
        {
            return true;
        }
        p[i][j] = 0;
        return false;
    }
    private static void Path()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
    }
}