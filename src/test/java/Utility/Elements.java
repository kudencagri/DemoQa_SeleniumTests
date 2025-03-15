package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    public Elements(){PageFactory.initElements(GWD.getDriver(), this);}

    @FindBy(xpath = "//img[@src='/images/Toolsqa.jpg']")
    public WebElement ToolsQA;
    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']']")
    public WebElement SecElements;


}
