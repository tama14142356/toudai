package code;
import java.util.*;

class Area {
    static final int bright = 100;
    static Pixel P[][];
    static int n;

    static class Pixel {
        int brightness;
        int gray;

        public Pixel(int brightness) {
            this.brightness = brightness;
        }
    }

    public static int SearchBright(boolean P2[][], int size, int i, int brightini[]) {
        if (0 <= i && i < n) {
            for (int j = 0; j < n; ++j) {
                if (P[i][j].brightness > bright) {
                    P2[i][j] = true;
                    size++;
                    brightini[0] = i;
                    brightini[1] = j;
                }
            }
            return SearchBright(P2, size, i + 1, brightini);
        }
        return size;
    }

    static boolean visited[][];

    public static int area(final boolean P2[][], int si, int sj, final int size) {
        visited[si][sj] = true;
        if (size <= 0)
        return 0;
        if(!P2[si][sj])return 0;
        int area = 1;
        for(int i = si - 1; i <= si + 1; ++i){
            if(i < 0 || i >= n)continue;
            for(int j = sj - 1; j <= sj + 1; ++j){
                if(i == si && j == sj)continue;
                if(j < 0 || j >= n)continue;
                if(P2[i][j] && !visited[i][j]){
                    area += area(P2, i, j, size);
                }
            }
        }
        return area;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        P = new Pixel[n][n];
        boolean P2[][] = new boolean[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                P[i][j] = new Pixel(sc.nextInt());
        }
        sc.close();
        int brightini[] = new int[2];
        int size = SearchBright(P2, 0, 0, brightini);
        int area = area(P2, 0, 0, size);
        System.out.println(area);
    }
}