/*
 * �������� 2011-10-28
 *
 * �����������ļ�ģ��Ϊ
 * ���� > ��ѡ�� > Java > �������� > �����ע��
 */
package com.example.untils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 *
 */
public class FtpUtil {

	private FTPClient ftp;
	
	private String path = null;
	
	//�ϴ��ļ�ʱtempPath��Ϊ�գ����Ƚ��ļ��ϴ�����ʱĿ¼��֮����rename��pathĿ¼
	private String tempPath = null;
	
	//Զ�̱���·��
	private String remoteBakDir = null;
	
	
	public String getRemoteBakDir() {
		return remoteBakDir;
	}

	public void setRemoteBakDir(String remoteBakDir) {
		this.remoteBakDir = remoteBakDir;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the tempPath
	 */
	public String getTempPath() {
		return tempPath;
	}

	/**
	 * @param tempPath the tempPath to set
	 */
	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public static FtpUtil connect(String host, String user, String pwd, String path) throws SocketException, IOException {
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.ftp = new FTPClient();
		ftpUtil.ftp.connect(host);
		ftpUtil.ftp.login(user, pwd);
		ftpUtil.ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftpUtil.ftp.changeWorkingDirectory(path);
		return ftpUtil;
	}
	
	/**
	 * ����·��
	 * @throws IOException
	 *
	 */
	public void changeDir(String dir) throws IOException {
		this.ftp.changeWorkingDirectory(dir);
	}
	/**
	 * �õ���ǰ·����ȫ���ļ���
	 * @throws IOException
	 *
	 */
	public String[] getFileNames() throws IOException {
		return this.ftp.listNames();
	}


	/**
	 * �õ��ļ���չ��
	 * @throws Exception
	 *
	 */
	public static String getFileExtName(String fileName){
		String fileExtName = "";
		if(fileName != null && fileName.lastIndexOf(".") != -1){
			fileExtName = fileName.substring(fileName.lastIndexOf("."),fileName.length());
		}
		return fileExtName;
	}

	/**
	 * �õ�ָ����չ�����ļ���
	 * @throws IOException
	 * @extName ��չ��,��ΪNULL��ȡȫ���ļ�
	 *
	 */
	public String[] getFileNames(String extName) throws IOException {
		List fileNameList = new ArrayList();
		String[] arr = this.ftp.listNames();
		if(arr == null || arr.length < 1){
			return null;
		}
		for(String fileName:arr){
			if(StringUtils.isNotEmpty(extName) && !getFileExtName(fileName).equals(extName)){
				continue;
			}
			fileNameList.add(fileName);
		}

		if(fileNameList.size() > 0 ){
			return (String[])fileNameList.toArray(new String[fileNameList.size()]);
		}

		return null;

	}
	

	
	/**
	 * �õ�ָ����չ�����ļ�
	 * @extName ��չ��
	 * @localDir ���ش���ļ�·��
	 * @isDel  �Ƿ�ɾ��FTP�ϵ��ļ�
	 * @throws IOException
	 * @extName ��չ��,��ΪNULL��ȡȫ���ļ� 
	 *
	 */
	public List<File> downloadFiles(String extName, String localDir, boolean isDel) throws IOException {
		List<File> fileList = new ArrayList<File>();
		String[] fileNames = this.getFileNames(extName);
		if(fileNames != null){
			for (String fileName:fileNames) {
				fileList.add(this.downloadFile(fileName, localDir));
				if(isDel){
					//ɾ��FTP�ϵ��ļ�
					this.deleteFile(fileName);
				}
			}
		}
		 
		return fileList;
		
	}
	
	/**
	 * ����������ʽ�õ��ļ�
	 * @regExp    ������ʽ
	 * @localDir ���ش���ļ�·��
	 * @isDel  �Ƿ�ɾ��FTP�ϵ��ļ�
	 * @throws IOException
	 * @extName ��չ��,��ΪNULL��ȡȫ���ļ� 
	 *
	 */
	public List<File> downloadFilesForRegExp(String regExp, String localDir, boolean isDel) throws IOException {
		List<File> fileList = new ArrayList<File>();
		String[] fileNames = this.getRegFileNames(regExp);
		if(fileNames != null && fileNames.length > 0){
			for (String fileName:fileNames) {
				fileList.add(this.downloadFile(fileName, localDir));
				if(isDel){
					//ɾ��FTP�ϵ��ļ�
					this.deleteFile(fileName);
				}
			}
		}
		 
		return fileList;
		
	}
	
	/**
	 * ����������ʽ�õ��ļ�
	 * @regExp    ������ʽ
	 * @localDir ���ش���ļ�·��
	 * @flag  1:ɾ��Զ���ļ� 2:����Զ���ļ�
	 * @throws IOException
	 * @extName ��չ��,��ΪNULL��ȡȫ���ļ� 
	 *
	 */
	public List<File> downloadFilesForRegExp(String regExp, String localDir, String flag) throws IOException {
		List<File> fileList = new ArrayList<File>();
		String[] fileNames = this.getRegFileNames(regExp);
		if(fileNames != null && fileNames.length > 0){
			for (String fileName:fileNames) {
				fileList.add(this.downloadFile(fileName, localDir));
				if("1".equals(flag)){
					//ɾ��FTP�ϵ��ļ�
					this.deleteFile(fileName);
				} else if("2".equals(flag)) {
					//����FTP�ϵ��ļ�
					if(StringUtils.isNotEmpty(this.getRemoteBakDir())) {
						this.rename(fileName, this.getRemoteBakDir() + fileName);
					} else {
						this.deleteFile(fileName);
					}
				}
			}
		}
		 
		return fileList;
		
	}
	
	/**
	 * ����������ʽ���ļ���
	 * @throws IOException
	 * @extName ��չ��,��ΪNULL��ȡȫ���ļ�
	 *
	 */
	public String[] getRegFileNames(String regExp) throws IOException {
		List fileNameList = new ArrayList();
		String[] arr = this.ftp.listNames();
		if(arr == null || arr.length < 1){
			return null;
		}
		for(String fileName:arr){
			if(StringUtils.isNotEmpty(regExp) && !fileName.matches(regExp)){
				continue;
			}
			fileNameList.add(fileName);
		}
		
		if(fileNameList.size() > 0 ){
			return (String[])fileNameList.toArray(new String[fileNameList.size()]);
		}
		
		return null;
		
	}
	/**
	 * �����ļ���ָ��·����
	 * @localDir ����·��
	 * @throws IOException
	 */
	public File downloadFile(String fileName, String localDir) throws IOException {
		File tmpfile = new File(localDir+fileName);
		FileOutputStream fos = new FileOutputStream(tmpfile);
		this.ftp.retrieveFile(fileName, fos);
		fos.close();
		return tmpfile;
	}
	
	/**
	 * ɾ���ļ�
	 * @throws IOException
	 * @fileName Ҫɾ�����ļ���
	 *
	 */
	public void deleteFile(String fileName) throws IOException {
		this.ftp.deleteFile(fileName);
	}
	
	/**
	 * �Ͽ�����
	 * @throws Exception
	 *
	 */
	public void disconnect(){
		try {
			if(null != this.ftp){
				this.ftp.logout();
				this.ftp.disconnect();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean uploadFile(File file, String fileName){
		FileInputStream fis = null;
		boolean flag = false;
		try{
			fis = new FileInputStream(file);
			this.ftp.storeFile(fileName,fis);
			
			if(StringUtils.isNotEmpty(this.getTempPath())) {
				this.rename(fileName, this.path + fileName);
			}
			flag = true;
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public boolean rename(String from, String to) {
		try {
			return this.ftp.rename(from, to);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void uploadFile(List<File> files){
		for(File file:files){
			this.uploadFile(file, file.getName());
		}
	}
	
	public static void main(String[] args) {
//		try {
//			FtpUtil ftp = FtpUtil.connect("10.7.95.70","","","/home/bgusr01/payment/ocs2billing/bak/");
//			ftp.setRemoteBakDir("/home/bgusr01/payment/ocs2billing/config/");
//			ftp.downloadFilesForRegExp(".*", "D:/test/", "2");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
//			FtpUtil ftp = FtpUtil.connect("10.7.95.70","bgusr01","lc#v58iHH",
//					"/home/bgusr01/vip_backend/test");


			//��Ѷ�Ʒ����� ftp
            FtpUtil ftp = FtpUtil.connect("106.54.46.37","ftpuser","cld7758258",
                    "/home/ftpuser/ll");

//			ftp.downloadFile("22.txt","C:\\Users\\Admin\\Desktop\\����\\logs\\");

			File file = new File("D:\\7.txt");
			ftp.uploadFile(file,"7.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
