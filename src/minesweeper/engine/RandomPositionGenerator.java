package minesweeper.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RandomPositionGenerator {
	private GridSize gridSize;
	private int countOfMine;

	RandomPositionGenerator(GridSize gridSize, int countOfMine) {
		this.gridSize = gridSize;
		this.countOfMine = countOfMine;
	}

	List<Position> generate() {
		List<Integer> shuffledIndex = createShuffledIndex();
		return transformToPositionUntilCountOfMine(shuffledIndex);
	}

	private List<Position> transformToPositionUntilCountOfMine(List<Integer> shuffledIndex) {
		List<Position> randomPositions = new ArrayList<Position>();
		for (int i = 0; i < countOfMine; i++) {
			randomPositions.add(gridSize.indexToPosition(shuffledIndex.get(i)));
		}
		return randomPositions;
	}

	private List<Integer> createShuffledIndex() {
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < gridSize.countOfSquares(); i++) {
			values.add(i);
		}
		Collections.shuffle(values);
		System.out.println(values);
		return values;
	}

}
