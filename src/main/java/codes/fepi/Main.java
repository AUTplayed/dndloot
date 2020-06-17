package codes.fepi;

import codes.fepi.data.Repository;
import codes.fepi.entities.Item;
import codes.fepi.ldfspark.LdfSpark;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Spark;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final TypeReference ref = new TypeReference<List<Item>>() {
	};

	public static void main(String[] args) throws URISyntaxException, IOException {
		Repository.INSTANCE.initData(MAPPER.readValue(Main.class.getClassLoader().getResource("data.json"), ref));
		Spark.port(6020);
		LdfSpark.start();
	}
}
