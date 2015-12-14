package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Tower extends Piece {
    private VDMSeq stack = SeqUtil.seq();

    public Tower(final Object player, final Piece p1, final Piece p2) {
        cg_init_Tower_1(((Object) player), p1, p2);
    }

    public Tower() {
    }

    public void cg_init_Tower_1(final Object player, final Piece p1,
        final Piece p2) {
        stack = SeqUtil.conc(SeqUtil.seq(p1, p2), Utils.copy(stack));

        cg_init_Piece_1(((Object) player));
    }

    public Boolean checkPiecesMiddle(final Tile ti, final Tile tf) {
        return ((Piece) stack.get(0)).checkPiecesMiddle(ti, tf);
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf) {
        return ((Piece) stack.get(0)).canMoveTo(ti, tf, getSize());
    }

    public Boolean canMoveTo(final Tile ti, final Tile tf, final Number n) {
        return true;
    }

    public void capturePiece(final Piece p) {
        stack = SeqUtil.conc(p.getStack(), Utils.copy(stack));

        if (Utils.equals(pieceOfPlayer, quantum.quotes.WhiteQuote.getInstance())) {
            pieceOfPlayer = quantum.quotes.BlackQuote.getInstance();
        } else {
            pieceOfPlayer = quantum.quotes.WhiteQuote.getInstance();
        }
    }

    public Number getSize() {
        return stack.size();
    }

    public VDMSeq getStack() {
        return Utils.copy(stack);
    }

    public Piece getPieceTower() {
        return ((Piece) stack.get(0));
    }

    public String toString() {
        return "Tower{" + "stack := " + Utils.toString(stack) + "}";
    }
}
