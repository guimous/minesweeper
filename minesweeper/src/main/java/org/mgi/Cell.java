public class Cell {

	private int minesAround;
	private Visibility visibility;
	private final boolean isMined;

	public enum Visibility {
		HIDDEN,
		REVEALED,
		FLAGGED;
	}

	public Cell(int minesAround, Visibility visibility, boolean isMined)
		throws IllegalArgumentException {
		if (minesAround < 0) {
			throw new IllegalArgumentException();
		}
		this.minesAround = minesAround;
		this.visibility = visibility;
		this.isMined = isMined;
	}

	public Visibility getVisibility() {
		return this.visibility;
	}

	public int getMinesAround() {
		return this.minesAround;
	}

	private boolean isHidden() {
		return this.visibility == Visibility.HIDDEN;
	}

	private boolean isFlagged() {
		return this.visibility == Visibility.FLAGGED;
	}

	private boolean isRevealed() {
		return this.visibility == Visibility.REVEALED;
	}	

	public boolean isMined() {
		return this.isMined;
	}

	public void reveal() {
		if (!isFlagged())
			this.visibility = Visibility.REVEALED;
	}

	public void flag() {
		if (isHidden())
			this.visibility = Visibility.FLAGGED;
		else if (isFlagged()) {
			this.visibility = Visibility.HIDDEN;
		}
	}
}
