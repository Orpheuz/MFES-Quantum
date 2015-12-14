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
        Number tempX = 1L;
        Number tempY = 1L;
        Number maxX = 1L;
        Number tempXc = ti.getCoordinates().x;
        Number tempYc = ti.getCoordinates().y;
        Boolean signalX = false;
        Boolean signalY = false;
        Boolean andResult_7 = false;

        if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
            if (!(Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y))) {
                andResult_7 = true;
            }
        }

        if (andResult_7) {
            tempX = ti.getCoordinates().x;

            if (ti.getCoordinates().y.longValue() > tf.getCoordinates().y.longValue()) {
                maxX = ti.getCoordinates().y;
                tempY = tf.getCoordinates().y;
            } else {
                tempY = ti.getCoordinates().y;
                maxX = tf.getCoordinates().y;
            }

            Boolean whileCond_2 = true;

            while (whileCond_2) {
                whileCond_2 = tempY.longValue() < (maxX.longValue() - 1L);

                if (!(whileCond_2)) {
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
                maxX = ti.getCoordinates().x;
                tempX = tf.getCoordinates().x;
            } else {
                tempX = ti.getCoordinates().x;
                maxX = tf.getCoordinates().x;
            }

            Boolean whileCond_3 = true;

            while (whileCond_3) {
                whileCond_3 = tempX.longValue() < (maxX.longValue() - 1L);

                if (!(whileCond_3)) {
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

        if (Utils.equals(Utils.abs(tf.getCoordinates().x.longValue() -
                        ti.getCoordinates().x.longValue()),
                    Utils.abs(tf.getCoordinates().y.longValue() -
                        ti.getCoordinates().y.longValue()))) {
            if (tf.getCoordinates().x.longValue() > ti.getCoordinates().x.longValue()) {
                signalX = true;
            }

            if (tf.getCoordinates().y.longValue() > ti.getCoordinates().y.longValue()) {
                signalY = true;
            }

            Boolean whileCond_4 = true;

            while (whileCond_4) {
                Boolean andResult_9 = false;

                if (!(Utils.equals(tempXc, tf.getCoordinates().x))) {
                    if (!(Utils.equals(tempYc, tf.getCoordinates().y))) {
                        andResult_9 = true;
                    }
                }

                whileCond_4 = andResult_9;

                if (!(whileCond_4)) {
                    break;
                }

                if (signalX) {
                    tempXc = tempXc.longValue() + 1L;
                } else {
                    tempXc = tempXc.longValue() - 1L;
                }

                if (signalY) {
                    tempYc = tempYc.longValue() + 1L;
                } else {
                    tempYc = tempYc.longValue() - 1L;
                }

                if (!(Utils.equals(Board.getInstance().getTile(tempXc, tempYc)
                                            .getPiece(), null))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf) {
        if (!(Utils.equals(tf.getPiece(), null))) {
            return false;
        }

        if (ti.isSpecial()) {
            Boolean orResult_2 = false;

            Boolean andResult_10 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                if (!(Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y))) {
                    andResult_10 = true;
                }
            }

            if (andResult_10) {
                orResult_2 = true;
            } else {
                Boolean orResult_3 = false;

                Boolean andResult_11 = false;

                if (!(Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x))) {
                    if (Utils.equals(ti.getCoordinates().y,
                                tf.getCoordinates().y)) {
                        andResult_11 = true;
                    }
                }

                if (andResult_11) {
                    orResult_3 = true;
                } else {
                    Boolean andResult_12 = false;

                    if (Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                    tf.getCoordinates().x.longValue()),
                                Utils.abs(ti.getCoordinates().y.longValue() -
                                    tf.getCoordinates().y.longValue()))) {
                        if (checkPiecesMiddle(ti, tf)) {
                            andResult_12 = true;
                        }
                    }

                    orResult_3 = andResult_12;
                }

                orResult_2 = orResult_3;
            }

            return orResult_2;
        } else {
            Boolean andResult_13 = false;

            if (Utils.abs(ti.getCoordinates().x.longValue() -
                        tf.getCoordinates().x.longValue()) <= 1L) {
                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= 1L) {
                    andResult_13 = true;
                }
            }

            return andResult_13;
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf, final Number n) {
        if (!(Utils.equals(tf.getPiece(), null))) {
            return false;
        }

        if (ti.isSpecial()) {
            Boolean orResult_4 = false;

            Boolean andResult_14 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                if (!(Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y))) {
                    andResult_14 = true;
                }
            }

            if (andResult_14) {
                orResult_4 = true;
            } else {
                Boolean orResult_5 = false;

                Boolean andResult_15 = false;

                if (!(Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x))) {
                    if (Utils.equals(ti.getCoordinates().y,
                                tf.getCoordinates().y)) {
                        andResult_15 = true;
                    }
                }

                if (andResult_15) {
                    orResult_5 = true;
                } else {
                    Boolean andResult_16 = false;

                    if (Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                    tf.getCoordinates().x.longValue()),
                                Utils.abs(ti.getCoordinates().y.longValue() -
                                    tf.getCoordinates().y.longValue()))) {
                        if (checkPiecesMiddle(ti, tf)) {
                            andResult_16 = true;
                        }
                    }

                    orResult_5 = andResult_16;
                }

                orResult_4 = orResult_5;
            }

            return orResult_4;
        } else {
            Boolean orResult_6 = false;

            Boolean andResult_17 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= n.longValue()) {
                    andResult_17 = true;
                }
            }

            if (andResult_17) {
                orResult_6 = true;
            } else {
                Boolean orResult_7 = false;

                Boolean andResult_18 = false;

                if (Utils.abs(ti.getCoordinates().x.longValue() -
                            tf.getCoordinates().x.longValue()) <= n.longValue()) {
                    if (Utils.equals(ti.getCoordinates().y,
                                tf.getCoordinates().y)) {
                        andResult_18 = true;
                    }
                }

                if (andResult_18) {
                    orResult_7 = true;
                } else {
                    Boolean orResult_8 = false;

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
                        orResult_8 = true;
                    } else {
                        Boolean andResult_21 = false;

                        if (Utils.abs(ti.getCoordinates().x.longValue() -
                                    tf.getCoordinates().x.longValue()) <= n.longValue()) {
                            Boolean andResult_22 = false;

                            if (Utils.abs(ti.getCoordinates().y.longValue() -
                                        tf.getCoordinates().y.longValue()) <= n.longValue()) {
                                if (checkPiecesMiddle(ti, tf)) {
                                    andResult_22 = true;
                                }
                            }

                            if (andResult_22) {
                                andResult_21 = true;
                            }
                        }

                        orResult_8 = andResult_21;
                    }

                    orResult_7 = orResult_8;
                }

                orResult_6 = orResult_7;
            }

            return orResult_6;
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
