package duke.main;

import duke.items.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UI {
    private static final String DEADLINE_TEMPLATE = "deadline <task> /by <YYYY-MM-DD>";
    private static final String EVENT_TEMPLATE = "event <task> /at <YYYY-MM-DD>";
    private static final String TODO_TEMPLATE = "todo read book";
    private static final String DATE_TEMPLATE = "<YYYY-MM-DD>";
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void list() {
        if (Task.getNumOfTasks() != 0){
            System.out.println("Here are the tasks in your list:");
        }
    }

    public static void listUpdate() {
        if (Task.getNumOfTasks() == 0){
            System.out.println("There are no tasks in your list");
        }
        else {
            System.out.println("Now you have " + Task.getNumOfTasks() + " tasks in the list.");
        }

    }

    public static void welcomeMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm duke.main.Duke\nWhat can I do for you?");
    }

    public static void InvalidCommandErrorMessage(){
        System.out.println(" ☹ OOPS!!! Invalid Command :-(");
    }
    public static void InvalidParameterLengthErrorMessage(String line){
        System.out.println(" ☹ OOPS!!! Insufficient number of inputs for command: " + line.split(" ")[0]);
        System.out.println(" Example inputs:");
        switch (line.split(" ")[0]){

        case ("deadline"):
            System.out.println(" \t " + DEADLINE_TEMPLATE);
            break;
        case ("event"):
            System.out.println(" \t " + EVENT_TEMPLATE);
            break;
        case ("todo"):
            System.out.println(" \t " + TODO_TEMPLATE);
            break;
        }
    }
    public static void InvalidDateErrorMessage(String line){
        String[] arr = line.split(" ");
        System.out.println(" ☹ OOPS!!! Invalid format for date: " + arr[arr.length-1]);
        System.out.println(" Input format:");
        System.out.println(" \t " + DATE_TEMPLATE);
    }

    public static void EventParameterErrorMessage(){
        System.out.println(" ☹ OOPS!!! For \"event\" command please input \"/at\"");
    }
    public static void DeadlineParameterErrorMessage(){
        System.out.println(" ☹ OOPS!!! For \"event\" command please input \"/by\"");
    }
    public static void InvalidIndexErrorMessage(){
        System.out.println(" ☹ OOPS!!! Index is out of range");
    }

    public static void byeMessage(){
        System.out.println("Bye. Hope to see you again soon!");
        UI.printLine();
    }

    public static String convertDateFormat(String date){
        LocalDate myDateObj = LocalDate.parse(date);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM-dd-yyyy ");
        return myDateObj.format(myFormatObj);
    }

}
