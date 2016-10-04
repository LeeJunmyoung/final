package cloud.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import cloud.db.CloudInfo;

public class Cloud_downloadFile extends AbstractView {
	public Cloud_downloadFile() {
		setContentType("application/download; charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List info = (List) model.get("downloadInfo");
		String file_name = null;
		File file = null;
		int toZip = 0;
		if (info.size() > 3) {
			Cloud_makeZipFile zipfile = new Cloud_makeZipFile();
			file_name = zipfile.makeZipFile(info);
			file = new File(file_name);
			response.setContentLength((int) file.length());
			toZip = 1;
		} else {

			String file_path = (String) info.get(0);
			file = new File(file_path);
			response.setContentLength((int) file.length());
			file_name = (String) info.get(1);
		}
		response.setHeader("Content-Disposition", "attatchment; filename = " + file_name);
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if (toZip == 1) {
				file.delete();
			}
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			out.flush();
		}

	}
}
