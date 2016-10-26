package csc171.workshop;

import java.io.*;
import java.util.Stack;

public class Main {

    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        //writeHelloWorld();
        //readHelloWorld();
        stack.push("aoeu");
        stack.push("snth");
        stack.push("aorscebx");
        stack.push("oeacrb");
        stack.empty();

        Math.IEEEremainder()
    }

    public static void writeHelloWorld() {

        String filename = "abc.txt";
        File file = new File(filename);
        OutputStream os = null;

        try {
            os = new FileOutputStream(file);
            os.write("Hello World!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSafely(os);
        }
    }

    public static void readHelloWorld() {

        String filename = "abc.txt";
        File file = new File(filename);
        InputStream is = null;

        try {
            is = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();

            int d = 64;
            while (d >= 64) {
                byte[] data = new byte[d];
                d = is.read(data, 0, 64);

                sb.append(new String(data));
            }

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSafely(is);
        }
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                // Squash
            }
        }
    }

    public static void spawnDaemon() {

    }
}
