package com.chesspionage.model;

import java.text.ParseException;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Raymond on 4/30/17.
 */
public class RankAndFile {
  //Fields
  private int rank;
  private int file;
  String rankAndFile;
  private Map<String, Integer> stringToInt;
  private Map<Integer, String> intToString;


  //Constructors
  private RankAndFile(){
    stringToInt.put("a",0);
    stringToInt.put("b",1);
    stringToInt.put("c",2);
    stringToInt.put("d",3);
    stringToInt.put("e",4);
    stringToInt.put("f",5);
    stringToInt.put("g",6);
    stringToInt.put("h",7);

    intToString.put(0,"a");
    intToString.put(1,"b");
    intToString.put(2,"c");
    intToString.put(3,"d");
    intToString.put(4,"e");
    intToString.put(5,"f");
    intToString.put(6,"g");
    intToString.put(7,"h");
  }

  public RankAndFile(String rankAndFile){
    Pattern pattern = Pattern.compile("[a-h][1-8]");
    boolean validRankAndString = pattern.matcher(rankAndFile).matches();
    if(!validRankAndString) { throw new Error("Invalid String"); }
    this.rankAndFile = rankAndFile;
    String[] splitRankAndFile = Pattern.compile("").split(rankAndFile);
    rank = Integer.parseInt(splitRankAndFile[1])-1;
    file = stringToInt.get(splitRankAndFile[0]);

  }

  public RankAndFile(int rank, int file){
    if(!intToString.containsKey(rank) || !intToString.containsKey(file)){ throw new Error("Invalid rank or file"); }
    this.rank = rank;
    this.file = file;
    rankAndFile = intToString.get(file) + rank;
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


}
