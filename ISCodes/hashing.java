package ISCodes;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

// This is a Java program to determine the usage of SHA Hashing.  

class hashing {
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // The static method called in the JAVA program
        // for calculating the message digest of a given input
        // and results in an array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // calling the " BigInteger " function in JAVA programming language.
        BigInteger number = new BigInteger(1, hash);

        // Converting the message digest into a Hexa decimal value.
        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    // Main code containing the plain text to be converted.
    public static void main(String args[]) {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the message to be hashed: ");
            String str1=sc.nextLine();
            System.out.println("\n" + str1 + " : " + toHexString(getSHA(str1)));
            sc.close();
        }
        // using the catch keyword for determining the wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("The Exception for wrong hashing algorithm: " + e);
        }
    }
}