import java.util.*; import java.io.*; 
public class WordMatchGame {     
    private String secret;     
    public WordMatchGame(String word) {         
        this.secret = word.toLowerCase();     
    }     
    public int scoreGuess(String guess)     {           
        String s = secret;         
        int occur = 0;         
        while( s.length() > 0 && s.indexOf(guess) != -1 )         {
            int k = s.indexOf(guess);
            s = s.substring(k + 1);
            occur++;         
        }
        return occur * guess.length() * guess.length();
    }     
    public String findBetterGuess(String guess1, String guess2)     {
        if (scoreGuess(guess1) == scoreGuess(guess2))         {
            if (guess1.compareTo(guess2) > 0)                 
                return guess1;             
            return guess2;         
        }         
        if (scoreGuess(guess1) > scoreGuess(guess2))             
            return guess1;         
        return guess2;         
    }     
    public String getSecret() {
        return secret;
    }
    public static void main(String[] args)     {
        Scanner k = new Scanner(System.in);
        System.out.print("Enter Secret Word: ");
        String secret = k.nextLine();         
        for (int i = 0; i < 30; i++){             
            System.out.print("\n");         
        }         
        String g = "";         
        WordMatchGame game = new WordMatchGame(secret);         
        int maxPoints = game.scoreGuess(secret);         
        int points = 0;         
        System.out.println("Take a guess: ");         
        while (points != maxPoints)         {
            g = k.nextLine();             
            points = game.scoreGuess(g);             
            System.out.println(points);             
            if (points != maxPoints)                 
                System.out.println("Take another guess: ");         }         
        System.out.print("Congrats you win!!!!!");     
    }
}