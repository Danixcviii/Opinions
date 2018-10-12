package bussines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tokenizer {

	@Override
	public String toString() {
		String tokenizer="";
		for(String word:lexicon.keySet()) {
			tokenizer+=word+":......["+lexicon.get(word)+"]\n";
		};
		tokenizer+="Words: "+lexicon.size();
		return tokenizer;
	}
	
	public void readStopWords() throws FileNotFoundException {
	 Scanner sc=new Scanner(new File(Main.PATH_FOLDER+Main.STOP_WORDS)); 
	 while(sc.hasNext()) {
		   stopWords.add(sc.next().trim().toLowerCase());
	   };
	  sc.close();
	};
	

	
	public void addToLexicon(String coment) {
	 Scanner sc=new Scanner(coment);
	  sc.useDelimiter("[^A-Za-z]");
	  while(sc.hasNext()) {
		 String word=sc.next().toLowerCase().trim();
		 if(!word.isEmpty()) {
			 if(!stopWords.contains(word)){
				  int count=0;
				 if(lexicon.containsKey(word)) {
					count=lexicon.get(word); 
				 };
				 count++;
				 lexicon.put(word, count);
			  }; 
		 }; 
	  };
	 sc.close();
	};

	
	private TreeMap<String,Integer> lexicon=new TreeMap<String,Integer>();
	private TreeSet<String> stopWords=new TreeSet<String>();
}
