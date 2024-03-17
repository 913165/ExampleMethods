package org.example;

import java.util.Arrays;

public class StringMethods {
    // Method to reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // Method to count the number of vowels in a string
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toLowerCase().toCharArray();
        char[] charArray2 = str2.toLowerCase().toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Compare characters from both ends of the string
        int left = 0;
        int right = cleanStr.length() - 1;
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false; // If characters don't match, it's not a palindrome
            }
            left++;
            right--;
        }
        return true; // If all characters match, it's a palindrome
    }
    // Method to check if a string is a pangram
    public static boolean isPangram(String str) {
        // Create a boolean array of size 26 to mark the letters present in the string
        boolean[] mark = new boolean[26];
        int index = 0;

        // Traverse all characters
        for (int i = 0; i < str.length(); i++) {
            // If uppercase, convert to lowercase
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                index = str.charAt(i) - 'A';
            } else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                index = str.charAt(i) - 'a';
            }
            mark[index] = true;
        }

        // If any letter is unmarked, return false
        for (int i = 0; i <= 25; i++) {
            if (!mark[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a string is a valid IPv4 address
    public static boolean isValidIPv4(String str) {
        // Split the string by "."
        String[] parts = str.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            // Check if the part is an integer
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
                // Check for leading zeros
                if (part.length() > 1 && part.charAt(0) == '0') {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a string is a valid IPv6 address
    public static boolean isValidIPv6(String str) {
        // Split the string by ":"
        String[] parts = str.split(":");
        if (parts.length != 8) {
            return false;
        }
        for (String part : parts) {
            // Check if the part is a valid hexadecimal number
            try {
                Long.parseLong(part, 16);
            } catch (NumberFormatException e) {
                return false;
            }
            // Check if the part is not longer than 4 characters
            if (part.length() > 4) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a string is a valid email address
    public static boolean isValidEmail(String str) {
        // Regular expression for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return str.matches(emailRegex);
    }

    // Method to check if a string is a valid URL
    public static boolean isValidURL(String str) {
        // Regular expression for URL validation
        String urlRegex = "^(http|https)://[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+([/?].*)?$";
        return str.matches(urlRegex);
    }

    // Method to check if a string is a valid phone number
    public static boolean isValidPhoneNumber(String str) {
        // Regular expression for phone number validation
        String phoneRegex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        return str.matches(phoneRegex);
    }

    // Method to check if a string is a valid credit card number
    public static boolean isValidCreditCardNumber(String str) {
        // Remove all non-numeric characters
        String cleanStr = str.replaceAll("[^0-9]", "");
        int n = cleanStr.length();
        if (n < 13 || n > 19) {
            return false;
        }
        int[] cardNum = new int[n];
        for (int i = 0; i < n; i++) {
            cardNum[i] = Integer.parseInt(cleanStr.substring(i, i + 1));
        }
        for (int i = n - 2; i >= 0; i = i - 2) {
            int j = cardNum[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            cardNum[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cardNum[i];
        }
        return sum % 10 == 0;
    }
    // Method to check if a string is a valid password
    public static boolean isValidPassword(String str) {
        // Regular expression for password validation
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return str.matches(passwordRegex);
    }

    // Method to check if a string is a valid date
    public static boolean isValidDate(String str) {
        // Regular expression for date validation
        String dateRegex = "^(0[1-9]|1[0-2])/(0[1-9]|1\\d|2\\d|3[01])/(19|20)\\d{2}$";
        return str.matches(dateRegex);
    }

    // Method to check if a string is a valid time
    public static boolean isValidTime(String str) {
        // Regular expression for time validation
        String timeRegex = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        return str.matches(timeRegex);
    }

    // Method to check if a string is a valid username
    public static boolean isValidUsername(String str) {
        // Regular expression for username validation
        String usernameRegex = "^[a-zA-Z0-9_-]{3,16}$";
        return str.matches(usernameRegex);
    }

    // Method to check if a string is a valid hexadecimal color code
    public static boolean isValidHexColor(String str) {
        // Regular expression for hexadecimal color code validation
        String hexColorRegex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        return str.matches(hexColorRegex);
    }

    // Method to check if a string is a valid MAC address
    public static boolean isValidMACAddress(String str) {
        // Regular expression for MAC address validation
        String macAddressRegex = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
        return str.matches(macAddressRegex);
    }

    // Method to check if a string is a valid UUID
    public static boolean isValidUUID(String str) {
        // Regular expression for UUID validation
        String uuidRegex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
        return str.matches(uuidRegex);
    }

    // Method to check if a string is a valid ISBN
    public static boolean isValidISBN(String str) {
        // Remove all non-numeric characters
        String cleanStr = str.replaceAll("[^0-9X]", "");
        if (cleanStr.length() != 10) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = cleanStr.charAt(i) - '0';
            sum += (10 - i) * digit;
        }
        char last = cleanStr.charAt(9);
        if (last == 'X') {
            sum += 10;
        } else {
            sum += last - '0';
        }
        return sum % 11 == 0;
    }

    // Method to check if a string is a valid credit card CVV
    public static boolean isValidCVV(String str) {
        // Regular expression for CVV validation
        String cvvRegex = "^[0-9]{3,4}$";
        return str.matches(cvvRegex);
    }

    // Method to check if a string is a valid currency
    public static boolean isValidCurrency(String str) {
        // Regular expression for currency validation
        String currencyRegex = "^[A-Z]{3}$";
        return str.matches(currencyRegex);
    }

    // Method to check if a string is a valid postal code
    public static boolean isValidPostalCode(String str) {
        // Regular expression for postal code validation
        String postalCodeRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
        return str.matches(postalCodeRegex);
    }

    public static void main(String[] args) {
        // Reverse a string
        String str = "Hello, World!";
        System.out.println("Original string: " + str);
        System.out.println("Reversed string: " + reverseString(str));

        // Count the number of vowels in a string
        String str2 = "Hello, World!";
        System.out.println("Number of vowels in \"" + str2 + "\": " + countVowels(str2));

        // Check if two strings are anagrams
        String str3 = "listen";
        String str4 = "silent";
        System.out.println("\"" + str3 + "\" and \"" + str4 + "\" are anagrams: " + areAnagrams(str3, str4));

        // Check if a string is a palindrome
    }
}
