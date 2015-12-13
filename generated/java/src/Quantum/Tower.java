package Quantum;

import org.overture.codegen.runtime.SeqUtil;
import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMSeq;

import Quantum.quotes.BlackQuote;
import Quantum.quotes.WhiteQuote;


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

    public void capturePiece(final Piece p) {
        stack = SeqUtil.conc(SeqUtil.seq(p), Utils.copy(stack));

        if (Utils.equals(pieceOfPlayer, WhiteQuote.getInstance())) {
            pieceOfPlayer = BlackQuote.getInstance();
        } else {
            pieceOfPlayer = WhiteQuote.getInstance();
        }
    }

    public Number getSize() {
        return stack.size();
    }

    public String toString() {
        return "Tower{" + "stack := " + Utils.toString(stack) + "}";
    }

	@Override
	public Boolean canMoveTo(Tile ti, Tile tf, Number nt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean moveTo(Tile ti, Tile tf, Number nt) {
		// TODO Auto-generated method stub
		return null;
	}
}
