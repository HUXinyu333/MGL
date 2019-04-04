package romain;
import java.util.HashMap;

public class Romain{

  public int convertS(String romanNumber){
    if(romanNumber==null||romanNumber.length()==0)
      return -1;
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    map.put('C',100);
    map.put('D',500);
    map.put('M',1000);
    int len=romanNumber.length(), result=map.get(romanNumber.charAt(len-1));
    for(int i=len-2;i>=0;i--){
      if(map.get(romanNumber.charAt(i))>=map.get(romanNumber.charAt(i+1)))
        result+=map.get(romanNumber.charAt(i));
      else
        result-=map.get(romanNumber.charAt(i));
    }
    return result;
  }

  public String convertI(int num){
    int[] ints=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] romans=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    StringBuilder sb=new StringBuilder();
    int index=0;
    while(num>0){
      if(num-ints[index]>=0){
        num-=ints[index];
        sb.append(romans[index]);
      }
      else
        index++;
    }
    return sb.toString();
  }
}
