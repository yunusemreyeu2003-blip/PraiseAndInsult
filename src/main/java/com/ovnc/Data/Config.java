package com.ovnc.Data;

import com.ovnc.Sound.Sound;

import java.util.*;

public class Config {
    private Config() {}

    public static final Boolean DEBUG_MODE = false;
    public static final int WARMUP_COUNT = 3;
    public static final int CONTROL_TEST_COUNT = 10;
    public static final int EXPERIMENT_TEST_COUNT = 10;
    public static final Map<String, Sound> soundMap = new HashMap<>(Map.ofEntries(
            Map.entry("övgü1", new Sound("övgü1.mp3", 2.5)),
            Map.entry("övgü2", new Sound("övgü2.mp3", 2.5)),
            Map.entry("övgü3", new Sound("övgü3.mp3", 2.5)),
            Map.entry("övgü4", new Sound("övgü4.mp3", 2.5)),
            Map.entry("övgü5", new Sound("övgü5.mp3", 2.5)),
            Map.entry("övgü6", new Sound("övgü6.mp3", 2.5)),
            Map.entry("övgü7", new Sound("övgü7.mp3", 2.5)),
            Map.entry("övgü8", new Sound("övgü8.mp3", 2.5)),
            Map.entry("övgü9", new Sound("övgü9.mp3", 2.5)),
            Map.entry("övgü10", new Sound("övgü10.mp3", 2.5)),
            Map.entry("hakaret1", new Sound("hakaret1.mp3", 2.5)),
            Map.entry("hakaret2", new Sound("hakaret2.mp3", 2.5)),
            Map.entry("hakaret3", new Sound("hakaret3.mp3", 2.5)),
            Map.entry("hakaret4", new Sound("hakaret4.mp3", 2.5)),
            Map.entry("hakaret5", new Sound("hakaret5.mp3", 2.5)),
            Map.entry("hakaret6", new Sound("hakaret6.mp3", 2.5)),
            Map.entry("hakaret7", new Sound("hakaret7.mp3", 2.5)),
            Map.entry("hakaret8", new Sound("hakaret8.mp3", 2.5)),
            Map.entry("hakaret9", new Sound("hakaret9.mp3", 2.5)),
            Map.entry("hakaret10", new Sound("hakaret10.mp3", 2.5))

    ));
    public static final List<Praise_Insult> PRAISES = new ArrayList<>(Arrays.asList(
            new Praise_Insult("övgü", soundMap.get("övgü1"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü2"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü3"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü4"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü5"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü6"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü7"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü8"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü9"), Praise_InsultType.PRAISE),
            new Praise_Insult("övgü", soundMap.get("övgü10"), Praise_InsultType.PRAISE)
    ));
    public static final List<Praise_Insult> INSULTS = new ArrayList<>(Arrays.asList(
            new Praise_Insult("hakaret", soundMap.get("hakaret1"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret2"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret3"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret4"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret5"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret6"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret7"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret8"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret9"), Praise_InsultType.INSULT),
            new Praise_Insult("hakaret", soundMap.get("hakaret10"), Praise_InsultType.INSULT)
    ));
}

