package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReferencePath {

	
	public static String reportFolderPath =System.getProperty("user.dir")+File.separator+"Report"+File.separator;
	
	public static String reportName = "ANZ_Test"+new SimpleDateFormat("dd MMM YYYY EEEE hh.mm a").format(new Date())+".html";

}
