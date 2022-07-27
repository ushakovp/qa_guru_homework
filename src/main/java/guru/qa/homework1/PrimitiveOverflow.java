package guru.qa.homework1;

public class PrimitiveOverflow {

    public static void main(String[] args) {
        byte oByte = Byte.MAX_VALUE;
        short oShort = Short.MAX_VALUE;
        int oInt = Integer.MAX_VALUE;
        long oLong = Long.MAX_VALUE;
        float oFloat = Float.MAX_VALUE;
        double oDouble = Double.MAX_VALUE;
        char oChar = Character.MIN_VALUE;

        System.out.println(++oByte);
        System.out.println(++oShort);
        System.out.println(++oInt);
        System.out.println(++oLong);
        System.out.println(++oChar);

        //Гарантировано переполняем float и double
        System.out.println(oFloat + oFloat);
        System.out.println(oDouble + oDouble);
    }
}
