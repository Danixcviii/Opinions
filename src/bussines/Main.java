package bussines;

import java.io.*;
import ui.*;
import java.util.*;


public class Main {
 
	public static void main(String[] args) {
	  try {
	  Main m=new Main();
		m.start();
	  } catch (FileNotFoundException e) {
		System.out.println("404 Files not Founds!!");
	  }
	}
	
	public void start() throws FileNotFoundException {
		tokenizer.readStopWords();
		opinionsManager.readOpinions();
		for(String coment:opinionsManager.getComents()) {
			tokenizer.addToLexicon(coment);
		};
		ui.displayMainMenu();
		mainMenu();
	};
	
	private void mainMenu() {
		Scanner sc=new Scanner(System.in);
		try {
			int op=sc.nextInt();
			switch(op) {
			case 1:
				ui.displayBasicInfo(opinionsManager.toString());
				altMenu();
				break;
			case 2:
				ui.displayOpinions(opinionsManager.getOpinions());
				altMenu();
				break;
			case 3:
				ui.displayResults(tokenizer.toString());
				altMenu();
			case 4:
				ui.displayHelp(getHelp());
				altMenu();
			case 5:
				exit();
				break;
			case 101:
				System.out.println("Easter Egg: defend the public education!! ");
				mainMenu();
				break;
				default:
					System.out.println("Please select an option in the list");
					mainMenu();
				break;
			}
		}catch(Exception e) {
			System.out.println("Invalid option!!");
			mainMenu();
		}
		sc.close();
	};
	
	private void altMenu() {
		Scanner sc=new Scanner(System.in);
		try {
		 int op=sc.nextInt();
		  switch(op) {
		  case 1:
			  ui.displayMainMenu();
			  mainMenu();
			  break;
		  case 2:
			  exit();
			  break;
			  default:
				  System.out.println("Please select an option in the list");
				  altMenu();
		  }
		}catch(Exception e) {
			System.out.println("Invalid Option!!");
			altMenu();
		}
		sc.close();
	};
	
	private void exit() {
		System.out.println("Clossing...");
		System.out.println("Closed");
		System.exit(0);
	};
	
	public String getHelp(){
		try {
			Scanner sc=new Scanner(new File(README));
			sc.useDelimiter("\\s*&&\\s*");
			String buffer=sc.next();
			sc.close();
			return buffer;
		} catch (FileNotFoundException e) {
		 System.out.println("Readme not found, be sure that the README.md file is in a main folder");
		}
	  return "Error 404 Readme not found";
	};
	
	private Ui ui=new Ui();
	private OpinionsManager opinionsManager=new OpinionsManager();
	private Tokenizer tokenizer=new Tokenizer();
	
	public static final String PATH_FOLDER="src/data/";
	public static final String OPINIONS="opinions";
	public static final String STOP_WORDS="stopWords";
	public static final String README="README.md";
}
