package pipedstreams;

import java.io.*;

/**
 * Demonstrates inter-thread communication using PipedOutputStream and PipedInputStream
 * One thread writes data and another thread reads it through a pipe
 */
public class PipedStreamsCommunication {
    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create and start threads
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

            // Wait for threads to complete
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/**
 * Writer thread that sends data through PipedOutputStream
 */
class Writer implements Runnable {
    private PipedOutputStream pos;

    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try (PrintWriter pw = new PrintWriter(pos, true)) {
            String[] messages = {"Hello", "From", "Writer", "Thread"};
            
            for (String message : messages) {
                pw.println(message);
                System.out.println("Writer sent: " + message);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Writer interrupted: " + e.getMessage());
        }
    }
}

/**
 * Reader thread that receives data through PipedInputStream
 */
class Reader implements Runnable {
    private PipedInputStream pis;

    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
            String message;
            while ((message = br.readLine()) != null) {
                System.out.println("Reader received: " + message);
            }
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}
