import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman{
    private static String[] sketch = initHangmanSketchArray(); 
    public static void main(String[] args) {
        System.out.print("Insert word to guess (only english words): ");
        Scanner scan = new Scanner(System.in); 
        Console cons = System.console(); 
        String initWord = new String(cons.readPassword()).toUpperCase();

        // buffers
        ArrayList<String> guessedLetters = new ArrayList<String>();
        int life = 8;       

        // Lets try to guess the word
        while(true){
            if(life != 8){
                System.out.println();
                sketchHangman(8-life-1);
            }

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