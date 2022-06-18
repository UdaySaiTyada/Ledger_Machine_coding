package utilities;

import constants.TimeConstants;

public class EmiUtilities
{
    public static long getRemainingEmi(long remainingAmount, long emi)
    {
        return Math.min(remainingAmount, emi);
    }

    public static long getEmi(long amount, long noOfYears)
    {
        return amount / getNoOfMonths(noOfYears);
    }

    public static long getNoOfMonths(long noOfYears)
    {
        return (TimeConstants.NO_OF_MONTHS_IN_YEAR * noOfYears);
    }
}