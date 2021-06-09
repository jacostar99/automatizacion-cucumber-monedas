package com.usbcali.monedas.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;

//esta clase ayuda a manejar el web driver
public class SeleniumUtils {

	public static WebDriver driver;

	// busca el elemento por un by y se le da un tiempo de espera para que vuelva a buscar hasta el tiempo que se le especifique
	
	public static WebElement waitElementToLoad(final By by, int waitTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(waitTime))
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class);
		
		WebElement elementoPagina = wait.until(new Function<WebDriver,WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
				
		});
		
		return elementoPagina; 

	}

}
