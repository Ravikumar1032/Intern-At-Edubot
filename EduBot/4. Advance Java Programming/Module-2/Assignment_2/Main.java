import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        // Create shared input and output queues
        BlockingQueue<String> inputQueue = new ArrayBlockingQueue<>(10);
        BlockingQueue<String> outputQueue = new ArrayBlockingQueue<>(10);

        // Create and start stage threads
        Thread timestampAdderThread = new Thread(new TimestampAdder(inputQueue, outputQueue));
        Thread upperCaseConverterThread = new Thread(new UpperCaseConverter(inputQueue, outputQueue));
        Thread vowelCounterThread = new Thread(new VowelCounter(inputQueue, outputQueue));

        timestampAdderThread.start();
        upperCaseConverterThread.start();
        vowelCounterThread.start();

        // Start the main application to simulate text input
        MainApplication mainApp = new MainApplication(inputQueue, outputQueue);
        mainApp.start();
    }
}

class MainApplication extends Thread {
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public MainApplication(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        try {
            // Simulate text input and display processed data
            for (int i = 0; i < 20; i++) {
                String text = "This is text " + i;
                inputQueue.put(text);
                System.out.println("Input: " + text);
                String processedText = outputQueue.take();
                System.out.println("Processed: " + processedText);
                System.out.println("-----------------");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TimestampAdder implements Runnable {
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public TimestampAdder(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String text = inputQueue.take();
                String processedText = text + " [" + System.currentTimeMillis() + "]";
                outputQueue.put(processedText);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class UpperCaseConverter implements Runnable {
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public UpperCaseConverter(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String text = inputQueue.take();
                String processedText = text.toUpperCase();
                outputQueue.put(processedText);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class VowelCounter implements Runnable {
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public VowelCounter(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String text = inputQueue.take();
                int count = countVowels(text);
                String processedText = text + " [Vowels: " + count + "]";
                outputQueue.put(processedText);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int countVowels(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
