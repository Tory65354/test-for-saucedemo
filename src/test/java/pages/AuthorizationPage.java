package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AuthorizationPage {
    private final By LOGIN = By.name("user-name");
    private final By PASSWORD = By.name("password");
    private final By LOGIN_BTN = By.id("login-button");
    private final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");
    private final By NEXT_ELEMENT = By.id("shopping_cart_container");

    private BaseFunc baseFunc;

    public AuthorizationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInLogin(String login) {
        baseFunc.type(LOGIN, login);
    }

    public void fillInPassword(String password) {
        baseFunc.type(PASSWORD, password);
    }

    public void clickLoginBtn() {
        baseFunc.click(LOGIN_BTN);
    }

    public boolean login() {
        return baseFunc.findElement(NEXT_ELEMENT).isDisplayed();
    }

    public String getErrorMessage() {
        WebElement errorMessage = baseFunc.findElement(ERROR_MESSAGE);
        if (errorMessage != null) {
            String message = errorMessage.getText();
            return message;
        } else {
            return "no message";
        }


    }


}
