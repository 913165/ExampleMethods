package org.example;

public class StockSymbolValidator {

    // This method should return true if the input string is a valid stock symbol
    public static boolean isValidStockSymbol(String stockSymbol) {
        return stockSymbol.matches("^[A-Z]{3,5}$");
    }

    public static void main(String[] args) {
        String[] stockSymbols = {"AAPL", "GOOGL", "MSFT", "AMZN", "TSLA", "FB", "invalid"};

        for (String stockSymbol : stockSymbols) {
            System.out.println(stockSymbol + " is valid: " + isValidStockSymbol(stockSymbol));
        }
    }
    // ISIN - International Securities Identification Number
    public static boolean isValidISIN(String isin) {
        // Check if the ISIN is exactly 12 characters long
        if (isin == null || isin.length() != 12) {
            return false;
        }

        // Check if the first two characters are letters (country code)
        if (!Character.isLetter(isin.charAt(0)) || !Character.isLetter(isin.charAt(1))) {
            return false;
        }

        // Check if the remaining characters are alphanumeric
        for (int i = 2; i < 11; i++) {
            char c = isin.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        // Check if the last character is a valid checksum
        char lastChar = isin.charAt(11);
        if (!isValidChecksum(isin.substring(0, 11), lastChar)) {
            return false;
        }

        return true;
    }

    private static boolean isValidChecksum(String isinWithoutChecksum, char checksumChar) {
        // Calculate the checksum value using modulo 10
        int checksumValue = 0;
        for (int i = 0; i < isinWithoutChecksum.length(); i++) {
            char c = isinWithoutChecksum.charAt(i);
            int digit = Character.isLetter(c) ? Character.toUpperCase(c) - 'A' + 10 : Character.getNumericValue(c);
            checksumValue = (checksumValue * 10 + digit) % 10;
        }

        // Convert the calculated checksum value to a character
        char calculatedChecksumChar = (char) (checksumValue + '0');

        // Compare the calculated checksum character with the given checksum character
        return calculatedChecksumChar == checksumChar;
    }


    //

}
