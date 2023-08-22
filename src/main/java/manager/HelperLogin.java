package manager;

import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperLogin extends HelperBase{
    public HelperLogin(WebDriver driver) {
        super(driver);
    }

    By OPEN_LOGIN_PAGE_BTN = By.xpath("//a[contains(text(), 'Log in')]");
    By INPUT_EMAIL = By.xpath("//input[@id='user']");
    By BTN_LOGIN = By.xpath("//input[@id='login']");
    By INPUT_PASSWORD = By.xpath("//input[@name='password']");
    By CONFIRM_PASSWORD_BTN = By.xpath("//button[@id='login-submit']");
    By TEXT_WORKSPACE_AFTER_LOGIN = By.xpath("//span[@data-testid='home-team-tab-name']");
    By TEXT_INCORRECT_PASSWORD = By.xpath("//div[@data-testid='form-error--content']/span/span");

    public void login(UserDTO userDTO){
        openLoginPage();
        enterEmailLogin(userDTO);
        clickContinueLogin();
    }

    public void openLoginPage(){
        click(OPEN_LOGIN_PAGE_BTN);
    }

    public void enterEmailLogin(UserDTO userDTO){
        type(INPUT_EMAIL, userDTO.getEmail());
    }

    public void clickContinueLogin(){
        click(BTN_LOGIN);
    }

    public void typePasswordLogin(UserDTO userDTO){
        type(INPUT_PASSWORD, userDTO.getPassword());
    }

    public void clickConfirmPasswordButton(){
        click(CONFIRM_PASSWORD_BTN);
    }

}
