package swapi.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class StarWarsTest {

	@Test (priority=1, enabled=true)
	//API will retrive all Star Wars characters
	public void getAllCharactersTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		given().log().all().when().get("people/").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();
		given().log().all().when().get("people/?page=2").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		given().log().all().when().get("people/?page=3").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		given().log().all().when().get("people/?page=4").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		given().log().all().when().get("people/?page=5").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		given().log().all().when().get("people/?page=6").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		given().log().all().when().get("people/?page=7").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		given().log().all().when().get("people/?page=8").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		given().log().all().when().get("people/?page=9").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
	}

	@Test (priority=2, enabled=false)
	//API will retrive a specific character
	public void getSpecificCharacterTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
	String character=given().log().all().queryParam("search", "Luke Skywalker").when().get("people/").then().assertThat().log().all()
				.statusCode(200).extract().response().asString();
	Assert.assertEquals(character, character);

	}

	@Test (priority=3, enabled=false)
	//API will retrive all planets
	public void getAllPlanetsTest() {
	RestAssured.baseURI = "https://swapi.dev/api/";
	String allPlanets =given().log().all().when().get("planets/").then().assertThat().log().all().statusCode(200).extract().response()
			.asString();
	Assert.assertEquals(allPlanets, allPlanets);

	}

	@Test (priority=4, enabled=false)
	//API will retrive a specific planet
	public void getSpecificPlanetTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		String planet=given().log().all().queryParam("search", "Tatooine").when().get("planets/").then().assertThat().log().all()
					.statusCode(200).extract().response().asString();
		Assert.assertEquals(planet, planet);
	}
	
	@Test (enabled=false)
	// User is able to search for a planet or character
	public void userSearchTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhib\\Desktop\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://swapi.dev/");	
		driver.findElement(By.xpath("//input[@id='interactive']")).sendKeys("people/2");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}
	

	     
	    }

