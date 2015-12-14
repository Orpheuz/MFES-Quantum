package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Tile {
    private Boolean special;
    private Coordinates coordinates;
    private Piece piece;
    private Boolean bigBoard;

    public Tile(final Number xT, final Number yT, final Boolean boardType) {
        cg_init_Tile_1(xT, yT, boardType);
    }

    public Tile(final Number xT, final Number yT, final Piece p,
        final Boolean boardType) {
        cg_init_Tile_2(xT, yT, p, boardType);
    }

    public Tile() {
    }

    public void cg_init_Tile_1(final Number xT, final Number yT,
        final Boolean boardType) {
        bigBoard = boardType;
        coordinates = new Coordinates(xT, yT);
        piece = null;

        if (bigBoard) {
            Boolean orResult_9 = false;

            Boolean andResult_22 = false;

            if (Utils.equals(xT, 1L)) {
                if (Utils.equals(yT, 1L)) {
                    andResult_22 = true;
                }
            }

            if (andResult_22) {
                orResult_9 = true;
            } else {
                Boolean orResult_10 = false;

                Boolean andResult_23 = false;

                if (Utils.equals(xT, Board.smallSizeX)) {
                    if (Utils.equals(yT, Board.smallSizeY)) {
                        andResult_23 = true;
                    }
                }

                if (andResult_23) {
                    orResult_10 = true;
                } else {
                    Boolean orResult_11 = false;

                    Boolean andResult_24 = false;

                    if (Utils.equals(xT, 1L)) {
                        if (Utils.equals(yT, Board.smallSizeY)) {
                            andResult_24 = true;
                        }
                    }

                    if (andResult_24) {
                        orResult_11 = true;
                    } else {
                        Boolean andResult_25 = false;

                        if (Utils.equals(xT, Board.smallSizeX)) {
                            if (Utils.equals(yT, 1L)) {
                                andResult_25 = true;
                            }
                        }

                        orResult_11 = andResult_25;
                    }

                    orResult_10 = orResult_11;
                }

                orResult_9 = orResult_10;
            }

            special = orResult_9;
        } else {
            Boolean orResult_12 = false;

            Boolean andResult_26 = false;

            if (Utils.equals(xT, 1L)) {
                if (Utils.equals(yT, 1L)) {
                    andResult_26 = true;
                }
            }

            if (andResult_26) {
                orResult_12 = true;
            } else {
                Boolean orResult_13 = false;

                Boolean andResult_27 = false;

                if (Utils.equals(xT, Board.bigSizeX)) {
                    if (Utils.equals(yT, Board.bigSizeY)) {
                        andResult_27 = true;
                    }
                }

                if (andResult_27) {
                    orResult_13 = true;
                } else {
                    Boolean orResult_14 = false;

                    Boolean andResult_28 = false;

                    if (Utils.equals(xT, 1L)) {
                        if (Utils.equals(yT, Board.bigSizeY)) {
                            andResult_28 = true;
                        }
                    }

                    if (andResult_28) {
                        orResult_14 = true;
                    } else {
                        Boolean andResult_29 = false;

                        if (Utils.equals(xT, Board.bigSizeX)) {
                            if (Utils.equals(yT, 1L)) {
                                andResult_29 = true;
                            }
                        }

                        orResult_14 = andResult_29;
                    }

                    orResult_13 = orResult_14;
                }

                orResult_12 = orResult_13;
            }

            special = orResult_12;
        }

        return;
    }

    public void cg_init_Tile_2(final Number xT, final Number yT, final Piece p,
        final Boolean boardType) {
        bigBoard = boardType;
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
        Utils.toString(piece) + ", bigBoard := " + Utils.toString(bigBoard) +
        "}";
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
