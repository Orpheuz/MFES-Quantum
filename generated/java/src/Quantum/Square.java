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
            Boolean andResult_18 = false;

            if (checkPiecesMiddle(ti, tf)) {
                Boolean orResult_6 = false;

                if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                    orResult_6 = true;
                } else {
                    orResult_6 = Utils.equals(ti.getCoordinates().x,
                            tf.getCoordinates().x);
                }

                if (orResult_6) {
                    andResult_18 = true;
                }
            }

            return andResult_18;
        } else {
            return Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                    tf.getCoordinates().x.longValue()) +
                Utils.abs(ti.getCoordinates().y.longValue() -
                    tf.getCoordinates().y.longValue()), 1L);
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf, final Number n) {
        if (ti.isSpecial()) {
            Boolean andResult_19 = false;

            Boolean orResult_7 = false;

            if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                orResult_7 = true;
            } else {
                orResult_7 = Utils.equals(ti.getCoordinates().x,
                        tf.getCoordinates().x);
            }

            if (orResult_7) {
                if (checkPiecesMiddle(ti, tf)) {
                    andResult_19 = true;
                }
            }

            return andResult_19;
        } else {
            Boolean orResult_8 = false;

            Boolean andResult_20 = false;

            if (Utils.abs(ti.getCoordinates().x.longValue() -
                        tf.getCoordinates().x.longValue()) <= n.longValue()) {
                if (Utils.equals(ti.getCoordinates().x, tf.getCoordinates().x)) {
                    andResult_20 = true;
                }
            }

            if (andResult_20) {
                orResult_8 = true;
            } else {
                Boolean andResult_21 = false;

                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= n.longValue()) {
                    if (Utils.equals(ti.getCoordinates().x,
                                tf.getCoordinates().x)) {
                        andResult_21 = true;
                    }
                }

                orResult_8 = andResult_21;
            }

            return orResult_8;
        }
    }

    public Number getSize() {
        return 1L;
    }

    public String toString() {
        return "Square{}";
    }
}
