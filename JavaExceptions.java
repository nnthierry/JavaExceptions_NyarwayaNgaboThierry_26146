import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaExceptions {

    public static void main(String[] args) {
        System.out.println("Demonstrating exception handling in a single file:\n");

        //Checked Exceptions
        IOException();
        FileNotFoundException();
        EOFException();
        SQLException();
        ClassNotFoundException();

        //Unchecked Exceptions
        ArithmeticException();
        NullPointerException();
        ArrayIndexOutOfBoundsException();
        ClassCastException();
        IllegalArgumentException();
        NumberFormatException();
    }

    //Attempt to read from a non-existent file
    public static void IOException() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("non_existent_file.txt"));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("IOException Caught: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Failed to close reader: " + e.getMessage());
            }
        }
    }

    //Try opening a non-existent file
    public static void FileNotFoundException() {
        try {
            FileReader file = new FileReader("missing_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("\nFileNotFoundException Caught: " + e.getMessage());
        }
    }

    //Attempt to read beyond the end of a file
    public static void EOFException() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("testfile.dat"))) {
            while (true) {
                System.out.println(dis.readInt());
            }
        } catch (EOFException e) {
            System.out.println("EOFException Caught: End of file reached.");
        } catch (IOException e) {
            System.out.println("\nIOfException Caught: " + e.getMessage());
        }
    }

    //Attempt to connect to a non-existent database
    public static void SQLException() {
        try {
            DriverManager.getConnection("jdbc:invalid_url", "user", "password");
        } catch (SQLException e) {
            System.out.println("\nSQLException Caught: " + e.getMessage());
        }
    }

    //Try loading a missing class
    public static void ClassNotFoundException() {
        try {
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("\nClassNotFoundException Caught: " + e.getMessage());
        }
    }

    //Attempt to divide by zero
    public static void ArithmeticException() {
        try {
            int result = 10 / 0;  // Division by zero will trigger ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("\nArithmeticException Caught: " + e.getMessage());
        }
    }

    //Attempt to access a null reference
    public static void NullPointerException() {
        try {
            String str = null;
            System.out.println(str.length());  // This will trigger NullPointerException
        } catch (NullPointerException e) {
            System.out.println("\nNullPointerException Caught: " + e.getMessage());
        }
    }

    //Attempt to access an invalid array index
    public static void ArrayIndexOutOfBoundsException() {
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);  // Invalid index access will trigger ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nArrayIndexOutOfBoundsException Caught: " + e.getMessage());
        }
    }

    //Invalid type casting
    public static void ClassCastException() {
        try {
            Object obj = Integer.valueOf(10);
            String str = (String) obj;  // Invalid cast will trigger ClassCastException
        } catch (ClassCastException e) {
            System.out.println("\nClassCastException Caught: " + e.getMessage());
        }
    }

    //Pass an invalid argument to a method
    public static void IllegalArgumentException() {
        try {
            setAge(-5);  // This will trigger IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("\nIllegalArgumentException Caught: " + e.getMessage());
        }
    }

    // Method that throws IllegalArgumentException if the argument is invalid
    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
    }

    //invalid string to number conversion
    public static void NumberFormatException() {
        try {
            int num = Integer.parseInt("invalid_number");  // This will trigger NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("\nNumberFormatException Caught: " + e.getMessage());
        }
    }
}
