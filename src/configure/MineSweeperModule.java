package configure;

import minesweeper.engine.GridFactory;
import minesweeper.engine.RandomGridFactory;

import com.google.inject.AbstractModule;

public class MineSweeperModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(GridFactory.class).to(RandomGridFactory.class);
	}
}
