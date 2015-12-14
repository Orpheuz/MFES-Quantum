package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Circle extends Piece {
    public Circle(final Object p) {
        cg_init_Circle_1(((Object) p));
    }

    public Circle() {
    }

    public void cg_init_Circle_1(final Object p) {
        cg_init_Piece_1(((Object) p));
    }

    public Boolean checkPiecesMiddle(final Tile ti, final Tile tf) {
        Number tempX = ti.getCoordinates().x;
        Number tempY = ti.getCoordinates().y;
        Boolean signalX = false;
        Boolean signalY = false;

        if (tf.getCoordinates().x.longValue() > ti.getCoordinates().x.longValue()) {
            signalX = true;
        }

        if (tf.getCoordinates().y.longValue() > ti.getCoordinates().y.longValue()) {
            signalY = true;
        }

        Boolean whileCond_1 = true;

        while (whileCond_1) {
            Boolean andResult_1 = false;

            if (!(Utils.equals(tempX, tf.getCoordinates().x))) {
                if (!(Utils.equals(tempY, tf.getCoordinates().y))) {
                    andResult_1 = true;
                }
            }

            whileCond_1 = andResult_1;

            if (!(whileCond_1)) {
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

    public Boolean canMoveTo(final Tile ti, final Tile tf) {
        if (ti.isSpecial()) {
            Boolean andResult_2 = false;

            if (checkPiecesMiddle(ti, tf)) {
                if (Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                tf.getCoordinates().x.longValue()),
                            Utils.abs(ti.getCoordinates().y.longValue() -
                                tf.getCoordinates().y.longValue()))) {
                    andResult_2 = true;
                }
            }

            return andResult_2;
        } else {
            Boolean andResult_3 = false;

            if (Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                            tf.getCoordinates().x.longValue()), 1L)) {
                if (Utils.equals(Utils.abs(ti.getCoordinates().y.longValue() -
                                tf.getCoordinates().y.longValue()), 1L)) {
                    andResult_3 = true;
                }
            }

            return andResult_3;
        }
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf, final Number n) {
        if (ti.isSpecial()) {
            Boolean andResult_4 = false;

            if (checkPiecesMiddle(ti, tf)) {
                if (Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                tf.getCoordinates().x.longValue()),
                            Utils.abs(ti.getCoordinates().y.longValue() -
                                tf.getCoordinates().y.longValue()))) {
                    andResult_4 = true;
                }
            }

            return andResult_4;
        } else {
            Boolean andResult_5 = false;

            if (Utils.abs(ti.getCoordinates().x.longValue() -
                        tf.getCoordinates().x.longValue()) <= n.longValue()) {
                Boolean andResult_6 = false;

                if (Utils.abs(ti.getCoordinates().y.longValue() -
                            tf.getCoordinates().y.longValue()) <= n.longValue()) {
                    if (Utils.equals(Utils.abs(ti.getCoordinates().x.longValue() -
                                    tf.getCoordinates().x.longValue()),
                                Utils.abs(ti.getCoordinates().y.longValue() -
                                    tf.getCoordinates().y.longValue()))) {
                        andResult_6 = true;
                    }
                }

                if (andResult_6) {
                    andResult_5 = true;
                }
            }

            return andResult_5;
        }
    }

    public Number getSize() {
        return 1L;
    }

    public Piece getTopPiece() {
        return this;
    }

    public String toString() {
        return "Circle{}";
    }
}
