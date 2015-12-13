package Quantum.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Player2WonQuote {
    private static int hc = 0;
    private static Player2WonQuote instance = null;

    public Player2WonQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static Player2WonQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new Player2WonQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof Player2WonQuote;
    }

    public String toString() {
        return "<Player2Won>";
    }
}
