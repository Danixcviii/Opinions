package bussines;

import java.io.File;
import java.time.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import data.Opinion;

public class OpinionsManager {

	
	public void readOpinions() throws FileNotFoundException{
		Scanner sc=new Scanner(new File(Main.PATH_FOLDER+Main.OPINIONS));
			product=sc.nextLine().trim();
			sc.useDelimiter("\\s*&&\\s*");
		while(sc.hasNext()) {
			opinions.add(new Opinion(sc.next()));
		};
		startAndEndDate();
		sc.close();
	};
	
	public ArrayList<String> getComents() {
		ArrayList<String> coments=new ArrayList<String>();
		  for(Opinion opinion:opinions) {
			  coments.add(opinion.getComent());
		  };
		  
		return coments;
	}

	public void startAndEndDate() {
		TreeSet<LocalDate> dates=new TreeSet<LocalDate>();
		 for(Opinion opinion:opinions) {
			 dates.add(opinion.getDate());
		 };
		 startDate=dates.first();
		 endDate=dates.last();
	};
	
	
	public ArrayList<String> getOpinions() {
		ArrayList<String> buffer=new ArrayList<String>();
		for(Opinion opinion:opinions) {
			buffer.add(opinion.toString());
		};
		return buffer;
	}
	
	@Override
	public String toString() {
		return "Product: "+product+"\n"
				+ "No Opinions: "+opinions.size()+"\n"
				+ "Start Date: "+startDate.toString()+"\n"
				+ "End Date: "+endDate.toString()+"\n";
	}
	
	private String product=""; 
	private LocalDate startDat=LocalDate.now();
	private LocalDate endDate=LocalDate.now();
	private ArrayList<Opinion> opinions=new ArrayList<Opinion>();
}
