/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessinggame;
/**
 *
 * @author Rik(^_^)
 */
import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        methodChange.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard){
        NumberGuessingGame methodChange = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("\n");
        System.out.println("welcome to the number game");
        System.out.println("1. Play the Game ");
        System.out.println("2. Score Board");
        System.out.println("3. Exit the Game ");
        System.out.println("\n");
        System.out.println("----------------------");
        try{
            System.out.print("Press any number to continue");
            int menuOption = input.nextInt();
            switch(menuOption){
                case 1:
                    System.out.print("\n"+"what would ypu like the range pf the numbers to be?");
                    int num_range = input.nextInt();
                    int randomNumber = methodChange.randomNumber(num_range);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"thanks for playing");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number pressed...Try again...");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage()+"\n");
            menu(scoreBoard);
        }
    }
    public int randomNumber(int num_range){
        Random random= new Random();
        int randomNumber = random.nextInt(num_range)+1;
        return randomNumber;
    }
    
    public void guessNumber(int randomNumber){
        Scanner input = new Scanner(System.in);
        int userInput;
                
        int guess=0;
        do{
            System.out.print("Enter yout guess nuber");
            userInput = input.nextInt();
            guess++;
            if(userInput > randomNumber)
                System.out.println("Lower");
            else if(userInput < randomNumber)
                System.out.println("Higher");
        }while(randomNumber != userInput);
        System.out.println(" ");
        if(guess==1)
            System.out.println("you answered the correct number in "+ guess +" try!!");
        else
            System.out.println("you answered the correct number in "+ guess +" tries!!!");
        scoreBoard.add(guess);
        System.out.println(" ");
        
        menu(scoreBoard);
    }
    
    public void displayScoreBoard(){
        System.out.println("-------------");
        System.out.println(" Score Board");
        System.out.println("-------------");
        System.out.println("your fastest games today out of all tries is :"+"\n");
        Collections.sort(scoreBoard);
        for(Integer scores : scoreBoard)
            System.out.println("Finished the game in "+scores + " tries");
        System.out.println(" ");
        menu(scoreBoard);
    }
 }
    
    
