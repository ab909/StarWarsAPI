package swapi.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class StarWarsTest {

	@Test(priority = 1, enabled = true)

	// API will retrive all Star Wars characters

	public void getAllCharactersTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		String page1 = given().log().all().when().get("people/").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page2 = given().log().all().when().get("people/?page=2").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page3 = given().log().all().when().get("people/?page=3").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page4 = given().log().all().when().get("people/?page=4").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page5 = given().log().all().when().get("people/?page=5").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page6 = given().log().all().when().get("people/?page=6").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page7 = given().log().all().when().get("people/?page=7").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page8 = given().log().all().when().get("people/?page=8").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page9 = given().log().all().when().get("people/?page=9").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		Object characters[] = { page1, page2, page3, page4, page5, page6, page7, page8, page9 };
		Assert.assertEquals(characters, characters);
	}

	@Test(priority = 2, enabled = true)

	// API will retrive a specific character

	public void getSpecificCharacterTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		String character = given().log().all().queryParam("search", "Luke Skywalker").when().get("people/").then()
				.assertThat().log().all().statusCode(200).extract().response().asString();
		Assert.assertEquals(character, character);

	}

	@Test(priority = 3, enabled = true)

	// API will retrive all planets

	public void getAllPlanetsTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		String page1 = given().log().all().when().get("planets/").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page2 = given().log().all().when().get("planets/?page=2").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page3 = given().log().all().when().get("planets/?page=3").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page4 = given().log().all().when().get("planets/?page=4").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page5 = given().log().all().when().get("planets/?page=5").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		String page6 = given().log().all().when().get("planets/?page=6").then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		Object planets[] = { page1, page2, page3, page4, page5, page6 };
		Assert.assertEquals(planets, planets);

	}

	@Test(priority = 4, enabled = true)

	// API will retrive a specific planet

	public void getSpecificPlanetTest() {
		RestAssured.baseURI = "https://swapi.dev/api/";
		String planet = given().log().all().queryParam("search", "Tatooine").when().get("planets/").then().assertThat()
				.log().all().statusCode(200).extract().response().asString();
		Assert.assertEquals(planet, planet);
	}

	@Test(priority = 5, enabled = true)

	// User is able to search for a planet or character

	public void userSearchPeople() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhib\\Desktop\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://swapi.dev/");
		driver.findElement(By.xpath("//input[@id='interactive']")).sendKeys("people/2/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(2000);
		String characterInfo = driver.findElement(By.xpath("//pre[@id='interactive_output']")).getText();
		System.out.println(characterInfo);
		boolean charDetailDisplay = driver.findElement(By.xpath("//pre[@id='interactive_output']")).isDisplayed();
		Assert.assertTrue(charDetailDisplay);

	}

	@Test(priority = 6, enabled = true)
	public void userSearchPlanet() throws InterruptedException {

		// The user will be able to search for the details of a planet
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhib\\Desktop\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://swapi.dev/");
		driver.findElement(By.xpath("//input[@id='interactive']")).sendKeys("planets/20/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(2000);
		String planetInfo = driver.findElement(By.xpath("//div[@class='well']")).getText();
		System.out.println(planetInfo);
		boolean planetDetail = driver.findElement(By.xpath("//div[@class='well']")).isDisplayed();
		Assert.assertTrue(planetDetail);
	}

}
