package configure;

import minesweeper.engine.GridFactory;
import minesweeper.engine.MockGridFactory;

import com.google.inject.AbstractModule;

public class MineSweeperTestModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(GridFactory.class).to(MockGridFactory.class);
	}
}
