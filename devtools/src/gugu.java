public class gugu {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            if (i % 4 == 0) continue;
            for (int j = 2; j <= 5; j++) {
                System.out.printf("%d * %d = %-4d", j, i, i*j);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i <= 9; i++) {
            if (i % 4 == 0) continue;
            for (int j = 6; j <= 9; j++) {
                System.out.printf("%d * %d = %-4d", j, i, i*j);
            }
            System.out.println();
        }
    }
}
