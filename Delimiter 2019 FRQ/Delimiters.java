import java.util.*;
public class Delimiters
{
    private String openDel;
    private String closeDel;
    /**
     * Constructs a Delimiters object were open is the open delimiter and close is
     * the close delimiter. Precondition: open and close are non-empty strings
     */
    public Delimiters(String open, String close)
    {
        openDel = open;
        closeDel = close;
    }
    /**
     * Returns an ArrayList of delimiters from the array tokens, as described in
     * part (a).
     */
    public ArrayList<String> getDelimitersList(String[] tokens)
    {
        ArrayList<String> delList = new ArrayList<String>();

        for (String currString : tokens)
        {
            if (currString.equals(openDel) || currString.equals(closeDel))
            {
                delList.add(currString);
            }
        }
        return delList;
    }
    public boolean isBalanced(ArrayList<String> delimiters)
    {
        int open = 0;
        int closed = 0;
        for(String token : delimiters) {
            if(token.equals(openDel))
                open++;
            if (token.equals(closeDel)) {
                open--;
                if(open < 0) // have to have more open than closed at any point
                    return false;
            }
        }
        return open == 0;   
    }

    public static void main(String[] args)
    {
        Delimiters d1 = new Delimiters("<sup>", "</sup>");
        String[] tokens =
            {
                "<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>"
            };
        ArrayList<String> delList1 = d1.getDelimitersList(tokens);
        boolean res1 = d1.isBalanced(delList1);
        System.out.println("It should print true and it prints " + res1);

        String[] tokens2 = {"<sup>", "</sup>", "</sup>", "<sup>"};
        ArrayList<String> delList2 = d1.getDelimitersList(tokens2);
        boolean res2 = d1.isBalanced(delList2);
        System.out.println("It should print false and it prints " + res2);

        String[] tokens3 = {"</sup>"};
        ArrayList<String> delList3 = d1.getDelimitersList(tokens3);
        boolean res3 = d1.isBalanced(delList2);
        System.out.println("It should print false and it prints " + res3);

        String[] tokens4 = {"<sup>", "</sup>", "</sup>"};
        ArrayList<String> delList4 = d1.getDelimitersList(tokens4);
        boolean res4 = d1.isBalanced(delList2);
        System.out.println("It should print false and it prints " + res4);
    }
}

