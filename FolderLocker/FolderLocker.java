package com.app.CodeClause;
import java.util.Scanner;
import java.io.*;

public class FolderLocker {
	private static final String LOCK_FILE_NAME = ".locked";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the folder path to lock/unlock");
		String folderPath = sc.nextLine();
		
		System.out.println("Enter a Password");
		String Password = sc.nextLine();
		
		File folder = new File(folderPath);
		File lockFile = new File(folder,  LOCK_FILE_NAME);
		
		if( !lockFile.exists()) {
			lockFolder(folder,Password );
			System.out.println("Folder locked successfully");	
		}else {		
			System.out.println("Enter the Paasword to Unlock the Folder: ");
			String enteredPasword = sc.nextLine();			
		}
	}

	public static void lockFolder(File folder, String password) {
		// TODO Auto-generated method stub
		File lockFile = new File(folder , LOCK_FILE_NAME );
		try {
			lockFile.createNewFile();
		}catch( IOException e) {
			e.printStackTrace();
		}
		
		
		File[] files = folder.listFiles();
		if( files != null ) {
			for( File file : files ) {
				if( file.isFile()) {
					//File Encryption
				}
			}
		}	
	}
	public static void unlockFolder( File folder ) {
		File lockFile = new File(folder , LOCK_FILE_NAME );
		lockFile.delete();
		
		File[] files = folder.listFiles();
		if( files != null ) {
			for( File file : files ) {
				if( file.isFile()) {
					//File Decryption
				}
			}
			
			
		}
	}
	
	

}

