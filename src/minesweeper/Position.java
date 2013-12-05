package minesweeper;


public class Position {
	private int x;
	private int y;

	private Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	static Position create(int x, int y) {
		return new Position(x, y);
	}
	
	int getSizeOfGrid() {
		return x * y;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
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
		return (i -1) * this.y + (j - 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
