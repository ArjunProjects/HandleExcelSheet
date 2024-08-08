package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Base {
	
	public FileInputStream getFilePath() throws FileNotFoundException {
		String path = System.getProperty("user.dir")+"//Files//tutorial_data.xlsx";
		File f = new File(path);
		FileInputStream fos = new FileInputStream(f);
		return fos;
	}

}
