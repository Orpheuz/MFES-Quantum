package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Square extends Piece {
    public Square(final Object p) {
        cg_init_Square_1(((Object) p));
    }

    public Square() {
    }

    public void cg_init_Square_1(final Object p) {
        cg_init_Piece_1(((Object) p));
    }

    public Boolean checkPiecesMiddle(final Tile ti, final Tile tf) {
        Number tempX = 1L;
        Number tempY = 1L;
        Number max = 1L;

        if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
            tempX = ti.getCoordinates().x;

            if (ti.getCoordinates().y.longValue() > tf.getCoordinates().y.longValue()) {
                max = ti.getCoordinates().y;
                tempY = tf.getCoordinates().y;
            } else {
                tempY = ti.getCoordinates().y;
                max = tf.getCoordinates().y;
            }

            Boolean whileCond_5 = true;

            while (whileCond_5) {
                whileCond_5 = tempY.longValue() < (max.longValue() - 1L);

                if (!(whileCond_5)) {
                    break;
                }

                tempY = tempY.longValue() + 1L;

                if (!(Utils.equals(Board.getInstance().getTile(tempX, tempY)
                                            .getPiece(), null))) {
                    return false;
                }
            }

            return true;
        } else {
            tempY = ti.getCoordinates().y;

            if (ti.getCoordinates().x.longValue() > tf.getCoordinates().x.longValue()) {
                max = ti.getCoordinates().x;
                tempX = tf.getCoordinates().x;
            } else {
                tempX = ti.getCoordinates().x;
                max = tf.getCoordinates().x;
            }

            Boolean whileCond_6 = true;

            while (whileCond_6) {
                whileCond_6 = tempX.longValue() < (max.longValue() - 1L);

                if (!(whileCond_6)) {
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
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf) {
        if (ti.isSpecial()) {
            Boolean andResult_28 = false;

            if (checkPiecesMiddle(ti, tf)) {
                Boolean orResult_10 = false;

                if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                    orResult_10 = true;
                } else {
                    orResult_10 = Utils.equals(ti.getCoordinates().x,
                            tf.getCoordinates().x);
                }

                if (orResult_10) {
                    andResult_28 = true;
                }
            }

            return andResult_28;
        } else {
            return Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                    tf.getCoordinates().x.longValue()) +
                Utils.abs(ti.getCoordinates().y.longValue() -
                    tf.getCoordinates().y.longValue()), 1L);
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf, final Number n) {
        if (ti.isSpecial()) {
            Boolean andResult_29 = false;

            Boolean orResult_11 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                orResult_11 = true;
            } else {
                orResult_11 = Utils.equals(ti.getCoordinates().x,
                        tf.getCoordinates().x);
            }

            if (orResult_11) {
                if (checkPiecesMiddle(ti, tf)) {
                    andResult_29 = true;
                }
            }

            return andResult_29;
        } else {
            Boolean andResult_30 = false;

            Boolean orResult_12 = false;

            Boolean andResult_31 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                if (Utils.abs(tf.getCoordinates().y.longValue() -
                            ti.getCoordinates().y.longValue()) <= n.longValue()) {
                    andResult_31 = true;
                }
            }

            if (andResult_31) {
                orResult_12 = true;
            } else {
                Boolean andResult_32 = false;

                if (Utils.equals(ti.getCoordinates().y, tf.getCoordinates().y)) {
                    if (Utils.abs(tf.getCoordinates().x.longValue() -
                                ti.getCoordinates().x.longValue()) <= n.longValue()) {
                        andResult_32 = true;
                    }
                }

                orResult_12 = andResult_32;
            }

            if (orResult_12) {
                if (checkPiecesMiddle(ti, tf)) {
                    andResult_30 = true;
                }
            }

            return andResult_30;
        }
    }

    public Number getSize() {
        return 1L;
    }

    public Piece getTopPiece() {
        return this;
    }

    public String toString() {
        return "Square{}";
    }
}
