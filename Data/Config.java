package Data;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Config {
    public static final Boolean DEBUG_MODE = false;
    public static final int WARMUP_COUNT = 1;
    public static final int CONTROL_TEST_COUNT = 1;
    public static final int EXPERIMENT_TEST_COUNT = 10;
    public static final List<String> PRAISES = new ArrayList<>(Arrays.asList(
            "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10"
    ));
    public static final List<String> INSULTS = new ArrayList<>(Arrays.asList(
            "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10"
    ));
}

