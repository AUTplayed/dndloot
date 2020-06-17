package codes.fepi.data;

import codes.fepi.entities.Item;
import codes.fepi.entities.Rarity;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public enum Repository {
	INSTANCE;

	private Map<Rarity, Set<Item>> data = new ConcurrentHashMap<>();

	public void initData(Collection<Item> items) {
		final Map<Rarity, Set<Item>> map = items.stream()
				.collect(Collectors.groupingBy(Item::getRarity, Collectors.toSet()));
		data.putAll(map);
	}

	public Set<Item> getItems(Rarity rarity) {
		final Set<Item> items = data.get(rarity);
		if (items == null) {
			return Collections.emptySet();
		}
		return items;
	}
}
