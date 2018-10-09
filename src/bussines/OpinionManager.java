package bussines;

import java.time.LocalDate;
import java.util.ArrayList;
import data.Opinion;
import java.util.Scanner;
import java.io.File;

public class OpinionManager{
 
  private String product;
  private LocalDate startDate;
  private LocalDate endDate;
  private ArrayList<Opinion> opinions=new ArrayList<opinion>();
  
  public void readOpinions(String filePath){
   Scanner sc=new Scanner(new File(filePath));
    sc.useDelimiter("\\s*&&\\s*");
    while(sc.hasNext()){
     opinions.add(new Opinion(sc.next()));
    }
    sc.close();
  }
 
}
