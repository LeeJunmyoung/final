package cloud.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Cloud_makeZipFile {
	public String makeZipFile(List info) throws Exception {
			String[] files = new String[(info.size() / 2)];
			String zipName =  MakeTempPath();
			try{
			System.out.println("zipfile 로 들어옴");
			ZipOutputStream out =  new ZipOutputStream(new FileOutputStream(zipName));
			byte[] buf = new byte[1024];
			System.out.println("포문 들어감2");
			for(int i = 0;i < files.length;i++){
				System.out.println("들어간다::"+(String)info.get(i*2));
				FileInputStream fis =  new FileInputStream((String)info.get(i*2));
				out.putNextEntry(new ZipEntry((String)info.get(i*2)));
			    int len;
	              while ((len = fis.read(buf)) > 0) {
	                  out.write(buf, 0, len);
	              }
	              out.closeEntry();
	              fis.close();
	              
			}
			out.close();
			} catch(IOException e){
				e.printStackTrace();
			}
			return zipName;
			
	}
	private String MakeTempPath() {
		String temp_path = "";
		Long nowtime = System.currentTimeMillis();
		String timepath = String.valueOf(nowtime);

		for (int i = 0; i < 20; i++) {
			int r = (int) (Math.random() * 100);
			String str = null;
			if (r <= 25) {
				str = String.valueOf((char) (int) (Math.random() * 10 + 48));
			} else if (r <= 60) {
				str = String.valueOf((char) (int) (Math.random() * 26 + 65));
			} else {
				str = String.valueOf((char) (int) (Math.random() * 26 + 97));
			}
			temp_path += str;
		}
		String file_path = "D:/cloud/" + temp_path + timepath + ".zip";
		return file_path;
	}

}
