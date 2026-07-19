package blockchain.block;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum Logger {

    /*
    Info-Green
    Warning-Yellow
    Error-Red
    Debug-Blue
    Message-White
     */
    INFO("\u001B[32m"),
    WARNING("\u001B[33m"),
    ERROR("\u001B[31m"),
    DEBUG("\u001B[36m"),
    MESSAGE("\u001B[37m");

    private final String color;
    private final DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    Logger(String color) {
        this.color = color;
    }

    public void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(myFormat);
        String threadName = Thread.currentThread().getName();
        System.out.println(color + "[" + name() + "] " + message + " Time:[" + time +"]/Thread Name:[" + threadName + "]");

    }
}