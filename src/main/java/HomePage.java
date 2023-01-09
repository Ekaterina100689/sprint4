import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// Класс домашней страницы сайта "Яндекс.Самокат"
public class HomePage {
    private WebDriver driver;
    //заголовок страницы
    private By header = By.className("Home_Header__iJKdX");
    //кнопка заказать(обе)
    private By orderButton = By.xpath(".//button[text()='Заказать']");
    //заголовок секции "Вопросы о важном"
    private By faqHeader = By.className("Home_SubHeader__zwi_E");
    //элементы-кнопки секции "Вопросы о важном"
    private By faqButton = By.className("accordion__button");
    //текст под катом элементов-кнопок секции "Вопросы о важном"
    private By faqCutText = By.className("accordion__panel");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnOrderButton(int position) {
        driver.findElements(orderButton).get(position).click();
    }

    private void clickOnAllFaqButtons() {
        for (WebElement button: driver.findElements(faqButton)) {
            button.click();
        }
    }

    private boolean checkAllFaqTextExpand() {
        List<WebElement> elements = driver.findElements(faqCutText);
        for (WebElement cutBlock: elements) {
            if (cutBlock.getText() == null) {
                return false;
            }
        }
        return elements.size() == 8;
    }

    public boolean faqAreaCheck() {
        clickOnAllFaqButtons();
        return checkAllFaqTextExpand();
    }
}
