package data;

import java.time.LocalDate;
import java.util.Scanner;
import java.lang.Integer;

public class Opinion{
  private String author;
  private int starts;
  private LocalDate date;
  private String text;
  
  public Opinion(String line){
   Scanner sc=new Scanner(line);
    author=sc.nextLine().trim();
    starts=Integer.parseInt(sc.nextLine().trim());
    sc.close();
  }
 
}
