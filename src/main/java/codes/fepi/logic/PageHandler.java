package codes.fepi.logic;

import codes.fepi.entities.Item;
import codes.fepi.entities.Rarity;
import spark.QueryParamsMap;
import spark.Request;

import java.util.ArrayList;
import java.util.List;

@codes.fepi.ldfspark.PageHandler
public class PageHandler {

	public Object index() {
		return Rarity.values();
	}

	public Object roll(Request req) {
		final QueryParamsMap paramsMap = req.queryMap();
		final List<Item> loot = new ArrayList<>();
		for (Rarity rarity : Rarity.values()) {
			final QueryParamsMap value = paramsMap.get(rarity.name());
			if (value != null && value.hasValue()) {
				final int count = value.integerValue();
				loot.addAll(Randomizer.INSTANCE.getLoot(rarity, count));
			}
		}
		return loot;
	}
}
