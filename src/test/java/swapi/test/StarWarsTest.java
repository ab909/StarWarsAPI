package swapi.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class StarWarsTest {

	@Test
	public void getAllCharactersTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		String allCharacters=given().log().all().when().get("people/").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();
		Assert.assertEquals(allCharacters,allCharacters);

	}

	@Test
	public void getSpecificCharacterTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
	String character=given().log().all().queryParam("search", "Luke Skywalker").when().get("people/").then().assertThat().log().all()
				.statusCode(200).extract().response().asString();
	Assert.assertEquals(character, character);

	}

	@Test ()
	public void getAllPlanetsTest() {
	RestAssured.baseURI = "https://swapi.dev/api/";
	String allPlanets =given().log().all().when().get("planets/").then().assertThat().log().all().statusCode(200).extract().response()
			.asString();
	Assert.assertEquals(allPlanets, allPlanets);

	}

	@Test ()
	public void getSpecificPlanetTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		String planet=given().log().all().queryParam("search", "Tatooine").when().get("planets/").then().assertThat().log().all()
					.statusCode(200).extract().response().asString();
		Assert.assertEquals(planet, planet);
	}

	

}
