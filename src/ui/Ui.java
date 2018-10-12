package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

	public Ui() {
		try {
			readMainMenu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void readMainMenu() throws FileNotFoundException {
		Scanner sc=new Scanner(new File(UIDATA));
		 sc.useDelimiter("\\s*&&\\s*");
		 mainMenu=sc.next();
		 basInfoHeader=sc.next();
		 opiniHeader=sc.next();
		 resultsHeader=sc.next();
		 altMenu=sc.next();
		sc.close();
	};
	
	public void displayMainMenu() {
		System.out.println(mainMenu);
	};
	
	public void displayBasicInfo(String basicInfo) {
		System.out.println(basInfoHeader);
		System.out.println(basicInfo);
	    System.out.println(altMenu);
	};
	
	public void displayOpinions(ArrayList<String> opinions) {
		System.out.println(opiniHeader);
		for(String opinion:opinions) {
			System.out.println(opinion);
		};
		System.out.println(altMenu);
	};

	public void displayResults(String results) {
		System.out.println(resultsHeader);
		System.out.println(results);
		System.out.println(altMenu);
	};
	
	public void displayHelp(String help) {
		System.out.println(help);
		System.out.println(altMenu);
	};

    
	
	private String mainMenu,altMenu,basInfoHeader,opiniHeader,resultsHeader;
	public static final String UIDATA="src/ui/uidata";
	
}
