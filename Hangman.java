import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Hangman{
    private static String[] sketch = initHangmanSketchArray(); 
    
    public static void main(String[] args) {
        // Inital start point. Get a word to guess. The word you write is going to be invisble
        System.out.print("Insert word to guess (only english words): ");
        Scanner scan = new Scanner(System.in); 
        Console cons = System.console(); 
        String initWord = new String(cons.readPassword()).toUpperCase();
        
        // buffers
        TreeSet<String> guessedLetters = new TreeSet<String>(); 
        int life = 8;       

        // Lets try to guess the word
        while(true){
            //  Sketch Hangman according to how many lives you have
            if(life != 8){
                System.out.println();
                sketchHangman(8-life-1);
            }

            // You lose if you run out of lives. 
            if(life == 0){
                System.out.println("---------- You lost! You ran out of lives! ----------");
                System.out.println("The correct word was: " + initWord);
                break;
            }

            // print line with correct letter embedded at right index
            System.out.print("Word to guess: ");
            int bufferCounter = 0; 
            for (int i = 0; i<initWord.length(); i++){
                String letterInInitWord = initWord.substring(i, i+1);
                if(guessedLetters.contains(letterInInitWord)){
                    System.out.print(" " + letterInInitWord + " ");
                    bufferCounter++;
                }
                else if(letterInInitWord.contains("-")){
                    System.out.print(" - ");
                    bufferCounter++;
                }
                else if(letterInInitWord.contains(" ")){
                    System.out.print("   ");
                    bufferCounter++;
                }
                else{
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
            System.out.println("Already guessed words" + guessedLetters);
            System.out.println("Lifes left:" + life);  
            System.out.print("Try a letter: ");

            String letter = scan.next().toUpperCase();

            // Checking letter input
            // Cheating backdoor to get the word and defensive input measures
            if (letter.equals("BACKDOOR")) {
                System.out.println(initWord);
                continue;
            } else if(letter.length()>1){
                System.out.println("Only insert one letter at a time - has to be an english letter");
                System.out.println("________________________________________________________________________________");
                continue; 
            } else if(!checkInput(letter)){
                System.out.println(letter + " is not a legal input. Legal inputs are of one of the following: [\"abcdefghijklmnopqrstuvwxyz\"]");
                System.out.println("________________________________________________________________________________");
                continue; 
            }

            // Check if letter belongs to word or if we have already seen it 
            if(!initWord.contains(letter) && !guessedLetters.contains(letter)){
                life--;
            }
            guessedLetters.add(letter); 
            System.out.println("________________________________________________________________________________");
        }
        scan.close();        
    }

    //Check the letter input and see if it is legal. Returns true if it is. 
    public static boolean checkInput(String input){
        String legalInput = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        if(legalInput.contains(input)){
            return true; 
        }
        return false; 
    }

    public static void sketchHangman(int index){
        String hangmanPart = sketch[index];
        System.out.println(hangmanPart);
    }
    
    //  _______
    //  |/      |
    //  |      (_)
    //  |      \|/
    //  |       |
    //  |      / \
    //  |
    // _|___
    public static String[] initHangmanSketchArray(){
        //assumes number of life is 8
        String[] sketch = new String[8];
        sketch[0] = "_|___";
    // _|___
      
        sketch[1] = 
        " |\n |\n |\n |\n |\n |\n_|___"; 
    //  |     
    //  |      
    //  |      
    //  |      
    //  |      
    //  |
    // _|___

       sketch[2] =
       " _______ \n |/\n |\n |\n |\n |\n |\n |\n_|___";
   //  _______
    //  |/      
    //  |      
    //  |      
    //  |      
    //  |      
    //  |
    // _|___ 

       sketch[3] =
       " _______ \n |/    |\n |\n |\n |\n |\n |\n |\n_|___";
    //  _______
    //  |/      |
    //  |     
    //  |     
    //  |     
    //  |      
    //  |
    // _|___
       
        sketch[4] = 
       " _______ \n |/    |\n |    (_)\n |\n |\n |\n |\n |\n_|___";
    //  _______
    //  |/      |
    //  |      (_)
    //  |      
    //  |      
    //  |      
    //  |
    // _|___
       
       sketch[5] = 
       " _______ \n |/    |\n |    (_)\n |     |\n |     |\n |\n |\n |\n_|___";

    //     _________
    //     |/      |
    //     |      (_)
    //     |       |
    //     |       |
    //     |       
    //     |
    //    _|___";
       
       sketch[6] = 
       " _______ \n |/    |\n |    (_)\n |     |\n |     |\n |    / \\ \n |\n |\n_|___";

    //     _________
    //     |/      |
    //     |      (_)
    //     |       |
    //     |       |
    //     |      / \
    //     |
    //    _|___";
        
       sketch[7] = 
       " _______ \n |/    |\n |    (_)\n |    \\|/\n |     |\n |    / \\ \n |\n |\n_|___";

    //     _________
    //     |/      |
    //     |      (_)
    //     |      \|/
    //     |       |
    //     |      / \
    //     |
    //    _|___";
        return sketch;
    }
}