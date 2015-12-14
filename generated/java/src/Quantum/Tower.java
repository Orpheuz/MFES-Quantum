package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Tower extends Piece {
    private VDMSeq stack = SeqUtil.seq();

    public Tower(final Object player, final Piece p1, final VDMSeq p2) {
        cg_init_Tower_1(((Object) player), p1, Utils.copy(p2));
    }

    public Tower() {
    }

    public void cg_init_Tower_1(final Object player, final Piece p1,
        final VDMSeq p2) {
        stack = SeqUtil.conc(SeqUtil.seq(p1), Utils.copy(p2));

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
        stack = SeqUtil.conc(Utils.copy(stack), p.getStack());
    }

    public Number getSize() {
        return stack.size();
    }

    public VDMSeq getStack() {
        return Utils.copy(stack);
    }

    public Piece getTopPiece() {
        return ((Piece) stack.get(0));
    }

    public String toString() {
        return "Tower{" + "stack := " + Utils.toString(stack) + "}";
    }
}
