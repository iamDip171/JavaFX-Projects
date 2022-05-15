package com.example.mybalance;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class FileIO {

    static boolean binarySearch (String str, ArrayList<String> list) {
        int low = 0 ;
        int high = list.size()-1 ;
        int mid=0 ;

        while (low <= high) {
            mid = (low + high) / 2 ;
            if (list.get(mid).equals(str)) {
                return true ;
            }
            else if (str.compareTo(list.get(mid)) < 0) {
                high = mid-1 ;
            }else {
                low = mid+1 ;
            }
        }

        return false ;
    }

    public void createFile (String file_name, String folder_name) {
        String str = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+folder_name + "\\"+ file_name+ ".txt" ;
        try {
            File f = new File(str) ;
            boolean b = f.createNewFile();
        }catch (Exception e) {
        }
    }
    public void createFolder (String file_name, String passcode) {

        SimpleDateFormat fore = new SimpleDateFormat("dd-MM-yyyy") ;
        Date d = new Date() ;
        String date = fore.format(d) ;

        String str = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode ;
        String dailyCost = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\DailyCost" ;
        String dateFile = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\DailyCost\\" + date + ".txt" ;
        String balance = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Balance.txt" ;
        String cost = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost" ;
        String saturday = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost\\Saturday.txt" ;
        String sunday = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost\\Sunday.txt" ;
        String monday = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost\\Monday.txt" ;
        String tuesday = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost\\Tuesday.txt" ;
        String wednesday = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost\\Wednesday.txt" ;
        String thursday = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost\\Thursday.txt" ;
        String friday = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name+ "_" + passcode + "\\Cost\\Friday.txt" ;

        try {
            File f = new File(str) ;
            boolean b = f.mkdir();

            new File(balance).createNewFile() ;
            new File(dailyCost).mkdir() ;
            new File(dateFile).createNewFile() ;
            new File (cost).mkdir() ;
            new File(saturday).createNewFile() ;
            new File(sunday).createNewFile() ;
            new File(monday).createNewFile() ;
            new File(tuesday).createNewFile() ;
            new File(wednesday).createNewFile() ;
            new File(thursday).createNewFile() ;
            new File(friday).createNewFile() ;

            writeIntoFile(file_name+"_"+passcode, "0");
            writeIntoFileC(file_name + "_" + passcode, "0", "Saturday");
            writeIntoFileC(file_name + "_" + passcode, "0", "Sunday");
            writeIntoFileC(file_name + "_" + passcode, "0", "Monday");
            writeIntoFileC(file_name + "_" + passcode, "0", "Tuesday");
            writeIntoFileC(file_name + "_" + passcode, "0", "Thursday");
            writeIntoFileC(file_name + "_" + passcode, "0", "Friday");
            writeIntoFileC(file_name + "_" + passcode, "0", "Wednesday");

        }catch (Exception e) {
            System.out.println("File alraedy created");
        }
    }


    public static int fletchCost (String file_name, String day) {
        int cost = 0 ;
        try {
            String str = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ file_name + "\\DailyCost\\" + day + ".txt"  ;
            BufferedReader b = new BufferedReader(new FileReader(str)) ;
            String line ;

            while ((line = b.readLine()) != null) {
                String a[] = line.split("_") ;
                cost+= Integer.parseInt(a[1]) ;
            }
            b.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return cost ;
    }

    public static void writeIntoFile (String folder_name, String number) {
        String file_name = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+folder_name + "\\Balance.txt" ;
        System.out.println(file_name);
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(file_name)) ;
            /*String line ;

            for (int i=0; i<list.size(); i++) {
                w.write(list.get(i) + "\n");
            }*/

            System.out.println(number);

            w.write(number);

            w.close();

        }catch (Exception e) {}
    }

    public static void writeIntoFileC (String folder_name, String number, String day) {


        String file_name = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+folder_name + "\\Cost\\" + day + ".txt" ;

        //System.out.println(file_name);
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(file_name)) ;
            /*String line ;

            for (int i=0; i<list.size(); i++) {
                w.write(list.get(i) + "\n");
            }*/

            System.out.println(number);

            w.write(number + "\n");

            w.close();

        }catch (Exception e) {}
    }

    public static String fletchBalance (String folder_name) {
        String folder = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ folder_name + "\\Balance.txt" ;
        System.out.println(folder);
        File f =  new File(folder) ;
        String balance = "0" ;
        try {
            BufferedReader rddr = new BufferedReader(new FileReader(f)) ;
            balance = rddr.readLine();
            rddr.close();
        }catch (Exception e) {}

        return balance ;
    }

    public static void appendIntoFile (String folder_name, String costcause, String cost, String date) {
        String name = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ folder_name + "\\DailyCost\\" + date + ".txt" ;
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(name, true)) ;
            w.write(costcause + "_" + cost + "\n");
            w.close();
        }catch (Exception e) {
            System.out.println("problem in FILE");
            e.printStackTrace();
        }
    }
    public static boolean searchUser (String str) {
        boolean found = false ;
        try {
            String s = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database" ;
            File f = new File(s) ;
            String arr[] = f.list() ;
            ArrayList<String> lis = new ArrayList<>() ;
            for (int i=0; i<arr.length; i++) lis.add(arr[i]) ;
            Collections.sort (lis) ;
            //System.out.println(lis);
            if (binarySearch(str, lis)) found = true ;
        }catch (Exception e) {}

        return found ;
    }

}
