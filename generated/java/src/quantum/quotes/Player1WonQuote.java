package quantum.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Player1WonQuote {
    private static int hc = 0;
    private static Player1WonQuote instance = null;

    public Player1WonQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static Player1WonQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new Player1WonQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof Player1WonQuote;
    }

    public String toString() {
        return "<Player1Won>";
    }
}
