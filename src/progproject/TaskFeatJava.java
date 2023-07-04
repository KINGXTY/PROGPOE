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
import java.io.*;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.*;

public class TaskFeatJava{


public static int totalDuration;
public static int duration;

public static void main(String[] args)
{
String option = " ";
while (!option.equals("3"))
{
option = JOptionPane.showInputDialog("Welcome to EasyKanban" +"\nOption1) Add tasks" +"\nOption2) Show Report" +"\nOption3) Quit");

if (option.equals("1"))
{
totalDuration = 0;
String numberOfTask = JOptionPane.showInputDialog("How many tasks do you wish to enter?");
int InumberOfTask = Integer.parseInt(numberOfTask);

for (int i = 0; i < InumberOfTask; i++)
{
String taskName = JOptionPane.showInputDialog("Task Name");
String taskNumber = Integer.toString(i+1);
JOptionPane.showMessageDialog(null, taskNumber);
String taskDesc = JOptionPane.showInputDialog("Task Description");
if(DataStoreJava.checkTaskDescription(taskDesc))
{
while(DataStoreJava.checkTaskDescription(taskDesc))
{
taskDesc = JOptionPane.showInputDialog(null, "Task description may not be longer than 50 characters","", JOptionPane.ERROR_MESSAGE);
}
}
String devDetail = JOptionPane.showInputDialog("Developer Details");
String taskDuration = JOptionPane.showInputDialog("Task Duration");
duration = Integer.parseInt(taskDuration);
String taskID = DataStoreJava.createTaskID(taskName,taskNumber,devDetail);

String taskStatus = JOptionPane.showInputDialog("Option1) To Do" +"\nOption2) Done" +"\nOption3) Doing");

JOptionPane.showMessageDialog(null, DataStoreJava.printTaskDetails(taskStatus,devDetail,taskNumber,taskName,taskDesc,taskID,duration));
DataStoreJava.returnTotalHours();
}
JOptionPane.showMessageDialog(null, "The Total amount of hours spent on task is " + DataStoreJava.returnTotalHours() + " hours!");

}

if (option.equals("2"))
{
JOptionPane.showMessageDialog(null, "Coming Soon :)");
}
}

}
}
////////////////////////////////////////////////////////////////////////////////////////////////end of file////////////////////////////////////////////////////////////////////////////////
