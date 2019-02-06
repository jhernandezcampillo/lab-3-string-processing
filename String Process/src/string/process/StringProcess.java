/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.process;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Judith
 */
public class StringProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> records = new ArrayList<>();
        readData(records, args[0]);
        showInfo(records);
    
    }
    
    public static void readData(ArrayList<String> info, String filename){
        try {
            Scanner scnr = new Scanner(new File(filename));

            while (scnr.hasNext()) {
                String[] data = scnr.nextLine().split(",");
                if (validName(data[0].trim()) && validName(data[1].trim()) && validGender(data[2].trim()) && validAge(data[3].trim()) && validPhone(data[4].trim()) && validEmail(data[5].trim())) {
                    String form = String.format("%-20s%-20s%-20s%-20s%-20s%-20s", data[0], data[1], data[2], data[3], data[4], data[5]);
                    info.add(form);
                } else if (!validName(data[0].trim()) || !validName(data[1].trim()) || !validGender(data[2].trim()) || !validAge(data[3].trim()) || !validPhone(data[4].trim()) || !validEmail(data[5].trim())) {
                    boolean[] checker = new boolean[6];

                    checker[0] = validName(data[0].trim());
                    checker[1] = validName(data[1].trim());
                    checker[2] = validGender(data[2].trim());
                    checker[3] = validAge(data[3].trim());
                    checker[4] = validPhone(data[4].trim());
                    checker[5] = validEmail(data[5].trim());

                    for (int i = 0; i < checker.length; i++) {
                        if (checker[i] == false) {
                            data[i] = " ";
                        }

                    }
                    String form = String.format("%-20s%-20s%-20s%-20s%-20s%-20s", data[0], data[1], data[2], data[3], data[4], data[5]);
                    info.add(form);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.print("Error");
        }

    }

    public static boolean validName(String name) {

        boolean valName = false;
        for (int i = 0; i < name.length(); i++) {
            valName = (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z');
        }
        return valName;
    }

    public static boolean validGender(String gender) {
        boolean valGender = false;
        valGender = gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female");

        return valGender;

    }

    public static boolean validAge(String age) {
        boolean valAge = false;

        try {
            if (Integer.parseInt(age) >= 1 && Integer.parseInt(age) <= 130) {
                valAge = true;
                return valAge;

            } else {
                return valAge;

            }
        } catch (NumberFormatException ex) {
            System.out.println();
            return false;
        }
    }

    public static boolean validPhone(String num) {
        char temp = ' ';
        int counter = 0;

        for (int i = 0; i < num.length(); i++) {
            temp = num.charAt(i);
            if (Character.isDigit(temp)) {
                counter++;
            }
        }

        if (counter == 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validEmail(String email) {
        int specialNum = 0;
        char temp = ' ';

        if (email.charAt(0) >= 'A' && email.charAt(0) <= 'Z') {

            for (int i = 0; i < email.length(); i++) {
                temp = email.charAt(i);
                if (Character.isLetterOrDigit(temp) || email.contains("@") || email.contains(".")) {

                } else {
                    specialNum++;
                }
            }
            if (specialNum >= 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public static void showInfo(ArrayList list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}



      
    

