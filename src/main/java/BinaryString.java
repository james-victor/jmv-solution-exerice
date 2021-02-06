public class BinaryString {


    public static void main(String[] args) {
        int a = 1;
        int ab = a << 1;

        System.out.println(ab);
        System.out.println(Integer.toBinaryString(ab));

        int ac = ab >> 3;

        System.out.println(ac);
        System.out.println(Integer.toBinaryString(ac));

        long b = -1L;

        float c = -1f;
        System.out.println(
                Integer.toBinaryString(a)
        );
    }
}
