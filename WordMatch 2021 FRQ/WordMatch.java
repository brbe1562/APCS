 public class WordMatch {     
    private String secret;     
    public WordMatch(String word) {         
        this.secret = word.toLowerCase();     
    }     
    /**
     * Returns a score for guess. 
     * Score Calculations: (number of substring occurences) x (square of length of guess)
     * Precondition: secret.length() >= guess.length() > 0
     */
    public int scoreGuess(String guess)     {           
        //------------------------------------------------
        return -1;
    }
    /**
     * Returns the better of the two Strings.
     * If the scoreGuess method returns different values for guess1 and guess2, 
     * the larger is returned. If the scoreGuess method returns the same values for guess1 and guess 2,
     * the alphabetically greater guess is returned.
     * Precondition: guess1 and guess 2 contain all lowercase 
     * letter & guess1 is not the same as guess2
     */
    public String findBetterGuess(String guess1, String guess2)     {
        //------------------------------------------------
        return "";
    }     
    public String getSecret() {
        return secret;
    }
    public String isCorrect(int score, int correct) {
        if(score == correct)
            return "Pass!";
        return "Fail!";
    }
    public String isCorrect(String score, String correct) {
        if(score.equals(correct))
            return "Pass!";
        return "Fail!";
    }
    public static void main(String[] args) {
        WordMatch test = new WordMatch("mississippi");
        
        /**
         * scoreGuess method test
         */
        
        System.out.println("\n" + "\n" + "\n" + "The secret word is " + test.getSecret());
        System.out.println("\n" + "Testing scoreGuess()" + "\n");
        
        System.out.println("\n" + "Guess: [i] should return 4 and your code returns: " + 
                            test.scoreGuess("i") + "\t" + test.isCorrect(4,test.scoreGuess("i")));
        System.out.println("\n" + "Guess: [iss] should return 18 and your code returns: " + 
                            test.scoreGuess("iss") + "\t" + test.isCorrect(18,test.scoreGuess("iss")));
        System.out.println("\n" + "Guess: [issipp] should return 36 and your code returns: " + 
                            test.scoreGuess("issipp") + "\t" + test.isCorrect(36,test.scoreGuess("issipp")));
        System.out.println("\n" + "Guess: [mississippi] should return 121 and your code returns: " + 
                            test.scoreGuess("mississippi") + "\t" + test.isCorrect(121,test.scoreGuess("mississippi")));
        /**
         * findBetterGuess method test
         */
        System.out.println("\n" + "\n" + "Testing findBetterGuess()" + "\n");
        
        System.out.println("\n" + "Guess: [ss , pp] should return ss and your code returns: " + 
                            test.findBetterGuess("ss", "pp") + "\t" + test.isCorrect("ss", test.findBetterGuess("ss", "pp")));
        System.out.println("\n" + "Guess: [sip , mis] should return sip and your code returns: " + 
                            test.findBetterGuess("sip", "mis") + "\t" + test.isCorrect("sip", test.findBetterGuess("sip", "mis")));
        System.out.println("\n" + "Guess: [missi , iss] should return missi and your code returns: " + 
                            test.findBetterGuess("missi", "iss") + "\t" + test.isCorrect("missi", test.findBetterGuess("missi", "iss")));
                     
        
    }
}
