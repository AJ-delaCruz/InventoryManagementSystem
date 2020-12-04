/*
package View;

import Model.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//just a test
public class EmployeeTest {

    public ArrayList<Employee> load() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            File myFile = new File("employees.txt"); //reads file
            Scanner inputFile = new Scanner(myFile);

            */
/*int nameID;
            String pwd;*//*

            while (inputFile.hasNextLine()) {

                String line = inputFile.nextLine();
                String[] splitLine = line.split(" ");

                int nameID;
                String pwd;
                nameID = Integer.parseInt(splitLine[0]);
                pwd = splitLine[1];
                employees.add(new Employee(nameID, pwd));

            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        //System.out.println(employees);
        return employees;
    }

    public static void main(String[] args) {
        EmployeeTest test = new EmployeeTest();
        ArrayList<Employee> app = test.load();
      //  System.out.println(test.load());
        for (Employee x : app) {
            System.out.println(x.getAccountNumber() + " " + x.getPassword());

        }
    }


}
*/
