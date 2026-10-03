package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName, String browser) {

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destination = new File(
                "screenshots/" + testName + "-" + browser + ".png"
        );

        try {

            Files.createDirectories(
                    destination.getParentFile().toPath()
            );

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );

            return destination.getAbsolutePath();

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }
}