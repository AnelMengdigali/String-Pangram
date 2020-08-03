import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    
    static StringBuilder result = new StringBuilder();
    
    public static String isPangram( List<String> pangram ) {
        
        for( int i = 0; i < pangram.size(); i ++ ){
            
            HashMap< Character, Boolean > checker = new HashMap<>();
            int count = 0;
            
            String input = pangram.get(i);
            input = input.replaceAll( " ", "" );
            
            for( char s = 'a'; s <= 'z'; s ++ ){
                checker.put( s, false );
            }
            
            for( int j = 0; j < input.length(); j++ ){
                
                if( checker.containsKey( input.charAt(j) ) ){
                    
                    checker.put( input.charAt(j), true );
                    
                }
                
            }
            
            for( char s = 'a'; s <= 'z'; s ++ ){
                
                if( checker.get(s) == true ){
                    count ++;
                }
                
            }
            
            if( count == 26 ){
                result.append(1);
            }
            else{
                result.append(0);
            }
            
        }
        
        return result.toString();
        
    }
    
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int pangramCount = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<String> pangram = IntStream.range(0, pangramCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        .collect(toList());
        
        String result = Result.isPangram(pangram);
        
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
