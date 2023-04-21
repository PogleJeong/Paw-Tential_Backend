package mul.cam.a.group.util;

import java.util.Date;

public class FileUtil {
	public static String getNewFileName(String filename) {
		String newfilename = "";
		String fpost = "";
		
		if(filename.indexOf('.') >= 0 ) {	// 확장자명이 있을 때
			fpost = filename.substring(filename.indexOf('.'));
			newfilename = new Date().getTime() + fpost;
		}else {	// 확장자명이 없을 때
			newfilename = new Date().getTime() + ".back";
		}
		return newfilename;
	}

}
