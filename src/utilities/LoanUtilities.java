package utilities;

public class LoanUtilities
{
    public static long getAmount(long principalAmount, long rateOfInterest, long noOfYears) { return getInterest(principalAmount, rateOfInterest, noOfYears) + principalAmount; }

    public static long getInterest(long principalAmount, long rateOfInterest, long noOfYears) { return (principalAmount * rateOfInterest * noOfYears) / 100; }
}
