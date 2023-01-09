import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class OrderPageSecond {
    private WebDriver driver;
    //заголовок страницы
    private By header = By.className("Order_Header__BZXOb");
    private By dateField = By.className("Dropdown-placeholder");
    private By orderButton = By.xpath(".//button[text()='Заказать' and last()]");
    private By yesOrderButton = By.xpath(".//button[text()='Да']");
    private By popupHeader = By.className("Order_ModalHeader__3FDaJ");
    private By successMessage = By.xpath(".//*[contains(text(),'Заказ оформлен')]");

    public OrderPageSecond(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForLoadPage() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(header).getText() != null
                && !driver.findElement(header).getText().isEmpty()
        ));
    }

    private void waitForLoadPopUp() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(popupHeader).getText() != null
                && !driver.findElement(popupHeader).getText().isEmpty()
        ));
    }

    private boolean checkSuccessMessage() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(successMessage).isDisplayed();
    }

    private void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    private void setRentPeriodForOneDay() {
        driver.findElement(By.className("Dropdown-placeholder")).click();
        driver.findElement(By.xpath(".//*[text()='сутки']")).click();
    }

    private void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    private void clickPopupYesButton() {
        driver.findElement(yesOrderButton).click();
    }

    public boolean setFieldsAndClickOrderButton(String date) {
        waitForLoadPage();
        setDate(date);
        setRentPeriodForOneDay();
        clickOrderButton();
        waitForLoadPopUp();
        clickPopupYesButton();
        return checkSuccessMessage();
    }
}
