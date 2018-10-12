/**
 * Computes the payout for Chuck-a-luck.
 *
 *
 * @author YOUR NAME HERE
 * @version DUE DATE HERE
 */
public class ChuckALuck {

   // Constants that specify bet types
    public static final int SINGLE = 1;
    public static final int TRIPLE = 2;
    public static final int BIG = 3;
    public static final int SMALL = 4;
    public static final int FIELD = 5;

   // Constants that specify payout multipliers
    public static final double SINGLE_ONE_ODDS = 1.0;
    public static final double SINGLE_TWO_ODDS = 2.0;
    public static final double SINGLE_THREE_ODDS = 10.0;
    public static final double TRIPLE_ODDS = 30.0;
    public static final double BIG_ODDS = 1.0;
    public static final double SMALL_ODDS = 1.0;
    public static final double FIELD_ODDS = 1.0;

   //Contant for invalid bet types
    public static final int INVALID_BET_TYPE = -1;
   /**
    * Calculate the correct Chuck-a-luck payout based on the dice roll, the bet
    * type, and the bet amount.
    *
    * For any losing roll the payout will be a negative number equal to the
    * value of the bet. For example, on a losing $3.00 bet, the payout will be
    * -$3.00.
    *
    * @param dice       A dice object representing the outome of the roll
    * @param betType    The type of the bet, SINGLE, TRIPLE, BIG, etc.
    * @param number     The number of the bet, 1-6. (Note that this parameter
    *                   only matters if the bet type is SINGLE. Tt will be
    *                   ignored for all other bet types.)
    * @param betAmount  The amount of the bet in dollars
    * @return The payout amount in dollars. This will be a negative number if it
    *         was a losing bet.
    */

    public static double calculatePayout(Dice dice, int betType, int number,
               double betAmount) {

        double payout;

        switch (betType) {
            case SINGLE:
                payout = singleOdds(dice, number, betAmount);
                break;
            case TRIPLE:
                payout = tripleOdds(dice, betAmount);
                break;
            case BIG:
                payout = bigOdds(dice, betAmount);
                break;
            case SMALL:
                payout = smallOdds(dice, betAmount);
                break;
            case FIELD:
                payout = fieldOdds(dice, betAmount);
                break;
            default:
                payout = INVALID_BET_TYPE;
                break;
        }

      // Write a switch statement to evaluate the payout.
      // Cases that require more than a few lines of code should be handled
      // in separate methods below. Each case should set the value of the
      // payout variable, so that you will have only one return statement.

        return payout;

    }

    /**
     * This method will calculate the result of a single odds game of dice.
     *
     * @param dice
     * @param number
     * @param bet
     * @return The amount of dollars that the user won or lost.
     */
    public static double singleOdds(Dice dice, int number, double bet) {
        int value;
        value = dice.countValues(number);
        double amount;
        switch (value) {
            case 1:
                amount = bet * SINGLE_ONE_ODDS;
                break;
            case 2:
                amount = bet * SINGLE_TWO_ODDS;
                break;
            case 3:
                amount = bet * SINGLE_THREE_ODDS;
                break;
            default:
                amount = bet * (-1);
                break;

        }

        return amount;
    }

    /**
     * This method will calculate the result of a Triple odds game of dice.
     * @param dice
     * @param bet
     * @return The amount of dollars that the user won or lost.
     */
    public static double tripleOdds(Dice dice, double bet) {
        int firstDice = dice.getFirst();
        int secondDice = dice.getSecond();
        int thirdDice = dice.getThird();
        double amount;

        if ((firstDice == secondDice) && (firstDice == thirdDice)) {
            amount = bet * TRIPLE_ODDS;
        } else {
            amount = bet * (-1);
        }
        return amount;
    }

    /**
     * This method will calculate the result of a Big odds game of dice.
     * @param dice
     * @param bet
     * @return The amount of dollars that the user won or lost.
     */
    public static double bigOdds(Dice dice, double bet) {
        int firstDice = dice.getFirst();
        int secondDice = dice.getSecond();
        int thirdDice = dice.getThird();
        int score = firstDice + secondDice + thirdDice;
        double amount;

        if ((firstDice == secondDice) && (firstDice == thirdDice)) {
            amount = bet * (-1);
        } else if (score < 11) {
            amount = bet * (-1);
        }

        return amount;
    }

    /**
     * This method will calculate the result of a small odds game of dice.
     * @param dice
     * @param bet
     * @return The amount of dollars that the user won or lost.
     */
    public static double smallOdds(Dice dice, double bet) {
        int firstDice = dice.getFirst();
        int secondDice = dice.getSecond();
        int thirdDice = dice.getThird();
        int score = firstDice + secondDice + thirdDice;
        double amount;

        if ((firstDice == secondDice) && (firstDice == thirdDice)) {
            amount = bet * (-1);
        } else if (score > 10) {
            amount = bet * (-1);
        }

        return amount;
    }

    /**
     * This method will calculate the result of a field odds game of dice.
     * @param dice
     * @param bet
     * @return The amount of dollars that the user won or lost.
     */
    public static double fieldOdds(Dice dice, double bet) {
        int firstDice = dice.getFirst();
        int secondDice = dice.getSecond();
        int thirdDice = dice.getThird();
        int score = firstDice + secondDice + thirdDice;
        double amount;

        if ((score >= 8) && (score <= 12)) {
            amount = bet * (-1);
        }

        return amount;
    }
}
