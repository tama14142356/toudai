package code;
import java.util.*;

class Test{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random random = new Random();
        sc.close();
        System.out.println(n);
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print((random.nextInt(40) + 80) + " ");
            }
            System.out.println();
        }
    }
}