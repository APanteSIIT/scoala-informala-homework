package temaWeek12Enum.oneThreadVersion.Main;

import java.io.File;
import java.io.FilenameFilter;


public class FindFilesByExt implements FilenameFilter {
	
	
	private final String extension;
	
	private FindFilesByExt(String extension) {
		
		this.extension = extension;
	}
	
	@Override
	public boolean accept(File loc, String name) {
		if (name.lastIndexOf(".") > 0) {
			int lastIndex = name.lastIndexOf(".");
			String str = name.substring(lastIndex);
			if (extension.equalsIgnoreCase(str)) {
				return true;
			}
		}
		return false;
	}
	
	
}

