package minesweeper.engine;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		if (x < 1) {
			throw new IndexOutOfBoundsException();
		}
		
		if (y < 1) {
			throw new IndexOutOfBoundsException();
		}
		
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	Position move(Direction each) {
		return new Position(this.x + each.xDegree, this.y + each.yDegree);
	}
	
	enum Direction {
		EAST(1, 0),
		WEST(-1, 0),
		NORTH(0, 1),
		SOUTH(0, -1),
		NORTHEAST(1, 1),
		NORTHWEST(1, -1),
		SOUTHEAST(-1, 1),
		SOUTHWEST(-1, -1);
		
		private int xDegree;
		private int yDegree;

		private Direction(int xDegree, int yDegree) {
			this.xDegree = xDegree;
			this.yDegree = yDegree;
		}
		
		int getxDegree() {
			return xDegree;
		}
		
		int getyDegree() {
			return yDegree;
		}
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
