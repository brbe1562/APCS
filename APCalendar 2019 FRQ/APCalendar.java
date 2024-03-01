import java.util.ArrayList;
/**
 * Starter Code and Tester for 2019 # 1: APCalendar
 * In Part (a) you write the numberOfLeapYears method
 * In part (b) you write the Day of week method
 * 
 * run the main method to test your code.
 * 
 * @author Chris Thiel OFMCap
 * @version March 6, 2020
 */
public class APCalendar
{
    

    /** Returns the number of leap years between year1 and year2, inclusive. 
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2)
    {    
        ArrayList<Integer> years = new ArrayList<Integer>();
        int result = 0;
        for(int i = year1; i <= year2; i++)
            years.add(i);
        for(int j = 0; j < years.size(); j++) {
            if(isLeapYear(years.get(j)))
                result++;
        }
        return result;
    }
    
    /** Returns the value representing the day of the week for the given date
     * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
     * and 6 denotes Saturday.
     * Precondition: The date represented by month, day, year is a valid date
     */
    public static int dayOfWeek(int month, int day, int year)
    {
        int totalDay = dayOfYear(month, day, year);
        int result = firstDayOfYear(year);
        for(int i = 0; i < totalDay -1 ; i++) {
            result++;
        }
        return result % 7;
    }
    /** Returns true if year is a leap year and false otherwise. 
      * implemetation by Chris Thiel, ofmCap March 6, 2020
      */ 
    private static boolean isLeapYear(int year)
    { 
        if (year % 400 == 0) // check for Gregorian Calendar exception
            return false;
        return year % 4 == 0; 
    }

    /** Returns the value representing the day of the week for the first day of year, 
     * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
     * implemetation of Gauss's algorithm by Chris Thiel, ofmCap March 6, 2020
     */
    private static int firstDayOfYear(int year)
    { int y = year-1;
      return ( 1 +5*(y%4) + 4*(y%100) + 6*(y%400) ) % 7;
    }

    /** Returns n, where month, day, and year specify the nth day of the year.
     * Returns 1 for January 1 (month = 1, day = 1) of any year.
     * Precondition: The date represented by month, day, year is a valid date. 
     */
    public static int dayOfYear(int month, int day, int year)
    { /* implementation by CT or if you wish LocalDate class */    
      int[] daysAlready = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 0};
      int days = day;
      if ( isLeapYear(year) &&  month > 2  )
           days++;
      for(int m= 1; m < month; m++)
           days += daysAlready[m];
      return days;
      // Less fun is LocalDate.now().getDayOfYear(); requires import java.time.LocalDate;
      
    }

    // There may be instance variables, constructors, and other methods not shown. 
    
    public static void testPartA( int y1, int y2, int expected )
    {
        System.out.print("numberOfLeapYears(" + y1+", "+y2+") = "+ expected +"; Your code: ");
        int yourCode = numberOfLeapYears(y1,y2);
        String result = " Fail :(";
        if (expected == yourCode)
            result = " Pass :)";
        System.out.println( yourCode + result +"\n");
    }
    public static void testPartB( int m, int d, int y , int expected)
    {
        System.out.print("dayOfWeek(" + m+", "+d+", "+y+") = "+ expected +"; Your code: ");
        int yourCode = dayOfWeek(m,d,y);
        String result = " Fail :(";
        if (expected == yourCode)
            result = " Pass :)";
        System.out.println( yourCode + result +"\n");
    }
    public static void main (String[] args)
    {
        System.out.println("AP Calendar Tester from 2019 Question 1\n");
        
        System.out.println("------ Part (a) ------\n");
        testPartA (2003,2020,5);
        testPartA (1996,2004,2);
        testPartA (2001,2003,0);
        
        System.out.println("------ Part (b) ------\n");
        
        testPartB (10,30,1960,0);
        testPartB (3,6,2020,5);
        testPartB (7,9,2018,1);
        testPartB (5,8,2020,5);
        
    }
}