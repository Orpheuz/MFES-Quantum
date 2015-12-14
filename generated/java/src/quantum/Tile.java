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

        if (!(bigBoard)) {
            Boolean orResult_13 = false;

            Boolean andResult_33 = false;

            if (Utils.equals(xT, 1L)) {
                if (Utils.equals(yT, 1L)) {
                    andResult_33 = true;
                }
            }

            if (andResult_33) {
                orResult_13 = true;
            } else {
                Boolean orResult_14 = false;

                Boolean andResult_34 = false;

                if (Utils.equals(xT, Board.smallSizeX)) {
                    if (Utils.equals(yT, Board.smallSizeY)) {
                        andResult_34 = true;
                    }
                }

                if (andResult_34) {
                    orResult_14 = true;
                } else {
                    Boolean orResult_15 = false;

                    Boolean andResult_35 = false;

                    if (Utils.equals(xT, 1L)) {
                        if (Utils.equals(yT, Board.smallSizeY)) {
                            andResult_35 = true;
                        }
                    }

                    if (andResult_35) {
                        orResult_15 = true;
                    } else {
                        Boolean andResult_36 = false;

                        if (Utils.equals(xT, Board.smallSizeX)) {
                            if (Utils.equals(yT, 1L)) {
                                andResult_36 = true;
                            }
                        }

                        orResult_15 = andResult_36;
                    }

                    orResult_14 = orResult_15;
                }

                orResult_13 = orResult_14;
            }

            special = orResult_13;
        } else {
            Boolean orResult_16 = false;

            Boolean andResult_37 = false;

            if (Utils.equals(xT, 1L)) {
                if (Utils.equals(yT, 1L)) {
                    andResult_37 = true;
                }
            }

            if (andResult_37) {
                orResult_16 = true;
            } else {
                Boolean orResult_17 = false;

                Boolean andResult_38 = false;

                if (Utils.equals(xT, Board.bigSizeX)) {
                    if (Utils.equals(yT, Board.bigSizeY)) {
                        andResult_38 = true;
                    }
                }

                if (andResult_38) {
                    orResult_17 = true;
                } else {
                    Boolean orResult_18 = false;

                    Boolean andResult_39 = false;

                    if (Utils.equals(xT, 1L)) {
                        if (Utils.equals(yT, Board.bigSizeY)) {
                            andResult_39 = true;
                        }
                    }

                    if (andResult_39) {
                        orResult_18 = true;
                    } else {
                        Boolean andResult_40 = false;

                        if (Utils.equals(xT, Board.bigSizeX)) {
                            if (Utils.equals(yT, 1L)) {
                                andResult_40 = true;
                            }
                        }

                        orResult_18 = andResult_40;
                    }

                    orResult_17 = orResult_18;
                }

                orResult_16 = orResult_17;
            }

            special = orResult_16;
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
