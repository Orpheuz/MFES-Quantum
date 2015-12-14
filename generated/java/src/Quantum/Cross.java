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
        } else {
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
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf) {
        if (ti.isSpecial()) {
            Boolean andResult_10 = false;

            if (checkPiecesMiddle(ti, tf)) {
                Boolean orResult_1 = false;

                if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                    orResult_1 = true;
                } else {
                    Boolean orResult_2 = false;

                    if (Utils.equals(ti.getCoordinates().y,
                                tf.getCoordinates().y)) {
                        orResult_2 = true;
                    } else {
                        orResult_2 = Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                    tf.getCoordinates().x.longValue()),
                                Utils.abs(ti.getCoordinates().y.longValue() -
                                    tf.getCoordinates().y.longValue()));
                    }

                    orResult_1 = orResult_2;
                }

                if (orResult_1) {
                    andResult_10 = true;
                }
            }

            return andResult_10;
        } else {
            Boolean andResult_11 = false;

            if (Utils.abs(ti.getCoordinates().x.longValue() -
                        tf.getCoordinates().x.longValue()) <= 1L) {
                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= 1L) {
                    andResult_11 = true;
                }
            }

            return andResult_11;
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf, final Number n) {
        if (ti.isSpecial()) {
            Boolean andResult_12 = false;

            Boolean orResult_3 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                orResult_3 = true;
            } else {
                Boolean orResult_4 = false;

                if (Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y)) {
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
                    andResult_12 = true;
                }
            }

            return andResult_12;
        } else {
            Boolean andResult_13 = false;

            if (Utils.abs(ti.getCoordinates().x.longValue() -
                        tf.getCoordinates().x.longValue()) <= n.longValue()) {
                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= n.longValue()) {
                    andResult_13 = true;
                }
            }

            return andResult_13;
        }
    }

    public Number getSize() {
        return 1L;
    }

    public String toString() {
        return "Cross{}";
    }
}
