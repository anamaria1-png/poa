package com.example.poa.dto;

import java.util.HashMap;
import java.util.Map;

public enum TipProgramare {
    CONSULTATIE(0),
    INSTALARE_APARAT_DENTAR(1),
    OPERATIE(2);

    private static final Map<Integer, TipProgramare> BY_ID = new HashMap<>();

    static {
        for (TipProgramare e : values()) {
            BY_ID.put(e.id, e);
        }
    }

    public final Integer id;

    TipProgramare(Integer id) {
        this.id = id;
    }

    public static TipProgramare valueOfId(Integer id) {
        return BY_ID.get(id);
    }
}
