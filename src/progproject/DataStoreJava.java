/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progproject;

/**
 *
 * @author tyres
 */
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.nio.Buffer;
import java.util.Locale;

public class DataStoreJava {
    public static boolean checkTaskDescription(String task) {
        return task.length() > 50; // Returns true if the description length is less than 50
    }

    public static String createTaskID(String taskName, String taskNumber, String developerDeets) {
        String taskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + developerDeets.substring(developerDeets.length() - 3);
        // Declares string task ID with the formatting for ID
        return taskID.toUpperCase(); // Makes task ID all uppercase
    }

    public static int returnTotalHours() {
        int duration = 0;
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
        StringBuilder output = new StringBuilder();
        // Loop till size of list and display data using get
        for (int i = 0; i < arrDeveloper.size(); i++) {
            output.append("\nTask #").append(arrTaskid.get(i));
            output.append("\nDeveloper Name: ").append(arrDeveloper.get(i));
            output.append("\nTask Name: ").append(arrTasks.get(i));
            output.append("\nTask Duration: ").append(arrDuration.get(i));
            output.append("\nStatus: ").append(arrStatus.get(i));
            output.append("\n");
        }
        JOptionPane.showMessageDialog(null, output.toString(), "All Tasks", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayTaskWithStatusDone() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arrDeveloper.size(); i++) {
            // Loop and compare status with Done
            if (arrStatus.get(i).equals("Done")) {
                // If that task is found, append that task detail
                output.append("\nDeveloper Name: ").append(arrDeveloper.get(i));
                output.append("\nTask Name: ").append(arrTasks.get(i));
                output.append("\nTask Duration: ").append(arrDuration.get(i));
                output.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, output.toString(), "Tasks with Status Done", JOptionPane.INFORMATION_MESSAGE);
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
        StringBuilder output = new StringBuilder();
        output.append("\nDeveloper Name: ").append(arrDeveloper.get(index));
        output.append("\nTask Name: ").append(arrTasks.get(index));
        output.append("\nTask Duration: ").append(arrDuration.get(index));
        JOptionPane.showMessageDialog(null, output.toString(), "Task with Longest Duration", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No Tasks Found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder output = new StringBuilder();
            output.append("\nDeveloper Name: ").append(arrDeveloper.get(index));
            output.append("\nTask Name: ").append(arrTasks.get(index));
            output.append("\nTask Duration: ").append(arrDuration.get(index));
            JOptionPane.showMessageDialog(null, output.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No Developer Found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder output = new StringBuilder();
            output.append("\nTask Name: ").append(arrTasks.get(index));
            JOptionPane.showMessageDialog(null, output.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No Task Found!", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Delete data using index
            arrDeveloper.remove(index);
            arrTasks.remove(index);
            arrTaskid.remove(index);
            arrDuration.remove(index);
            arrStatus.remove(index);
            JOptionPane.showMessageDialog(null, "Task Deleted", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int choice = 0;

        do {
            String[] options = {"Create Task", "Display All Tasks", "Display Tasks with Status Done", "Display Task with Longest Duration", "Search Task", "Find Tasks by Developer", "Delete Task", "Exit"};
            choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Task Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Create Task
                    String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
                    String taskNumber = JOptionPane.showInputDialog(null, "Enter task number:");
                    String developerDeets = JOptionPane.showInputDialog(null, "Enter developer details:");
                    String taskDescription = JOptionPane.showInputDialog(null, "Enter task description:");
                    int duration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter task duration (in hours):"));

                    // Generate task ID and check task description
                    String taskID = createTaskID(taskName, taskNumber, developerDeets);
                    boolean validDescription = checkTaskDescription(taskDescription);

                    if (validDescription) {
                        String[] statusOptions = {"To Do", "Done", "Doing"};
                        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.PLAIN_MESSAGE, null, statusOptions, statusOptions[0]);

                        // Add task to the arrays
                        arrDeveloper.add(developerDeets);
                        arrTasks.add(taskName);
                        arrTaskid.add(arrTasks.size());
                        arrDuration.add(duration);
                        arrStatus.add(taskStatus);

                        JOptionPane.showMessageDialog(null, "Task created successfully!", "Task Management System", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid task description! Please enter a description with more than 50 characters.", "Task Management System", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case 1: // Display All Tasks
                    displayTasks();
                    break;

                case 2: // Display Tasks with Status Done
                    displayTaskWithStatusDone();
                    break;

                case 3: // Display Task with Longest Duration
                    displayLongestDuration();
                    break;

                case 4: // Search Task
                    String taskToSearch = JOptionPane.showInputDialog(null, "Enter task name to search:");
                    searchTask(taskToSearch);
                    break;

                case 5: // Find Tasks by Developer
                    String developerToSearch = JOptionPane.showInputDialog(null, "Enter developer name:");
                    findTasks(developerToSearch);
                    break;

                case 6: // Delete Task
                    String taskToDelete = JOptionPane.showInputDialog(null, "Enter task name to delete:");
                    deleteTask(taskToDelete);
                    break;

                case 7: // Exit
                    JOptionPane.showMessageDialog(null, "Thank you for using the Task Management System!", "Task Management System", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please choose a valid option.", "Task Management System", JOptionPane.ERROR_MESSAGE);
            }
        } while (choice != 7);
    }
}

    
//////////////////////////////////////////////////////////////////////////////end of file////////////////////////////////////////////////////////////////////////////////////////////////
