package employeelist;

import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int user, counter = 0, user2;
        ArrayList<String> EmpInfo = new ArrayList<>();
        String Line = "", temp = "", temporary = "";
        Scanner input = new Scanner(System.in);
        String [] titles = {"Employee#", "Employee Name", "Martial Status", "Age", "Salary"};

        System.out.println("1. Open File");
        System.out.println("2. Save File");
        System.out.println("3. Add a Record");
        System.out.println("4. Delete a Record");
        System.out.println("5. Modify a Record");
        System.out.println("6. Display All");
        System.out.println("7. Quit");
        user = input.nextInt();

        while (user != 7) {
            if (user == 1) {
                BufferedReader ReadFile = new BufferedReader(new FileReader("Employee List\\EmployeeList.txt"));
                while ((Line = ReadFile.readLine()) != null) {
                    EmpInfo.add(Line);
                }
                ReadFile.close();
                System.out.println("\n------File Opened------\n");
                System.out.println("1. Open File");
                System.out.println("2. Save File");
                System.out.println("3. Add a Record");
                System.out.println("4. Delete a Record");
                System.out.println("5. Modify a Record");
                System.out.println("6. Display All");
                System.out.println("7. Quit");
                user = input.nextInt();
            }

            if (user == 2) {
                BufferedWriter WriteFile = new BufferedWriter(new FileWriter("Employee List\\EmployeeList.txt"));
                for (int intC = 0; intC < EmpInfo.size(); intC++) {
                    WriteFile.write(EmpInfo.get(intC));
                    WriteFile.newLine();
                }
                WriteFile.close();
                System.out.println("\n------File Saved------\n");
                System.out.println("1. Open File");
                System.out.println("2. Save File");
                System.out.println("3. Add a Record");
                System.out.println("4. Delete a Record");
                System.out.println("5. Modify a Record");
                System.out.println("6. Display All");
                System.out.println("7. Quit");
                user = input.nextInt();
            }

            if (user == 3) {
                System.out.println("\nInput Employee Number: ");
                temp += input.next() + ",";
                System.out.println("Input Employee Name: ");
                temp += input.next() + ",";
                System.out.println("Input Marital Status: ");
                temp += input.next() + ",";
                System.out.println("Input Age: ");
                temp += input.next() + ",";
                System.out.println("Input Salary: ");
                temp += input.next() + ",";
                EmpInfo.add(temp);
                System.out.println("\n------File Added------\n");
                System.out.println("1. Open File");
                System.out.println("2. Save File");
                System.out.println("3. Add a Record");
                System.out.println("4. Delete a Record");
                System.out.println("5. Modify a Record");
                System.out.println("6. Display All");
                System.out.println("7. Quit");
                user = input.nextInt();
            }

            if (user == 4) {
                System.out.println("\nWhich Record Would You Like To Remove?");
                for (int i = 0; i < EmpInfo.size(); i++){
                    temp = EmpInfo.get(i);
                    counter++;
                    for(int j = 5; j < temp.length(); j++){
                        if (temp.charAt(j)  != ','){
                            temporary += temp.charAt(j);
                        }else {
                            System.out.println(counter + ". " + temporary);
                            temporary = "";
                            break;
                        }
                    }
                }
                System.out.println();
                user2 = input.nextInt();
                EmpInfo.remove(user2-1);
                System.out.println("\n------File Removed------\n");
                System.out.println("1. Open File");
                System.out.println("2. Save File");
                System.out.println("3. Add a Record");
                System.out.println("4. Delete a Record");
                System.out.println("5. Modify a Record");
                System.out.println("6. Display All");
                System.out.println("7. Quit");
                user = input.nextInt();
                
            }

            if (user == 5) {
                temp = "";
                counter = 0;
            System.out.println("\nWhich Record would you like to modify?");
            for (int i = 0; i < EmpInfo.size(); i++){
                temp = EmpInfo.get(i);
                counter++;
                for(int j = 5; j < temp.length(); j++){
                    if (temp.charAt(j)  != ','){
                        temporary += temp.charAt(j);
                    }else {
                        System.out.println(counter + ". " + temporary);
                        temporary = "";
                        break;
                    }
                }
            }
            String b = ""; 
            int user7 = input.nextInt();
            System.out.println("\nInput Employee Number: ");
            b += input.next() + ",";
            System.out.println("Input Employee Name: ");
            b += input.next() + ",";
            System.out.println("Input Marital Status: ");
            b += input.next() + ",";
            System.out.println("Input Age: ");
            b += input.next() + ",";
            System.out.println("Input Salary: ");
            b+= input.next() + ",";
            EmpInfo.set(user7-1, b);

            System.out.println("\n------File Modified------\n");
            System.out.println("1. Open File");
            System.out.println("2. Save File");
            System.out.println("3. Add a Record");
            System.out.println("4. Delete a Record");
            System.out.println("5. Modify a Record");
            System.out.println("6. Display All");
            System.out.println("7. Quit");
            user = input.nextInt();
            }

            if (user == 6){
                System.out.println();
                for(int i = 0; i < titles.length; i++){
                    System.out.format("%-15s", titles[i]);
                }
                System.out.println();
                for (int i = 0; i < EmpInfo.size(); i++) {
                    String [] name = EmpInfo.get(i).split(",");
                    for (int j = 0; j < name.length; j++) {
                        System.out.format("%-15s", name[j]);
                    }
                    System.out.print("\n");
                }
                System.out.println("\n------File Displayed------\n");
            System.out.println("1. Open File");
            System.out.println("2. Save File");
            System.out.println("3. Add a Record");
            System.out.println("4. Delete a Record");
            System.out.println("5. Modify a Record");
            System.out.println("6. Display All");
            System.out.println("7. Quit");
            user = input.nextInt(); 
            }
        }
        input.close();
    }
}
