package mul.cam.a.util;

import java.util.Date;

public class FileUtil {
	public static String getNewFileName(String filename) {
		
		String newfilename = ""; // 새 파일명을 저장할 변수
		String fpost = ""; // 확장자명을 제외한 파일명
		
		if(filename.indexOf('.')>=0) { // 확장자명이 있음
			fpost = filename.substring(filename.indexOf('.')); // 확장자명을 분리하여 DB에 저장함.
			newfilename = new Date().getTime() + fpost;
			
		} else { // 확장자명이 없음
			newfilename = new Date().getTime() + ".back";
		}
		return newfilename;
	}
}
