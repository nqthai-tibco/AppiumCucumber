package Basic.Utils;

import Basic.Common;

import java.io.*;
import java.util.Scanner;

public class FileUtils extends Common {

    public void saveEmailRegister(String... email) {
//        System.out.println(emailRegister);
        try {
            FileWriter myWriter = new FileWriter(new File("").getAbsoluteFile() + "\\src\\test\\resources\\Data\\Email.txt");
            if (email.length > 0)
                myWriter.write(email[0]);
            else
                myWriter.write(emailRegister);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getEmailRegister() {
//        System.out.println(emailRegister);

        String myObj = new File("").getAbsoluteFile() + "\\src\\test\\resources\\Data\\Email.txt";
        Scanner myReader = null;
        String data = "";
        try {
            myReader = new Scanner(new File(myObj));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();

        }
        return data;
    }
}
