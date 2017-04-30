package com.chesspionage.model;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* RankAndFile represents the coordinate system in Chesspionage */
public class RankAndFile {
  //Fields
  private int rank; // aka row in chess terms
  private int file; // aka column in chess terms
  String rankAndFile; // coordinate in chess notation such as 'h7'
  public final Map<String, Integer> stringToInt = new HashMap<String, Integer>() {{
    put("a",0);
    put("b",1);
    put("c",2);
    put("d",3);
    put("e",4);
    put("f",5);
    put("g",6);
    put("h",7);
  }};
  public final Map<Integer, String> intToString = new HashMap<Integer, String>() {{
    put(0,"a");
    put(1,"b");
    put(2,"c");
    put(3,"d");
    put(4,"e");
    put(5,"f");
    put(6,"g");
    put(7,"h");
  }};


  //Constructors
  public RankAndFile(String rankAndFile){
    Pattern pattern = Pattern.compile("[a-h][1-8]");
    boolean validRankAndString = pattern.matcher(rankAndFile).matches();
    if(!validRankAndString) { throw new Error("Invalid String: " + rankAndFile); }
    this.rankAndFile = rankAndFile;
    String[] splitRankAndFile = Pattern.compile("").split(rankAndFile);
    rank = Integer.parseInt(splitRankAndFile[1])-1;
    file = stringToInt.get(splitRankAndFile[0]);

  }

  public RankAndFile(int rank, int file){
    if(!intToString.containsKey(rank) || !intToString.containsKey(file)){ throw new Error("Invalid rank or file: rank = " + rank + " file = " + file); }
    this.rank = rank;
    this.file = file;
    rankAndFile = intToString.get(file) + (rank+1);
  }

  //Methods
  public String getRankAndFile(){
    return rankAndFile;
  }

  public int getRank(){
    return rank;
  }

  public int getFile(){
    return file;
  }

  public void setRankAndFile(String rankAndFile){
    this.rankAndFile = rankAndFile;
  }

  public void setRank(int rank){
    this.rank = rank;
  }

  public void setFile(int file){ this.file = file; }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!RankAndFile.class.isAssignableFrom(obj.getClass())) {
      return false;
    }
    final RankAndFile other = (RankAndFile) obj;
    if ((this.rank == other.getRank()) && (this.file != other.getFile())) {
      return true;
    }
    return false;
  }
}
