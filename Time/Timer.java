package Time;

import java.time.LocalTime;
import java.time.Duration;

public class Timer {
    private LocalTime startTime;
    private LocalTime endTime;
    public Duration duration;

    public Timer() {
        start();
    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        endTime = LocalTime.now();
        duration = Duration.between(startTime, endTime);
    }
}