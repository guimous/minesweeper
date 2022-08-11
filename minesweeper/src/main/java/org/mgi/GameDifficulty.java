/* The game difficulty determines how many mines
 * are on the grid and the dimensions of the grid.
 */
public final class GameDifficulty {

	private final int gridWidth;
	private final int gridHeight;
	private final int minesCount;
	private static final GameDifficulty BEGINNER = new GameDifficulty(9, 9, 10);
	private static final GameDifficulty INTERMEDIATE = new GameDifficulty(16, 16, 40);
	private static final GameDifficulty EXPERT = new GameDifficulty(30, 16, 99);

	private GameDifficulty(int gridWidth, int gridHeight, int minesCount) {
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.minesCount = minesCount;
	}

	public static GameDifficulty newCustomDifficulty(int gridWidth,
													 int gridHeight,
													 int minesCount) {
		if (isValidGridConfiguration(gridWidth, gridHeight, minesCount))
			return new GameDifficulty(gridWidth, gridHeight, minesCount);
		throw new IllegalArgumentException();
	}

	private static boolean isValidGridDimension(int width, int height) {
		return width > 0 && height > 0;
	}

	private static boolean isValidMinesCount(int minesCount) {
		return minesCount >= 0;
	}

	private static boolean isGridBigEnoughForMines(int gridWidth,
									int gridHeight,
									int minesCount) {
		return gridWidth * gridHeight >= minesCount;
	}

	private static boolean isValidGridConfiguration(int gridWidth,
													int gridHeight,
													int minesCount) {
		return isValidGridDimension(gridWidth, gridHeight)
			&& isValidMinesCount(minesCount)
			&& isGridBigEnoughForMines(gridWidth, gridHeight, minesCount);
	}

	public static GameDifficulty getBEGINNER() {
		return BEGINNER;
	}

	public static GameDifficulty getINTERMEDIATE() {
		return INTERMEDIATE;
	}

	public static GameDifficulty getEXPERT() {
		return EXPERT;
	}
}
