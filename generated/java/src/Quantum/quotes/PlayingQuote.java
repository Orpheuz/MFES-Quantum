package Quantum.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class PlayingQuote {
    private static int hc = 0;
    private static PlayingQuote instance = null;

    public PlayingQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static PlayingQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new PlayingQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof PlayingQuote;
    }

    public String toString() {
        return "<Playing>";
    }
}
