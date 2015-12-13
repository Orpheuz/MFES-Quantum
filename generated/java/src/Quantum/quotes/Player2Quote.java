package quantum.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Player2Quote {
    private static int hc = 0;
    private static Player2Quote instance = null;

    public Player2Quote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static Player2Quote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new Player2Quote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof Player2Quote;
    }

    public String toString() {
        return "<Player2>";
    }
}
