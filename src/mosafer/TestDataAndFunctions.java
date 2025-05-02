package mosafer;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestDataAndFunctions {

	WebDriver driver = new ChromeDriver();
	JavascriptExecutor JS = (JavascriptExecutor) driver;
	Random rand = new Random();

	String URL = "https://global.almosafer.com/en";
	String ExpectedLanguage = "en";
	String ExpectedNumber = "+966554400000";
	String ExpectedCurrency = "SAR";
	boolean ExpectedResultForQitafLogo = true;
	boolean ExpectedValueForHotelTab = false;

	int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
	String ExpectedDepartureDate = String.format("%02d", Tomorrow);
	int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();
	String ExpectedReturnDate = String.format("%02d", DayAfterTomorrow);

	String[] MyWebsites = { "https://www.almosafer.com/en?ncr=1", "https://www.almosafer.com/ar?ncr=1" };
	int RandomWebsiteIndex = rand.nextInt(MyWebsites.length);

	String[] EnglishCities = { "jeddah", "riyadh", "dubai" };
	String[] ArabicCities = { "دبي", "جدة" };
	int RandomEnglishCityIndex = rand.nextInt(EnglishCities.length);
	int RandomArabicCityIndex = rand.nextInt(ArabicCities.length);

	boolean ExpectedValueToCheckTheNewPage = true;

	public void EnterTheWebsite() {

		driver.get(URL);
		driver.manage().window().maximize();
		WebElement GreenButton = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		GreenButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	public void CheckTheLanguageAndSendRandomCityName() {

		// Check The Language
		if (driver.getCurrentUrl().equals("https://www.almosafer.com/en?ncr=1")) {
			String ActualLaguageForNow = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			String ExpectedLanguageForNow = "en";
			Assert.assertEquals(ActualLaguageForNow, ExpectedLanguageForNow);

			// Random City(Arabic Names Or English Names) And Choice The First Result
			WebElement HotelSearchField = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
			HotelSearchField.sendKeys(EnglishCities[RandomEnglishCityIndex]);
			WebElement TheListOfCities = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
			List<WebElement> Cities = TheListOfCities.findElements(By.tagName("li"));
			Cities.get(1).click();

		} else {

			// Check The Language
			String ActualLaguageForNow = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			String ExpectedLanguageForNow = "ar";
			Assert.assertEquals(ActualLaguageForNow, ExpectedLanguageForNow);

			// Random City(Arabic Names Or English Names) And Choice The First Result
			WebElement HotelSearchField = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
			HotelSearchField.sendKeys(ArabicCities[RandomArabicCityIndex]);
			WebElement TheListOfCities = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
			List<WebElement> Cities = TheListOfCities.findElements(By.tagName("li"));
			Cities.get(1).click();
		}

	}

	public void RandomlySelectNumberOfVisitors() {

		WebElement NumberOfVisitorsSelectField = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		Select Myselect = new Select(NumberOfVisitorsSelectField);
		int RandomOptionIndesx = rand.nextInt(2);
		Myselect.selectByIndex(RandomOptionIndesx);

		// Click On The Search Button
		WebElement SearchButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchButton.click();

	}

}
