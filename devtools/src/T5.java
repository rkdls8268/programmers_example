public class T5 {
    public static void main(String[] args) {
        int p = 3, q = 5;
        swap(p, q);
        System.out.println(p+", "+q);
    }

    static void swap (int p, int q) {
        int temp = 0;
        temp = p;
        p = q;
        q = temp;
    }
}
