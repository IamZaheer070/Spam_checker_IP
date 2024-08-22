package Spam_checker;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Spam_checker {

    public static void main(String[] args) {
        String iP = "";
        String theRest = "";
        int count = 0;
        Integer[] ipArray = new Integer[20];
        int index = 0;
        try (FileInputStream fin = new FileInputStream("log.txt");
                Reader in = new InputStreamReader(fin);
                BufferedReader bin = new BufferedReader(in);) {
            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                int i = entry.indexOf(' ');
                if (i != -1) {
                    ip = entry.substring(0, i);
                    theRest = entry.substring(i);
                }
                Scanner scan = new Scanner("log.txt");
                while (scan.hasNextLine()) {
                    final String lineFromFile = scan.nextLine();
                    if (lineFromFile.contains(iP)) {
                        count++;
                    }
                }
                IpArray[index] = count;
                index++;
                count = 0;
                if (isSpammer(iP)) {
                    System.out.println(iP + "this ip is known as spammer.");
                } else {
                    System.out.println(iP + " is valid");
                }
                Arrays.sort(IpArray, Collections.reverseOrder());
                System.out.println("Number of access for each IP");
                for (int a = 0; i < IpArray.length; a++) {
                    System.out.println("IpArray[" + a + "]: " + IpArray[a]);
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }

    private static boolean isSpammer(String iP) {
        try {
            InetAddress address = InetAddress.getByName(iP);
            byte[] quad = address.getAddress();
            String query = "sbl.spamhaus.org";
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}