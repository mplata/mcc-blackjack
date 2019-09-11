package com.techprogramming.games;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
	
	private Scanner scanner;
	private static ScannerUtil instance = null;
	
	private ScannerUtil() {
		this.scanner = new Scanner(System.in);
	}
	
	public static ScannerUtil getInstance() {
		if(instance == null) {
			instance = new ScannerUtil();
		}
		return instance;
	}
	
	
	public String getString(String errMessage) {
		String input = "";
		while(input.equals("")) {
			try {
				input = this.scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Error: "+errMessage);
				this.scanner.next();
				input = "";
			}
		}
		return input;
	}
	
	public int getInt(String errMessage){
		
		int input = -1;
		while(input == -1) {
			try {
				input = this.scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: "+errMessage);
				this.scanner.next();
				input = -1;
			}
		}
		return input;
	}
	
	public void waitForEnter() {
		System.out.println("Presione enter para continuar...");
		this.scanner.nextLine();
	}
	
}
