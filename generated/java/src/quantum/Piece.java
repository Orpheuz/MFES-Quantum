package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
abstract public class Piece {
    protected Object pieceOfPlayer;

    protected Piece(final Object p) {
        cg_init_Piece_1(((Object) p));
    }

    public Piece() {
    }

    protected void cg_init_Piece_1(final Object p) {
        pieceOfPlayer = p;
    }

    public abstract Boolean canMoveTo(final Tile ti, final Tile tf);

    public abstract Boolean canMoveTo(final Tile ti, final Tile tf,
        final Number nt);

    public abstract Boolean checkPiecesMiddle(final Tile ti, final Tile tf);

    public Boolean moveTo(final Tile ti, final Tile tf) {
        Boolean andResult_23 = false;

        if (canMoveTo(ti, tf)) {
            Boolean orResult_9 = false;

            if (Utils.equals(tf.getPiece(), null)) {
                orResult_9 = true;
            } else {
                orResult_9 = !(Utils.equals(ti.getPiece().pieceOfPlayer,
                        tf.getPiece().pieceOfPlayer));
            }

            if (orResult_9) {
                andResult_23 = true;
            }
        }

        if (andResult_23) {
            Boolean andResult_24 = false;

            if (!(Utils.equals(tf.getPiece(), null))) {
                Boolean andResult_25 = false;

                if (tf.getPiece() instanceof Tower) {
                    if (tf.getPiece().getSize().longValue() > 6L) {
                        andResult_25 = true;
                    }
                }

                if (andResult_25) {
                    andResult_24 = true;
                }
            }

            if (andResult_24) {
                return false;
            } else {
                Boolean andResult_26 = false;

                if (!(Utils.equals(tf.getPiece(), null))) {
                    if (tf.getPiece().getSize().longValue() < 6L) {
                        andResult_26 = true;
                    }
                }

                if (andResult_26) {
                    ti.setPiece(null);

                    if (this instanceof Tower) {
                        capturePiece(tf.getPiece());
                        tf.setPiece(this);
                    } else {
                        tf.setPiece(new Tower(((Object) pieceOfPlayer), this,
                                tf.getPiece().getStack()));
                    }

                    return true;
                } else {
                    ti.setPiece(null);
                    tf.setPiece(this);

                    return true;
                }
            }
        } else {
            return false;
        }
    }

    public void capturePiece(final Piece p) {
        return;
    }

    public Object getPlayer() {
        return pieceOfPlayer;
    }

    public VDMSeq getStack() {
        return SeqUtil.seq(this);
    }

    public Number getSize() {
        throw new UnsupportedOperationException();
    }

    public Object getOwner() {
        return pieceOfPlayer;
    }

    public void setOwner(final Object p) {
        pieceOfPlayer = p;
    }

    public abstract Piece getTopPiece();

    public String toString() {
        return "Piece{" + "pieceOfPlayer := " + Utils.toString(pieceOfPlayer) +
        "}";
    }
}
