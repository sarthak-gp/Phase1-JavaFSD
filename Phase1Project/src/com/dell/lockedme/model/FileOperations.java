package com.dell.lockedme.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;



public class FileOperations {
	
	public static boolean AddUser() {
		Map<String, String> cred = new HashMap<String, String>();
		System.out.println("Please enter Username: \n");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Please enter Password: \n");
		String password = sc.nextLine();
		cred.put(name,password);
		try {
		      FileWriter fs = new FileWriter(Constants.fileName,true);
		      BufferedWriter bw = new BufferedWriter(fs);
	          for (Map.Entry<String, String> entry :
	                 cred.entrySet()) {
	  
	                // put key and value separated by a colon
	                bw.write(entry.getKey() + ":"
	                         + entry.getValue());
	  
	                // new line
	                bw.newLine();
	            }
	          bw.close();
		      sc.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred. "+e.getMessage());
		    }
		return false;
	}
	public static boolean DeleteUserName() {
		System.out.println("Please enter User name to delete: \n");
		Scanner sc = new Scanner(System.in);
		
		try {
			Path path = Paths.get(Constants.fileName);
			Charset charset = StandardCharsets.UTF_8;

			String content = new String(Files.readAllBytes(path), charset);
			String userDel = sc.nextLine();
			if(content.contains(userDel)) {
			
			content = content.replaceAll(userDel, "");
			Files.write(path, content.getBytes(charset));
			System.out.println("User '"+userDel +"' deleted successfully \n");
			} else {
				System.out.println("\n User not found \n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occurred. "+e.getMessage());
		}
		sc.close();
		return false;
	}

	public static boolean SearchUser() {
		System.out.println("Please enter User name to Search : \n");
		Scanner sc = new Scanner(System.in);
		
		try {
			Path path = Paths.get(Constants.fileName);
			Charset charset = StandardCharsets.UTF_8;

			String content = new String(Files.readAllBytes(path), charset);
			String userCheck = sc.nextLine();
			if(content.contains(userCheck)) {			
			System.out.println("User '"+userCheck +"' found successfully \n");
			} else {
				System.out.println("\n User not found \n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occurred. "+e.getMessage());
		}
		sc.close();
		return false;
	}
	public static boolean ListallUsers() {
		// TODO Auto-generated method stub
		System.out.println("List of Users in ascending order: \n");
		
		try {		
			FileReader fr = new FileReader(Constants.fileName);
			BufferedReader reader = new BufferedReader(fr);
			ArrayList<String> str = new ArrayList<>();
			String line = "";
			while((line=reader.readLine())!=null){
				str.add(line);
			}
			Collections.sort(str);
			for(String s:str)
			System.out.println(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occured while reading the file - " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occured while reading the file");
		}
		return false;
	}
}
