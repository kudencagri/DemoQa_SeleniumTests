import Utility.Elements;
import Utility.GWD;
import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests extends GWD {
    Elements elm=new Elements();
    MyFunc myFunc=new MyFunc();
    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    @Test
    public void ControlDemoQa(){
        GWD.getDriver().get("https://demoqa.com/");
        wait.until(ExpectedConditions.visibilityOf(elm.ToolsQA));
        Assert.assertTrue(elm.SecElements.isDisplayed());
    }



}
