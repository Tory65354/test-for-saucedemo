package pages;

import org.openqa.selenium.By;

public class AuthorizationPage {
    private final By LOGIN = By.name("user-name");
    private final By PASSWORD = By.name("password");
    private final By LOGIN_BTN = By.id("login-button");

    private BaseFunc baseFunc;

    public AuthorizationPage (BaseFunc baseFunc) {this.baseFunc = baseFunc;}
    public void fillInLogin (String login) {baseFunc.type(LOGIN,login);};
    public void fillInPassword (String password) {baseFunc.type(PASSWORD,password);};
    public void clickLoginBtn() {baseFunc.click(LOGIN_BTN);};

}
