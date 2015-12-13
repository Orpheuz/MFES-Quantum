package Quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Tile {
    private Boolean special;
    private Coordinates coordinates;
    private Piece piece;

    public Tile(final Number xT, final Number yT) {
        cg_init_Tile_1(xT, yT);
    }

    public Tile(final Number xT, final Number yT, final Piece p) {
        cg_init_Tile_2(xT, yT, p);
    }

    public Tile() {
    }

    public void cg_init_Tile_1(final Number xT, final Number yT) {
        coordinates = new Coordinates(xT, yT);
        piece = null;

        Boolean orResult_9 = false;

        Boolean andResult_23 = false;

        if (Utils.equals(xT, 1L)) {
            if (Utils.equals(yT, 1L)) {
                andResult_23 = true;
            }
        }

        if (andResult_23) {
            orResult_9 = true;
        } else {
            Boolean orResult_10 = false;

            Boolean andResult_24 = false;

            if (Utils.equals(xT, Board.smallSizeX)) {
                if (Utils.equals(yT, Board.smallSizeY)) {
                    andResult_24 = true;
                }
            }

            if (andResult_24) {
                orResult_10 = true;
            } else {
                Boolean orResult_11 = false;

                Boolean andResult_25 = false;

                if (Utils.equals(xT, 1L)) {
                    if (Utils.equals(yT, Board.smallSizeY)) {
                        andResult_25 = true;
                    }
                }

                if (andResult_25) {
                    orResult_11 = true;
                } else {
                    Boolean andResult_26 = false;

                    if (Utils.equals(xT, Board.smallSizeX)) {
                        if (Utils.equals(yT, 1L)) {
                            andResult_26 = true;
                        }
                    }

                    orResult_11 = andResult_26;
                }

                orResult_10 = orResult_11;
            }

            orResult_9 = orResult_10;
        }

        special = orResult_9;

        return;
    }

    public void cg_init_Tile_2(final Number xT, final Number yT, final Piece p) {
        special = false;
        coordinates = new Coordinates(xT, yT);
        piece = p;

        return;
    }

    public Coordinates getCoordinates() {
        return Utils.copy(coordinates);
    }

    public Piece getPiece() {
        return piece;
    }

    public Boolean isSpecial() {
        return special;
    }

    public void setPiece(final Piece p) {
        piece = p;
    }

    public String toString() {
        return "Tile{" + "special := " + Utils.toString(special) +
        ", coordinates := " + Utils.toString(coordinates) + ", piece := " +
        Utils.toString(piece) + "}";
    }

    public static class Coordinates implements Record {
        public Number x;
        public Number y;

        public Coordinates(final Number _x, final Number _y) {
            x = _x;
            y = _y;
        }

        public boolean equals(final Object obj) {
            if (!(obj instanceof Coordinates)) {
                return false;
            }

            Coordinates other = ((Coordinates) obj);

            return (Utils.equals(x, other.x)) && (Utils.equals(y, other.y));
        }

        public int hashCode() {
            return Utils.hashCode(x, y);
        }

        public Coordinates copy() {
            return new Coordinates(x, y);
        }

        public String toString() {
            return "mk_Tile`Coordinates" + Utils.formatFields(x, y);
        }
    }
}
