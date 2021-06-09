package com.usbcali.monedas.views;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.usbcali.monedas.utils.SeleniumUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MonedaView {

	public static String monedaLocal;
	public static String monedaExtranjera;

	// input donde se escribe lo que se quiere buscar
	private static By inputSearch = By.name("q");

	// boton que se presiona para buscar
	private static By inputButton = By.name("btnK");

	// lo que encuentra el buscador, la primera opcion
	private static By h3ValorMoneda = By.cssSelector(".DFlfde.SwHCTb");

	@Given("la moneda local {string}")
	public void laMonedaLocal(String moneda) {
		monedaLocal = moneda;
		
	}

	@Given("la moneda extranjera {string}")
	public void laMonedaExtranjera(String moneda) {
		monedaExtranjera = moneda	;
	}

	@When("escribo las monedas en el buscador")
	public void escriboLasMonedasEnElBuscador() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		SeleniumUtils.driver = new ChromeDriver();
		SeleniumUtils.driver.manage().window().maximize();
		SeleniumUtils.driver.navigate().to("https://www.google.com/?hl=es");
		
		//llamo al metodo wait y le paso el campo de busqueda
		SeleniumUtils.waitElementToLoad(inputSearch, 20).sendKeys(monedaLocal + " a " + monedaExtranjera);
	}

	@When("le doy submit")
	public void leDoySubmit() {
		SeleniumUtils.waitElementToLoad(inputButton, 20).submit();
	}

	@Then("leo el valor de la moneda")
	public void leoElValorDeLaMoneda() {
		//va a extraer el texto 
		String valorMoneda = SeleniumUtils.waitElementToLoad(h3ValorMoneda, 20).getText();
		
		System.out.print(monedaLocal + " = " + valorMoneda +  " " + monedaExtranjera);
		SeleniumUtils.driver.quit();
	}

}
