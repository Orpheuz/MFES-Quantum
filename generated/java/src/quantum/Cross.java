package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Cross extends Piece {
    public Cross(final Object p) {
        cg_init_Cross_1(((Object) p));
    }

    public Cross() {
    }

    public void cg_init_Cross_1(final Object p) {
        cg_init_Piece_1(((Object) p));
    }

    public Boolean checkPiecesMiddle(final Tile ti, final Tile tf) {
        Number tempX = ti.getCoordinates().x;
        Number tempY = ti.getCoordinates().y;
        Boolean signalX = false;
        Boolean signalY = false;
        Number maxX = ti.getCoordinates().x;
        Number maxY = ti.getCoordinates().y;
        Number max = 1L;

        if (Utils.equals(Utils.abs(tf.getCoordinates().x.longValue() -
                        ti.getCoordinates().x.longValue()),
                    Utils.abs(tf.getCoordinates().y.longValue() -
                        ti.getCoordinates().y.longValue()))) {
            if (tf.getCoordinates().x.longValue() > ti.getCoordinates().x.longValue()) {
                signalX = true;
                maxX = tf.getCoordinates().x;
            }

            if (tf.getCoordinates().y.longValue() > ti.getCoordinates().y.longValue()) {
                signalY = true;
                maxY = tf.getCoordinates().y;
            }

            Boolean whileCond_2 = true;

            while (whileCond_2) {
                Boolean orResult_2 = false;

                if (tempX.longValue() < (maxX.longValue() - 1L)) {
                    orResult_2 = true;
                } else {
                    orResult_2 = tempY.longValue() < (maxY.longValue() - 1L);
                }

                whileCond_2 = orResult_2;

                if (!(whileCond_2)) {
                    break;
                }

                if (signalX) {
                    tempX = tempX.longValue() + 1L;
                } else {
                    tempX = tempX.longValue() - 1L;
                }

                if (signalY) {
                    tempY = tempY.longValue() + 1L;
                } else {
                    tempY = tempY.longValue() - 1L;
                }

                if (!(Utils.equals(Board.getInstance().getTile(tempX, tempY)
                                            .getPiece(), null))) {
                    return false;
                }
            }

            return true;
        }

        Boolean andResult_7 = false;

        if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
            if (!(Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y))) {
                andResult_7 = true;
            }
        }

        if (andResult_7) {
            tempX = ti.getCoordinates().x;

            if (ti.getCoordinates().y.longValue() > tf.getCoordinates().y.longValue()) {
                max = ti.getCoordinates().y;
                tempY = tf.getCoordinates().y;
            } else {
                tempY = ti.getCoordinates().y;
                max = tf.getCoordinates().y;
            }

            Boolean whileCond_3 = true;

            while (whileCond_3) {
                whileCond_3 = tempY.longValue() < (max.longValue() - 1L);

                if (!(whileCond_3)) {
                    break;
                }

                tempY = tempY.longValue() + 1L;

                if (!(Utils.equals(Board.getInstance().getTile(tempX, tempY)
                                            .getPiece(), null))) {
                    return false;
                }
            }

            return true;
        }

        Boolean andResult_8 = false;

        if (!(Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x))) {
            if (Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y)) {
                andResult_8 = true;
            }
        }

        if (andResult_8) {
            tempY = ti.getCoordinates().y;

            if (ti.getCoordinates().x.longValue() > tf.getCoordinates().x.longValue()) {
                max = ti.getCoordinates().x;
                tempX = tf.getCoordinates().x;
            } else {
                tempX = ti.getCoordinates().x;
                max = tf.getCoordinates().x;
            }

            Boolean whileCond_4 = true;

            while (whileCond_4) {
                whileCond_4 = tempX.longValue() < (max.longValue() - 1L);

                if (!(whileCond_4)) {
                    break;
                }

                tempX = tempX.longValue() + 1L;

                if (!(Utils.equals(Board.getInstance().getTile(tempX, tempY)
                                            .getPiece(), null))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf) {
        if (!(Utils.equals(tf.getPiece(), null))) {
            return false;
        }

        if (ti.isSpecial()) {
            Boolean andResult_9 = false;

            Boolean orResult_3 = false;

            Boolean andResult_10 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                if (!(Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y))) {
                    andResult_10 = true;
                }
            }

            if (andResult_10) {
                orResult_3 = true;
            } else {
                Boolean orResult_4 = false;

                Boolean andResult_11 = false;

                if (!(Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x))) {
                    if (Utils.equals(ti.getCoordinates().y,
                                tf.getCoordinates().y)) {
                        andResult_11 = true;
                    }
                }

                if (andResult_11) {
                    orResult_4 = true;
                } else {
                    orResult_4 = Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                tf.getCoordinates().x.longValue()),
                            Utils.abs(ti.getCoordinates().y.longValue() -
                                tf.getCoordinates().y.longValue()));
                }

                orResult_3 = orResult_4;
            }

            if (orResult_3) {
                if (checkPiecesMiddle(ti, tf)) {
                    andResult_9 = true;
                }
            }

            return andResult_9;
        } else {
            Boolean andResult_12 = false;

            if (Utils.abs(ti.getCoordinates().x.longValue() -
                        tf.getCoordinates().x.longValue()) <= 1L) {
                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= 1L) {
                    andResult_12 = true;
                }
            }

            return andResult_12;
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf, final Number n) {
        if (!(Utils.equals(tf.getPiece(), null))) {
            return false;
        }

        if (ti.isSpecial()) {
            Boolean andResult_13 = false;

            Boolean orResult_5 = false;

            Boolean andResult_14 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                if (!(Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y))) {
                    andResult_14 = true;
                }
            }

            if (andResult_14) {
                orResult_5 = true;
            } else {
                Boolean orResult_6 = false;

                Boolean andResult_15 = false;

                if (!(Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x))) {
                    if (Utils.equals(ti.getCoordinates().y,
                                tf.getCoordinates().y)) {
                        andResult_15 = true;
                    }
                }

                if (andResult_15) {
                    orResult_6 = true;
                } else {
                    orResult_6 = Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                tf.getCoordinates().x.longValue()),
                            Utils.abs(ti.getCoordinates().y.longValue() -
                                tf.getCoordinates().y.longValue()));
                }

                orResult_5 = orResult_6;
            }

            if (orResult_5) {
                if (checkPiecesMiddle(ti, tf)) {
                    andResult_13 = true;
                }
            }

            return andResult_13;
        } else {
            Boolean orResult_7 = false;

            Boolean andResult_16 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= n.longValue()) {
                    andResult_16 = true;
                }
            }

            if (andResult_16) {
                orResult_7 = true;
            } else {
                Boolean orResult_8 = false;

                Boolean andResult_17 = false;

                if (Utils.abs(ti.getCoordinates().x.longValue() -
                            tf.getCoordinates().x.longValue()) <= n.longValue()) {
                    if (Utils.equals(ti.getCoordinates().y,
                                tf.getCoordinates().y)) {
                        andResult_17 = true;
                    }
                }

                if (andResult_17) {
                    orResult_8 = true;
                } else {
                    Boolean andResult_18 = false;

                    Boolean andResult_19 = false;

                    if (Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                    tf.getCoordinates().x.longValue()),
                                Utils.abs(ti.getCoordinates().y.longValue() -
                                    tf.getCoordinates().y.longValue()))) {
                        Boolean andResult_20 = false;

                        if (Utils.abs(ti.getCoordinates().x.longValue() -
                                    tf.getCoordinates().x.longValue()) <= n.longValue()) {
                            if (Utils.abs(ti.getCoordinates().y.longValue() -
                                        tf.getCoordinates().y.longValue()) <= n.longValue()) {
                                andResult_20 = true;
                            }
                        }

                        if (andResult_20) {
                            andResult_19 = true;
                        }
                    }

                    if (andResult_19) {
                        if (checkPiecesMiddle(ti, tf)) {
                            andResult_18 = true;
                        }
                    }

                    orResult_8 = andResult_18;
                }

                orResult_7 = orResult_8;
            }

            return orResult_7;
        }
    }

    public Number getSize() {
        return 1L;
    }

    public Piece getTopPiece() {
        return this;
    }

    public String toString() {
        return "Cross{}";
    }
}
