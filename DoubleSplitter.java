public class DoubleSplitter {
    public static void main(String[] args) {
        double number = 12345.789;

        // Extract integer part
        long integerPart = (long) number;

        // Extract fractional part
        double fractionalPart = number - integerPart;

        // Process integer part
        processDigits(integerPart);

        // Process fractional part
        processFractionalDigits(fractionalPart);
    }

    private static void processDigits(long number) {
        // Determine the order of magnitude
        long magnitude = 1;
        while (magnitude <= number) {
            magnitude *= 100;
        }
        magnitude /= 100;

        // Extract individual groups of two digits without using Math library
        while (magnitude >= 1) {
            // Extract the leftmost two digits
            int leftTwoDigits = (int) (number / magnitude);

            // Print or process the extracted digits
            System.out.println(leftTwoDigits);

            // Remove the leftmost two digits
            number %= magnitude;

            // Update the order of magnitude for the next iteration
            magnitude /= 100;
        }
    }

    private static void processFractionalDigits(double fractionalPart) {
        // Extract individual groups of two digits from the fractional part
        double magnitude = 1.0 / 100;

        while (magnitude > 0.0000001) {
            // Extract the leftmost two digits
            int leftTwoDigits = (int) (fractionalPart / magnitude);

            // Print or process the extracted digits
            System.out.println(leftTwoDigits);

            // Remove the leftmost two digits
            fractionalPart %= magnitude;

            // Update the order of magnitude for the next iteration
            magnitude /= 100;
        }
    }
}
