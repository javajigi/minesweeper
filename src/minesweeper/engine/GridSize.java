package minesweeper.engine;

import java.util.ArrayList;
import java.util.List;


public class GridSize extends Position {
	public GridSize(int x, int y) {
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
	public int indexOfSquare(int i, int j) {
		return indexOfSquare(new Position(i, j));
	}

	int indexOfSquare(Position position) {
		if (!isValid(position)) {
			throw new IndexOutOfBoundsException();
		}
		
		return (position.getX() -1) * this.getY() + (position.getY() - 1);
	}

	List<Position> findNeighborPositions(Position position) {
		List<Position> neighborPositions = new ArrayList<Position>();
		Direction[] directions = Direction.values();
		for (Direction direction : directions) {
			try {
				Position movedPosition = position.move(direction);
				if (isValid(movedPosition)) {
					neighborPositions.add(movedPosition);
				}
			} catch (IndexOutOfBoundsException e) {
				continue;
			}
		}
		return neighborPositions;
	}

	boolean isValid(Position position) {
		if (position.getX() > getX()) {
			return false;
		}
		
		if (position.getY() > getY()) {
			return false;
		}
		
		return true;
	}

	Position indexToPosition(int index) {
		int temp = index % getY();
		int x = (index - temp) / getX() + 1;
		int y = temp + 1;
		return new Position(x, y);
	}
}
