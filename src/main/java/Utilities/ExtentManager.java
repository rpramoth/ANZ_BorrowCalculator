package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if(extent==null)
			createInstance();
		return extent;
	}


	public static ExtentReports createInstance() {

		String fileName = getReportPath (ReferencePath.reportFolderPath) + File.separator + ReferencePath.reportName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle (ReferencePath.reportName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName (ReferencePath.reportName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
		
	}

		private static String getReportPath (String path) {

			File testDirectory = new File(path);

			if (!testDirectory.exists()) {
				if (testDirectory.mkdir()) {
					System.out.println("Directory: + path + is created!" );
					return ReferencePath.reportFolderPath;
				} else {
					System.out.println("Failed to create directory:" + path);
					return System.getProperty("user.dir");
				}

			} else {
				System.out.println("Directory already exists:" + path);
			}
			return ReferencePath.reportFolderPath;

		}
}
