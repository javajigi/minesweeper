package minesweeper;


public class GridSize extends Position {
	GridSize(int x, int y) {
		super(x, y);
	}

	int countOfSquares() {
		return getX() * getY();
	}
	
	/**
	 * x, y 좌표를 0이 아닌 1부터 시작
	 * 따라서 배열에서 element 번호에 대한 보정 작업을 한다.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	int indexOfSquare(int i, int j) {
		return indexOfSquare(new Position(i, j));
	}

	int indexOfSquare(Position position) {
		if (position.getX() > getX()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (position.getY() > getY()) {
			throw new IndexOutOfBoundsException();
		}
		
		return (position.getX() -1) * this.getY() + (position.getY() - 1);
	}
}
