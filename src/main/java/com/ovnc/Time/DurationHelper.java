package com.ovnc.Time;

public final class DurationHelper {

    private DurationHelper() {}

    public static java.time.Duration DoubleSecondsToJava(double seconds) {
        long nanos = (long) (seconds * 1_000_000_000);
        return java.time.Duration.ofNanos(nanos);
    }

    public static javafx.util.Duration DoubleSecondsToJavaFX(double seconds) {
        double millis = seconds * 1000.0;
        return javafx.util.Duration.millis(millis);
    }

    public static double JavaToDoubleSeconds(java.time.Duration duration) {
        return duration.toNanos() / 1_000_000_000.0;
    }

    public static double JavaFXToDoubleSeconds(javafx.util.Duration fxDuration) {
        return fxDuration.toMillis() / 1000.0;
    }

    public static javafx.util.Duration JavaToJavaFX(java.time.Duration duration) {
        double millis = duration.toNanos() / 1_000_000.0;
        return javafx.util.Duration.millis(millis);
    }

    public static java.time.Duration JavaFXToJava(javafx.util.Duration fxDuration) {
        long nanos = (long) (fxDuration.toMillis() * 1_000_000);
        return java.time.Duration.ofNanos(nanos);
    }
}
