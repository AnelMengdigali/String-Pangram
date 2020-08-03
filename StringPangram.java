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

