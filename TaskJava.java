/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progpoe;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.nio.Buffer;
import java.util.Locale;

public class TaskJava {
    public static boolean checkTaskDescription(String task) {
        return task.length() > 50; // Returns true if the description length is less than 50
    }

    public static String createTaskID(String taskName, String taskNumber, String developerDeets) {
        String taskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + developerDeets.substring(developerDeets.length() - 3);
        // Declares string task ID with the formatting for ID
        return taskID.toUpperCase(); // Makes task ID all uppercase
    }
    
    
    public static int returnTotalHours()
    {
    int duration=0;
    int totalDuration = duration;
    return totalDuration;//returns total hours of all task

    }

    public static String printTaskDetails(String taskStatus, String developerDeets, String taskNumber, String taskName, String taskDescription, String taskID, int duration) {
        // Creates a selection menu depending on whether the user selects to do, done, or doing
        String status = "";

        if (taskStatus.equals("1")) {
            status = "To Do";
        }
        if (taskStatus.equals("2")) {
            status = "Done";
        }
        if (taskStatus.equals("3")) {
            status = "Doing";
        }

        return "Task Status: " + status
                + "\nDeveloper Details: " + developerDeets
                + "\nTask Number: " + taskNumber
                + "\nTask Name: " + taskName
                + "\nTask Description: " + taskDescription
                + "\nTask ID: " + taskID
                + "\nDuration: " + duration;
        // Returns the task details in a formatted string
    }

    // Arrays to store individual developer data
    static ArrayList<String> arrDeveloper = new ArrayList<String>(); // Store developer names
    static ArrayList<String> arrTasks = new ArrayList<String>(); // Store task names
    static ArrayList<Integer> arrTaskid = new ArrayList<Integer>(); // Store task ids
    static ArrayList<Integer> arrDuration = new ArrayList<Integer>(); // Store durations
    static ArrayList<String> arrStatus = new ArrayList<String>(); // Store status

    // Display all tasks
    public static void displayTasks() {
        // Loop till size of list and display data using get
        for (int i = 0; i < arrDeveloper.size(); i++) {
            System.out.println("\nTask #" + arrTaskid.get(i));
            System.out.println("Developer Name: " + arrDeveloper.get(i));
            System.out.println("Task Name: " + arrTasks.get(i));
            System.out.println("Task Duration: " + arrDuration.get(i));
            System.out.println("Status: " + arrStatus.get(i));
        }
    }

    public static void displayTaskWithStatusDone() {
        for (int i = 0; i < arrDeveloper.size(); i++) {
            // Loop and compare status with Done
            if (arrStatus.get(i).equals("Done")) {
                // If that task is found, display that task detail
                System.out.println("\nDeveloper Name: " + arrDeveloper.get(i));
                System.out.println("Task Name: " + arrTasks.get(i));
                System.out.println("Task Duration: " + arrDuration.get(i));
            }
        }
    }

    public static void displayLongestDuration() {
        // Use some flags
        int longDur = 0;
        int longID = 0;
        int index = 0;
        for (int i = 0; i < arrDeveloper.size(); i++) {
            if (arrDuration.get(i) > longDur) {
                // Loop and compare if task duration is greater
                longDur = arrDuration.get(i);
                longID = arrTaskid.get(i);
                index = i;
            }
        }
        // At the end of the loop, we can use the index to display the detail
        System.out.println("\nDeveloper Name: " + arrDeveloper.get(index));
        System.out.println("Task Name: " + arrTasks.get(index));
        System.out.println("Task Duration: " + arrDuration.get(index));
    }

    // Function to search for a task with the given task name
    public static void searchTask(String task) {
        int index = -1;
        for (int i = 0; i < arrDeveloper.size(); i++) {
            // Loop and compare with the task
            if (arrTasks.get(i).equals(task)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("\nNo Tasks Found!");
        } else {
            System.out.println("\nDeveloper Name: " + arrDeveloper.get(index));
            System.out.println("Task Name: " + arrTasks.get(index));
            System.out.println("Task Duration: " + arrDuration.get(index));
        }
    }

    public static void findTasks(String devname) {
        int index = -1;
        for (int i = 0; i < arrDeveloper.size(); i++) {
            if (arrDeveloper.get(i).equals(devname)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("No Developer Found!");
        } else {
            System.out.println("Task Name: " + arrTasks.get(index));
        }
    }

    public static void deleteTask(String task) {
        int index = -1;
        for (int i = 0; i < arrDeveloper.size(); i++) {
            if (arrTasks.get(i).equals(task)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("No Task Found!");
        } else {
            // Delete data using index
            arrDeveloper.remove(index);
            arrTasks.remove(index);
            arrTaskid.remove(index);
            arrDuration.remove(index);
            arrStatus.remove(index);
            System.out.println("Task Deleted");
        }
    }

    public static void main(String ar[]) {
        // Add developers
        // Task 1
        arrDeveloper.add("Mike Smith");
        arrTasks.add("Create Login");
        arrTaskid.add(1);
        arrDuration.add(5);
        arrStatus.add("To Do");

        // Task 2
        arrDeveloper.add("Edward Harrison");
        arrTasks.add("Create Add Features");
        arrTaskid.add(2);
        arrDuration.add(8);
        arrStatus.add("Doing");

        // Task 3
        arrDeveloper.add("Samantha Paulson");
        arrTasks.add("Create Reports");
        arrTaskid.add(3);
        arrDuration.add(2);
        arrStatus.add("Done");

        // Task 4
        arrDeveloper.add("Glenda Oberholzer");
        arrTasks.add("Add Arrays");
        arrTaskid.add(4);
        arrDuration.add(11);
        arrStatus.add("To Do");

        // Display all tasks
        System.out.println("\n---- All Tasks ----");
        displayTasks();

        // Display tasks with status "Done"
        System.out.println("\n---- Tasks with Status Done ----");
        displayTaskWithStatusDone();

        // Display developer with the longest duration
        System.out.println("\n---- Developer with Longest Duration ----");
        displayLongestDuration();

        // Search for tasks
        System.out.println("\n---- Search Task ----");
        searchTask("Check Reports");
        searchTask("Create Reports");

        // Get tasks of a developer
        System.out.println("\n---- Developer Tasks ----");
        findTasks("Glenda Oberholzer");

        // Deleting a task
        System.out.println("\n---- Deleting Task ----");
        deleteTask("Create Login");
        deleteTask("Create Reports");

        // Display all tasks
        System.out.println("\n---- All Tasks ----");
        displayTasks();
    }
}
//////////////////////////////////////////////////////////////////////////////end of file////////////////////////////////////////////////////////////////////////////////////////////////