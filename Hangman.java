import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman{
    public static void main(String[] args) {
        System.out.print("Insert word to guess (only english words): ");
        Scanner scan = new Scanner(System.in); 
        Console cons = System.console(); 
        String initWord = new String(cons.readPassword()).toUpperCase();

        // buffers
        ArrayList<String> guessedLetters = new ArrayList<String>();
        int life = 10;       

        // Lets try to guess the word
        while(true){
            if(life == 0){
                System.out.println("---------- You lost! You ran out of lives! ----------");
                break;
            }
            // print line with correct words embedded at right index
            System.out.print("Word to guess: ");
            int bufferCounter = 0; 
            for (int i = 0; i<initWord.length(); i++){
                String letterInInitWord = initWord.substring(i, i+1);
                if(guessedLetters.contains(letterInInitWord)){
                    System.out.print(" " + letterInInitWord + " ");
                    bufferCounter++;
                }else{
                    System.out.print(" _ ");
                }
            }
            System.out.print("\n");
            
            //Break if we have guessed the right word. 
            if(bufferCounter == initWord.length()){
                System.out.println("!!!!! Congratulations - You won  !!!!!");
                break;
            }

            // print already guessed words and status of life 
            System.out.print("Already guessed words" + guessedLetters + "\nLifes left:" + life + "\n"); 
            System.out.print("Try a letter: ");

            String letter = scan.next().toUpperCase();
            if(letter.length()>1){
            System.out.println("Only insert one letter at a time - has to be an english letter");
            System.out.println("________________________________________________________________________________");
            continue; 
            }
            if(!initWord.contains(letter) && !guessedLetters.contains(letter)){
                life--;
            }
            guessedLetters.add(letter); 
            System.out.println("________________________________________________________________________________");
        }
        scan.close();        
    }
}