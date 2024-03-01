
/**
 * StepTrackerTester tests your code answering FRQ2 in the year 2019.
 * You are asked to write the complete StepTracker class, 
 * including the constructor and any required instance variables and methods. 
 * Your implementation must meet all specifications and conform to the example
 * 
 * @author Bradley Bell
 * @version Fev 27,2024
 */
public class StepTracker
{
    private int totalSteps;
    private int numDays;
    private int minSteps;
    private int numActiveDays;
    public StepTracker(int step) {
        minSteps = step;
        totalSteps = 0;
        numDays = 0;
        numActiveDays = 0;
    }
    public void addDailySteps(int steps) {
        totalSteps += steps;
        numDays++;
        if(steps >= minSteps)
            numActiveDays++;
    }
    public int activeDays() {
        return numActiveDays;
    }
    public double averageSteps() {
        return (double) totalSteps / numDays;
    }
    public static void main(String[] args)
    {
        StepTracker tr = new StepTracker(10000);
        System.out.println("StepTracker Tester starting with 10000 steps to be considered active\n");
        
        System.out.println("activeDays() - your response: "+ tr.activeDays()+" , correct response: 0"
             +  passFail(tr.activeDays(),0) +"\n");
        
        System.out.println("averageSteps() - your response: "+ tr.averageSteps() +" , correct response: 0.0"
             + passFail( tr.averageSteps(),0.0) +"\n");
        System.out.println("adding 9000 steps - not enough to be active");
        tr.addDailySteps(9000);
        System.out.println("adding 5000 steps - not enough to be active");
        tr.addDailySteps(5000);
        System.out.println("no days were over 10000, so no active days...\n");
        System.out.println("activeDays() - your response: "+tr.activeDays() + " , correct response: 0"
             +  passFail(tr.activeDays(),0) +"\n");
        System.out.println("averageResponse() - your response: "+tr.averageSteps() + " , correct response: 7000.0 (14000 steps/2 days)"
             + passFail( tr.averageSteps(),7000.0) +"\n");
        System.out.println("adding 13000 steps - our first active day");
        tr.addDailySteps(13000);
        System.out.println("activeDays() - your response: "+tr.activeDays() + " , correct response: 1");
        System.out.println("averageResponse() - your response: "+tr.averageSteps() + " , correct response: 9000.0 (27000 steps/3 days)"
             + passFail( tr.averageSteps(),9000.0) +"\n");
        System.out.println("adding 23000 steps - our second active day");
        tr.addDailySteps(23000);
        System.out.println("adding 1111 steps - not enough to be active");
        tr.addDailySteps(1111);
        System.out.println("activeDays() - your response: "+tr.activeDays() + " , correct response: 2");
        System.out.println("averageSteps() - your response: "+tr.averageSteps()+ " , correct response: 10222.2 (51111 steps/5 days)"
             + passFail( tr.averageSteps(),10222.2) +"\n");
    }
    public static String passFail(int expected, int got)
    {
        if (expected == got)
            return " Pass :)";
        return " Fail :(";
    }
    public static String passFail(double expected, double got)
    {
        if (expected == got)
            return " Pass :)";
        return " Fail :(";
    }
}