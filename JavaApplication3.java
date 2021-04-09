/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total Number of states :");
        int nummberOfStates = sc.nextInt();
        System.out.println("How many words you want to store :");
        int numberOfWords = sc.nextInt();
        String[] arrayOfWordsOfregularExpression = new String[numberOfWords];
        System.out.println("Please enter words names in regex form :");                    
        for (int i = 0; i < numberOfWords; i++)
        {
            arrayOfWordsOfregularExpression[i] = sc.next();
        }
        //-----------------------------------------------------------------------------------------
        
        System.out.print("Enter the number of final states elements you want to store: ");  
        //reading the number of elements from the that we want to enter  
        int n=sc.nextInt();  
        //creates an array in the memory of length 10  
        int[] finalStatesArray = new int[n];  
        System.out.println("Enter the fianl states elements array one by one ");  
        for(int i=0; i<n; i++)  
        {  
        //reading array elements from the user   
        finalStatesArray[i]=sc.nextInt();  
        }        
        //-----------------------------------------------------------------------------------------
        
        int[][] transitionTable = new int[nummberOfStates][arrayOfWordsOfregularExpression.length];        
        for(int i=0; i<nummberOfStates;i++)
         {            
            for(int j=0; j<arrayOfWordsOfregularExpression.length;j++)
            {             
                 System.out.println("Enter state number at position " + "[" + i + "]" + "[" + j + "]");
                 transitionTable[i][j]=sc.nextInt();                                
            }
         }
        //-----------------------------------------------------------------------------------------
        
        System.out.println("Enter input for checking with above finite automato which you given.");
        String input = sc.next();
        char[] wordForCheckingWithRegularExpression = new char[input.length()];
        // Copy character by character into array
        for (int i = 0; i < input.length(); i++) 
        {
            wordForCheckingWithRegularExpression[i] = input.charAt(i);
        }
        //-----------------------------------------------------------------------------------------
        
        int q=0;
        int save = 0;
        for(int p=0; p<wordForCheckingWithRegularExpression.length;p++)
        {
            for(int k=q;k<nummberOfStates;k++)
            {
                for(int j=0; j<arrayOfWordsOfregularExpression.length;j++)
                {
                    //if(String.valueOf(wordForCheckingWithRegularExpression[p])==arrayOfWordsOfregularExpression[j])
                    if(Pattern.matches(arrayOfWordsOfregularExpression[j],String.valueOf(wordForCheckingWithRegularExpression[p])))    
                    {
                        save = transitionTable[k][j];
                        q= save;
                    }                    
                }
                break;
            }
            
        }
        //-----------------------------------------------------------------------------------------
        
        int y;
        for(y=0; y<n; y++)  
        {  
        //reading array elements from the user   
            if(finalStatesArray[y]==save)
            {
                System.out.print("Correct Input");
                break;
            }
            
        }
        if(y==n)
        {
            System.out.print("InCorrect Input");
        }
        
        
    }
    
}
