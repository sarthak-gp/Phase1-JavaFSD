package com.dell.lockedme.application;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


import com.dell.lockedme.model.FileOperations;

public class Login {
	


	public static void welcomeScreen() {
		
		System.out.println("---------------------------------------------");
		System.out.println("*					*");
		System.out.println("*   Welcome To LockedMe.com		            *");
		System.out.println("*                From Sarthak Panda	            *");
		System.out.println("*					*");
		System.out.println("----------------------------------------------");
		
		
	}
	public static void exitScreen() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------");
		System.out.println("*					*");
		System.out.println("*   Thanks for Visiting LockedMe.com		*");
		System.out.println("*					*");
		System.out.println("----------------------------------------------");
		
	}
	
	public static void optionsMenu(){
		System.out.println("Please select any of the below choices");
		System.out.println("1. Show all users");
		System.out.println("2. Register/Delete/search a user");
		System.out.println("3. Exit the application");
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		boolean flag = true;
		
		while(flag) {
			switch(input) {
			case 1 : 
				flag = FileOperations.ListallUsers();	
				exitScreen();
				break;
			case 2 :
				System.out.println("Please select any choice from the below list");
				System.out.println("1. Add User ");
				System.out.println("2. Delete User");
				System.out.println("3. Search User");
				input = sc.nextInt();
				switch(input) {
				case 1 : 
					flag = FileOperations.AddUser();
					exitScreen();
					break;
				case 2 :
					flag = FileOperations.DeleteUserName();	
					exitScreen();
					break;
				case 3 :
					flag = FileOperations.SearchUser();
					exitScreen();
					break;
				default :
					System.out.println("Please select valid choice from the below list");
					System.out.println("1. Add User ");
					System.out.println("2. Delete User");
					System.out.println("3. Search User");
					input = sc.nextInt();
					break;
				}									
				break;
			case 3 :
				flag = false;
				exitScreen();
				break;
			default :
				System.out.println("Please select valid choice from the below list");
				System.out.println("1. Show all users");
				System.out.println("2. Register/Delete a user");
				System.out.println("3. Exit the application");
				input = sc.nextInt();
				flag = true;
			}		
		}
		sc.close();		
	}	

		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		welcomeScreen();
		optionsMenu();

	}

}
