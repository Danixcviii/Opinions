package data;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Opinion {

	
	public Opinion(String line) {
	 Scanner sc=new Scanner(line);
	  author=sc.nextLine();
	  stars=Integer.parseInt(sc.nextLine().trim());
	  date=readDate(sc.nextLine());
	  while(sc.hasNextLine()) {
		  coment+=sc.nextLine()+" ";
	  };
		sc.close();
	};
	
	public String getComent() {
		return coment;
	};
	
	public LocalDate getDate() {
		return date;
	};
	
	public LocalDate readDate(String dateLine) {
		Scanner sc=new Scanner(dateLine);
		 sc.useDelimiter(",");
		 String buffer=sc.next();
		 int year=Integer.parseInt(sc.next().trim());
		 sc.close();
		 Scanner scBuffer=new Scanner(buffer);
		 Month month=readSpanishMonth(scBuffer.next().trim());
		 int dayOfMonth=scBuffer.nextInt();
		 scBuffer.close();
		 LocalDate date=LocalDate.of(year, month, dayOfMonth);
		return date;
	};
	
	public Month readSpanishMonth(String month) {
		String buffer=month.toUpperCase();
		 switch(buffer) {
		 case "ENERO": return Month.JANUARY;
		 case "FEBRERO": return Month.FEBRUARY;
		 case "MARZO": return Month.MARCH;
		 case "ABRIL": return Month.APRIL;
		 case "MAYO": return Month.MAY;
		 case "JUNIO": return Month.JUNE;
		 case "JULIO": return Month.JULY;
		 case "AGOSTO": return Month.AUGUST;
		 case "SEPTIEMBRE": return Month.SEPTEMBER;
		 case "OCTUBRE": return Month.OCTOBER;
		 case "NOVIEMBRE": return Month.NOVEMBER;
		 case "DICIEMBRE": return Month.DECEMBER;
		 };
		return Month.valueOf(buffer);
	};
	
	@Override
	public String toString() {
		String opinion="";
		 opinion+="Author: "+author+"\n";
		 opinion+="Stars: "+stars+"\n";
		 opinion+="Date: "+date.toString()+"\n";
		 opinion+="Coment: "+coment;
		return opinion;
	};
	
	private String author="";
	private int stars=0;
	private LocalDate date=LocalDate.now();
	private String coment="";

}
