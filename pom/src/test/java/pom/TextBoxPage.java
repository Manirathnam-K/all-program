package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;

    public TextBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String name) {
        userName.sendKeys(name);
    }

    public void enterUserEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void clickSubmit() {
        submitButton.click();
    } 
}


