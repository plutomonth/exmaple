package example.utils;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiedSample {
    private static Map<String, String> ERROR;

    static {
        Map<String, String> tmp = new HashMap<String, String>();
        tmp.put("0000", "success");
        ERROR = Collections.unmodifiableMap(tmp);
    }

    public static void buffer(int size) {
        System.out.println("The size is " + size + ".");
        int b = 333;
        try {
            Thread.sleep(60 * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        byte[] test = new byte[b];
        byte[] oom = new byte[size];
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        // Throw java.lang.UnsupportedOperationException
        //ERROR.put("00001", "Test");
        System.out.println("key is 0000, and value is " + ERROR.get("0000"));

        byte[] buf = {115, 101, 114, 118};
        //byte[] buf = {71, 69, 84, 32};
        buffer((buf[0] & 255) << 24 | ( buf[1] & 255) << 16 |  ( buf[2] & 255) << 8 |  buf[3] & 255);
        
        
        System.out.println("Buffer created!");
    }
}