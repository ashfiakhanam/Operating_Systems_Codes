import java.io.*;
import java.util.*;
import static java.lang.System.out;


public class BankersAlgorithm{
  public static void main(String[] args) throws Exception{

    BufferedReader b = new BufferedReader(new FileReader("input.txt"));    
    int row = Integer.parseInt(b.readLine());
    int column = Integer.parseInt(b.readLine());   

    String[] process = new String[row];
    int [][] max = new int[row][column];
    int [][] allocation = new int[row][column];
    int [][] need = new int[row][column];
    int [][] available = new int[row+1][column];

    LinkedList<Integer> track = new LinkedList<Integer>();
    
    String s3 = "";
    char[] names = new char[row];

    for(int i = 0; i < row; i++) {
        names[i] = (char)(65 + i);
        s3 = s3 + " " + names[i];
    }
    
    StringTokenizer st3 = new StringTokenizer(s3, " ");    
    int n = 0; 

    while(st3.hasMoreTokens()) {
      process[n] = st3.nextToken();
      n++;
    }
    
    for(int i = 0; i < row; i++) {
      String s = b.readLine();
      StringTokenizer st = new StringTokenizer(s, " ");      
      for(int j = 0; j < column; j++) {
        max[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for(int i = 0; i < row; i++) {
      String s = b.readLine();
      StringTokenizer st = new StringTokenizer(s, " ");      
      for(int j = 0; j < column; j++) {
        allocation[i][j] = Integer.parseInt(st.nextToken());
        need[i][j] = max[i][j] - allocation[i][j];
      }
    }
    
    out.print("Need Matrix : ");
    for(int i = 0; i < row; i++) {
      out.println();      
      for(int j = 0; j < column; j++) {
        out.print(need[i][j] + " ");
      }
    }

    out.println();
    String s = b.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");
    
    int counter = 0;
    while(st.hasMoreTokens()) {
      available[0][counter] = Integer.parseInt(st.nextToken());
      counter++;
    }
    
    counter = 0;

    for(int i=0;;i++) {
      i = i%row;
      boolean flag = true;
      
      for(int j = 0; j < column; j++) {
        if(need[i][j] <= available[counter][j]) {}
        
        else{
          flag = false;
          break;
        }
        
        if(flag && j == (column - 1) && !track.contains(i)) {

          for(int k = 0; k < column; k++) {
            available[counter + 1][k] = available[counter][k] + allocation[i][k];
          }
          
          track.addLast(i);
          counter++;
        }
      }
      
      if(track.size() == row) {
        break;
      }
    }
    
    out.println("Safe sequence is : ");

    for(int i=0; i < track.size(); i++) {
      out.print(process[track.get(i)] + " ");
    }
    
    out.println();    
    out.print("Change in available resource matrix : ");
    for(int i = 1; i < available.length; i++) {
      out.println();
      
      for(int j = 0; j < column; j++) {
        out.print(available[i][j] + " ");
      }
    }
  }
}

