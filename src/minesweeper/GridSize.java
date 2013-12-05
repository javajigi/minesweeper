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
		if (i > getX()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (j > getY()) {
			throw new IndexOutOfBoundsException();
		}
		
		return (i -1) * this.getY() + (j - 1);
	}
}
