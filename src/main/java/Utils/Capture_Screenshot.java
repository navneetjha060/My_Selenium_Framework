package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseClass.BaseClass;

public class Capture_Screenshot extends BaseClass {

	public Capture_Screenshot() throws IOException {
		super();

	}

	public void captureScreenshot() throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("./Screenshot/Screenshot.png");

		FileUtils.copyFile(SrcFile, DestFile);

	}

}
