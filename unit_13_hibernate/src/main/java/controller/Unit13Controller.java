package controller;

import service.Unit13Service;

import java.util.Scanner;

public class Unit13Controller {
    private static final Scanner in = new Scanner(System.in);

    public static void run(){
        int choice = 11;
        while (choice != 0) {
            System.out.println(
                    """
                            *** OPTIONS ***
                             1 - find next lesson for student by their name
                             0 - EXIT
                            **** CHOSE OPTION TO PROCEED ****
                            """);
            try {
                if (in.hasNextInt()) choice = in.nextInt();

            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                in.nextLine();
                if (in.hasNextInt()) choice = in.nextInt();
                else choice = 11;
            }

            switch (choice) {
                case 1:
                    findLessonForStudent();
                    break;

                default: break;
            }
        }
    }
    public static  void findLessonForStudent(){
        String name="";
        in.nextLine();
        System.out.println("Enter student full name to find next lesson for them");
        if (in.hasNextLine()) {
            name = in.nextLine();
            System.out.println(new Unit13Service().findNextLessonForStudent(name));
        }
    }
}
