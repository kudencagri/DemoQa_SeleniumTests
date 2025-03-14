package Utility;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;



import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Utility.GWD.quitDriver;

public class Hooks {
    @BeforeMethod
    public void before(){

    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        System.out.println("Test Durumu: " + result.getStatus());

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Hata oldu");

            // Ekran görüntüsünü al
            TakesScreenshot ts = (TakesScreenshot) GWD.getDriver(); // WebDriver'ı TakesScreenshot'a dönüştür
            File screenshot = ts.getScreenshotAs(OutputType.FILE); // Ekran görüntüsünü al

            // Zaman damgası formatını belirle
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            // Ekran görüntüsünü kaydedeceğimiz klasörün yolu
            String screenshotDirectory = "screenshots/";

            // Klasörün varlığını kontrol et ve yoksa oluştur
            File dir = new File(screenshotDirectory);
            if (!dir.exists()) {
                dir.mkdirs(); // Klasör yoksa oluştur
            }

            // Dosya yolu ve adını zaman damgası ekleyerek oluştur
            FileUtils.copyFile(screenshot, new File(screenshotDirectory + "screenshot_" + timestamp + ".png"));
        }

        // WebDriver'ı kapat
        quitDriver();
    }
}
