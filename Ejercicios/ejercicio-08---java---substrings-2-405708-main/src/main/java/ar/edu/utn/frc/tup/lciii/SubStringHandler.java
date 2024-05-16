package ar.edu.utn.frc.tup.lciii;

public class SubStringHandler {

    public static String getSmallestAndLargest(String s, int k) {
        //String smallest = "";
        //String largest = "";
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        //return smallest + "\n" + largest;

        String substring = s.substring(0, k);
        String smallest = substring;
        String largest = substring;

        for (int i = 1; i <= s.length() - k; i++) {
            //Creo un substring de valor k
            substring = s.substring(i, i + k);

            //Si ese substring es lexograficamente menor que el ´menor´ al momento, ahora ese seria el menor
            if (substring.compareTo(smallest) < 0) {
                smallest = substring;
            }

            //Si ese substring es lexograficamente mayor que el ´mayor´ al momento, ahora ese seria el mayor
            if (substring.compareTo(largest) > 0) {
                largest = substring;
            }
        }

        return smallest + "\n" + largest;

    }
}
