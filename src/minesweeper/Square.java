package minesweeper;

class Square {
	private boolean opened;

	private Square(boolean opened) {
		this.opened = opened;
	}

	static Square openedSquare() {
		return new Square(true);
	}

	static Square closedSquare() {
		return new Square(false);
	}
	
	void opened() {
		this.opened = true;
	}
	
	public int getCountOfNeighborMines() {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (opened ? 1231 : 1237);
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
		Square other = (Square) obj;
		if (opened != other.opened)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Square [opened=" + opened + "]";
	}
}
