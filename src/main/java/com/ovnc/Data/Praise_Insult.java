package com.ovnc.Data;

import com.ovnc.Sound.*;

public class Praise_Insult {
    public String text;
    public Sound sound;
    public Praise_InsultType type;

    public Praise_Insult(String text, Sound sound, Praise_InsultType type) {
        this.text = text;
        this.sound = sound;
        this.type = type;
    }
}
