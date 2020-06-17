package codes.fepi.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = Item.Builder.class)
public class Item {

	private final String name;
	private final String description;
	private final Rarity rarity;

	public Item(Builder builder) {
		this.name = Objects.requireNonNull(builder.name);
		this.description = Objects.requireNonNull(builder.description);
		this.rarity = Objects.requireNonNull(builder.rarity);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public static Builder builder() {
		return new Builder();
	}

	public Builder modify() {
		return new Builder(this);
	}

	@JsonPOJOBuilder(withPrefix = "")
	public static class Builder {
		private String name;
		private String description = "";
		private Rarity rarity;

		public Builder() {
		}

		public Builder(Item item) {
			this.name = item.name;
			this.description = item.description;
			this.rarity = item.rarity;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public Rarity getRarity() {
			return rarity;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder rarity(Rarity rarity) {
			this.rarity = rarity;
			return this;
		}

		public Item build() {
			return new Item(this);
		}
	}
}
