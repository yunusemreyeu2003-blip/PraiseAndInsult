package Time;

import java.time.LocalTime;
import java.time.Duration;

public class Timer {
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration duration;

    public Timer() {
        start();
    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void end() {
        endTime = LocalTime.now();
        duration = Duration.between(startTime, endTime);
    }

    public double duration() {
        return duration.toMillis();
    }
}