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
        Boolean andResult_14 = false;

        if (canMoveTo(ti, tf)) {
            Boolean orResult_5 = false;

            if (Utils.equals(tf.getPiece(), null)) {
                orResult_5 = true;
            } else {
                orResult_5 = !(Utils.equals(ti.getPiece().pieceOfPlayer,
                        tf.getPiece().pieceOfPlayer));
            }

            if (orResult_5) {
                andResult_14 = true;
            }
        }

        if (andResult_14) {
            Boolean andResult_15 = false;

            if (!(Utils.equals(tf.getPiece(), null))) {
                Boolean andResult_16 = false;

                if (tf.getPiece() instanceof Tower) {
                    if (tf.getPiece().getSize().longValue() > 6L) {
                        andResult_16 = true;
                    }
                }

                if (andResult_16) {
                    andResult_15 = true;
                }
            }

            if (andResult_15) {
                return false;
            } else {
                Boolean andResult_17 = false;

                if (!(Utils.equals(tf.getPiece(), null))) {
                    if (tf.getPiece().getSize().longValue() < 6L) {
                        andResult_17 = true;
                    }
                }

                if (andResult_17) {
                    ti.setPiece(null);
                    tf.setPiece(new Tower(((Object) pieceOfPlayer), this,
                            tf.getPiece()));
                    capturePiece(tf.getPiece());

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
        if (Utils.equals(pieceOfPlayer, quantum.quotes.WhiteQuote.getInstance())) {
            pieceOfPlayer = quantum.quotes.BlackQuote.getInstance();
        } else {
            pieceOfPlayer = quantum.quotes.WhiteQuote.getInstance();
        }
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

    public String toString() {
        return "Piece{" + "pieceOfPlayer := " + Utils.toString(pieceOfPlayer) +
        "}";
    }
}
