package cloud.db;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.multipart.MultipartFile;

import promgr.db.PromgrDataBean;

public class CloudDao extends SqlSessionDaoSupport {

	public List<CloudInfo> getcloudList(int com_num, String folder) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("com_num", com_num);
		param.put("folder", folder);
		List cloudlist = new ArrayList<CloudInfo>();
		cloudlist = getSqlSession().selectList("cloud.getcloudlist", param);

		return cloudlist;
	}

	public void uploadFile(CloudInfo info) {
		getSqlSession().insert("cloud.upload", info);
		
		// promgr file_num add
		if(info.getFolder()!= ""){
			if(info.getPromgr_num() > 0){
			String promgr_num = String.valueOf(info.getPromgr_num());
			setFileNum(promgr_num);
			}
		}
	}

	private void setFileNum(String promgr_num) {
		String new_file_num = getSqlSession().selectList("promgr.new_file_num", promgr_num).get(0).toString();
		
		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		String old_file_num = promgr.getFile_num();

		String file_num_str = "";

		if (old_file_num == null) {
			file_num_str = new_file_num;
		} else {
			file_num_str = old_file_num + "/" + new_file_num;
		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("file_num_str", file_num_str);
		map.put("promgr_num", promgr_num);

		getSqlSession().update("promgr.set_file_num", map);
		
	}
	
	public List getFileInfo(String[] fileNums) {
		List downloadinfo = new ArrayList();
		for (int i = 0; i < fileNums.length; i++) {
			int file_num = Integer.parseInt(fileNums[i]);
			String file_path = getSqlSession().selectOne("cloud.getFilePath", file_num);
			downloadinfo.add(file_path);
			String file_name = getSqlSession().selectOne("cloud.getFileName", file_num);
			downloadinfo.add(file_name);
		}
		return downloadinfo;
	}

	public List<CloudInfo> getDeleteList(String[] fileNums) {
		List deleteInfo = new ArrayList<CloudInfo>();
		deleteInfo = getSqlSession().selectList("cloud.getDeleteList", fileNums);
		/* System.out.println(deleteInfo); */
		return deleteInfo;
	}

	public void DeleteFiles(int[] file_num) {
		getSqlSession().delete("cloud.deleteFiles", file_num);
	}

	public String duplicateCheck(String item, String folder, int com_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item", item);
		map.put("folder", folder);
		map.put("com_num", com_num);
		String dupli = getSqlSession().selectOne("cloud.dupliCk", map);
		return dupli;
	}

	public String findUpper(String folder) {
		String upperFolder = getSqlSession().selectOne("cloud.findUpper", folder);
		return upperFolder;
	}

	public String getFilePath(int promgr_num, String folder, HttpServletRequest request) {
		int com_num = (int) request.getSession().getAttribute("com_num");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("com_num", com_num);
		map.put("promgr_num", promgr_num);
		map.put("file_name", folder);
		String folderPath = getSqlSession().selectOne("cloud.getFolderPath", map);
		return folderPath;
	}

	public String promgrDuplick(int promgr_num, String folder, HttpServletRequest request) {
		int com_num = (int) request.getSession().getAttribute("com_num");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("com_num", com_num);
		map.put("promgr_num", promgr_num);
		map.put("item", folder);
		String duplick = getSqlSession().selectOne("cloud.dupliCk", map);
		return duplick;
	}

	public int changeFileName(String file_num, String file_name) {
		// 중복체크 1차 쿼리
		int numinfo = Integer.parseInt(file_num);
		Map<String, Object> info = getSqlSession().selectOne("cloud.getdupliInfo", numinfo);
		// 중복체크 2차 쿼리
		Map<String, Object> changeMap = new HashMap<String, Object>();
		changeMap.put("folder", info.get("FOLDER"));
		changeMap.put("com_num", info.get("COM_NUM"));
		changeMap.put("item", file_name);
		String dupli = getSqlSession().selectOne("cloud.dupliCk", changeMap);
		int i = Integer.parseInt(dupli);
		if (i > 0)
			return i;
		// 이픔 바꾸는 쿼리
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("file_num", file_num);
		map.put("file_name", file_name);
		getSqlSession().update("cloud.changeFileName", map);
		return i;
	}
	
	public String getPromgr_folder(int promgr_num){
		String folder = getSqlSession().selectOne("cloud.find_promgr_folder", promgr_num);
		return folder;
	}
}