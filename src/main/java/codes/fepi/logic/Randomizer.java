package codes.fepi.logic;

import codes.fepi.data.Repository;
import codes.fepi.entities.Item;
import codes.fepi.entities.Rarity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public enum Randomizer {
	INSTANCE;

	private static final Random RAND = new Random();

	public List<Item> getLoot(Rarity rarity, int count) {
		final List<Item> items = new ArrayList<>(Repository.INSTANCE.getItems(rarity));
		final List<Item> loot = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			final int randIndex = RAND.nextInt(items.size());
			loot.add(items.remove(randIndex));
		}
		return loot;
	}
}
