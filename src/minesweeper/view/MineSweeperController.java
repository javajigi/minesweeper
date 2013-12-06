package minesweeper.view;

import java.util.Scanner;

import javax.inject.Inject;

import minesweeper.engine.GameOverException;
import minesweeper.engine.Grid;
import minesweeper.engine.GridFactory;
import minesweeper.engine.GridSize;
import minesweeper.engine.Position;

import com.google.inject.Guice;
import com.google.inject.Injector;

import configure.MineSweeperModule;
import configure.ViewModule;

public class MineSweeperController {
	private GridFactory gridFactory;
	private Grid grid;
	private View view;

	@Inject
	public MineSweeperController(GridFactory gridFactory, View view) {
		this.gridFactory = gridFactory;
		this.view = view;
	}

	public void openSquare(Position position) throws GameOverException {
		grid.openSquare(position);
	}

	public String render() {
		return view.render(grid);
	}
	
	public void start(GridSize gridSize, int countOfMine) {
		grid = gridFactory.create(gridSize, countOfMine);
	}
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MineSweeperModule(), new ViewModule());
		MineSweeperController mineSweeper = injector.getInstance(MineSweeperController.class);
		mineSweeper.start(new GridSize(5, 5), 5);
		
		Scanner sc = new Scanner(System.in);
        System.out.println("지뢰찾기 게임 시작");
        while(sc.hasNextLine()) {
        	CommandParser parser = new CommandParser();
        	CommandLine commandLine = parser.parse(sc.nextLine());
        	if (commandLine == null) {
        		continue;
        	}
        	if (commandLine.isOpenCommand()) {
        		try {
					mineSweeper.openSquare(commandLine.getPosition());
					System.out.println(mineSweeper.render());
				} catch (GameOverException e) {
					System.out.println("Lose Game.");
					break;
				}
        	}
        }
        sc.close();
	}
}
