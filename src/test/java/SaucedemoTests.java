import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.BaseFunc;

public class SaucedemoTests {
    private final String URL = "www.saucedemo.com/";
    private final String LOGIN_1 = "standard_user";
    private final String VALIDATE_PASSWORD = "secret_sauce";
    private final String WRONG_PASSWORD = "wrong123";
    private final String MESSAGE = "Epic sadface: Username and password do not match any user in this service";


    @Test
    public void successLogin() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        AuthorizationPage authorizationPage = new AuthorizationPage(baseFunc);
        authorizationPage.fillInLogin(LOGIN_1);
        authorizationPage.fillInPassword(VALIDATE_PASSWORD);
        authorizationPage.clickLoginBtn();

        Assertions.assertTrue(authorizationPage.login(), "Authorization failed");

    }

    @Test
    public void wrongPassword() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        AuthorizationPage authorizationPage = new AuthorizationPage(baseFunc);
        authorizationPage.fillInLogin(LOGIN_1);
        authorizationPage.fillInPassword(WRONG_PASSWORD);
        authorizationPage.clickLoginBtn();

        Assertions.assertEquals(MESSAGE, authorizationPage.getErrorMessage(), "Missing error message");

    }
}