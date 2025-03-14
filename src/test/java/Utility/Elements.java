package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    public Elements(){PageFactory.initElements(GWD.getDriver(), this);}

    @FindBy(xpath = "")
    private WebElement login;

    public WebElement getWebElement(String string){
        switch (string){
            case "login"                          :return this.login;
        }
        return null;
    }
}
