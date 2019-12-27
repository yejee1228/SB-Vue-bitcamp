package com.hanrabong.web.proxy;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("filemgr")
public class FileProxy extends Proxy{
	@Autowired GenProxy gen;
	public void fileUpload(MultipartFile[] uploadFile) {
		String uploadFolder = ".";
		File uploadPath = gen.makeDir(uploadFolder,getFolder());
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		for(MultipartFile m : uploadFile) {
			String fname= m.getOriginalFilename();
			String extension = fname.substring(fname.lastIndexOf(".")+1);
			fname = fname.substring(fname.lastIndexOf("\\")+1, fname.lastIndexOf("."));
			File saveFile = gen.makeFile(uploadPath, fname+UUID.randomUUID().toString() +"."+extension);
			try {
				m.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String getFolder() {
		return currentDate().replace("-", File.separator);
	}
}