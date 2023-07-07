/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package progproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.*;
import org.junit.Test;



public class DataStoreJavaTest {
    
    public DataStoreJavaTest() {
    }

    @Test
   public void testDisplayTasks() {
        // Add some sample data to the arrays
        DataStoreJava.arrDeveloper.add("Mike Smith");
        DataStoreJava.arrTasks.add("Create Login");
        DataStoreJava.arrTaskid.add(1);
        DataStoreJava.arrDuration.add(5);
        DataStoreJava.arrStatus.add("To do");

        DataStoreJava.arrDeveloper.add("Edward Harrison");
        DataStoreJava.arrTasks.add("Create Add Features");
        DataStoreJava.arrTaskid.add(2);
        DataStoreJava.arrDuration.add(8);
        DataStoreJava.arrStatus.add("Doing");

        // Redirect System.out to a ByteArrayOutputStream for capturing output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        // Call the displayTasks() method
        DataStoreJava.displayTasks();

        // Restore the original System.out
        System.setOut(originalOut);

        // Get the captured output
        String output = outputStream.toString();

        // Define the expected output
        String expectedOutput = "\nTask #1\nDeveloper Name: Mike Smith\nTask Name: Create Login\nTask Duration: 8\nStatus: To do\n"
                + "\nTask #2\nDeveloper Name: Edward Harrison\nTask Name: Create Add Features\nTask Duration: 2\nStatus: Doing\n";

        // Compare the expected output with the actual output
        assertEquals(expectedOutput, output);
    }

    

    @Test
   public void testDisplayLongestDuration() {
        // Test data
        DataStoreJava.arrDeveloper.add("Mike Smith");
        DataStoreJava.arrTasks.add("Create Login");
        DataStoreJava.arrDuration.add(5);
        DataStoreJava.arrStatus.add("To Do");

        DataStoreJava.arrDeveloper.add("Edward Harrison");
        DataStoreJava.arrTasks.add("Create Add Features");
        DataStoreJava.arrDuration.add(8);
        DataStoreJava.arrStatus.add("Doing");

        DataStoreJava.arrDeveloper.add("Samantha Paulson");
        DataStoreJava.arrTasks.add("Create Reports");
        DataStoreJava.arrDuration.add(8);
        DataStoreJava.arrStatus.add("Doing");

        DataStoreJava.arrDeveloper.add("Glenda Oberholzer");
        DataStoreJava.arrTasks.add("Add Arrays");
        DataStoreJava.arrDuration.add(11);
        DataStoreJava.arrStatus.add("To Do");

        // Expected result
        DataStoreJava.displayLongestDuration();
        String expectedOutput = 
                "\nDeveloper Name: Glenda Oberholzer"
                + "\nTask Name: Task 4"
                + "\nTask Duration: 11";

       
       assertEquals(expectedOutput, JOptionPaneUtil.getShownMessage());
    }

    @Test
    public void testSearchTask() {
        // Test data
        DataStoreJava.arrDeveloper.clear();
        DataStoreJava.arrTasks.clear();
        DataStoreJava.arrDuration.clear();
        DataStoreJava.arrStatus.clear();
        
        DataStoreJava.arrDeveloper.add("Mike Smith");
        DataStoreJava.arrTasks.add("Create Login");
        DataStoreJava.arrDuration.add(4);
        DataStoreJava.arrStatus.add("Done");
        
        String taskToSearch = "Create Login";
        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("\nDeveloper Name: ").append(DataStoreJava.arrDeveloper.get(0));
        expectedOutput.append("\nTask Name: ").append(DataStoreJava.arrTasks.get(0));
        expectedOutput.append("\nTask Duration: ").append(DataStoreJava.arrDuration.get(0));
        StringBuilder output = new StringBuilder();
        DataStoreJava.searchTask(taskToSearch);
        String devname = "Mike Smith";
        String expectedTask = "Create Login";
       
    }

    @Test
     public void testFindTasks() {
        // Test data
        DataStoreJava.arrDeveloper.add("Glenda");
        DataStoreJava.arrTasks.add("Rainbow");
        DataStoreJava.arrDuration.add(8);
        
        DataStoreJava.arrDeveloper.add("Samantha Paulson");
        DataStoreJava.arrTasks.add("Create Reports");
        DataStoreJava.arrDuration.add(12);
        
        DataStoreJava.arrDeveloper.add("Mike Smith");
        DataStoreJava.arrTasks.add("Implement Feature");
        DataStoreJava.arrDuration.add(16);
        
        
        String devname = "Samantha Paulson";
        String expectedTask = "Create Reports";
        DataStoreJava.findTasks(devname);
        
       }

    @Test
    public void testDeleteTask() {
       
        DataStoreJava dataStore = new DataStoreJava();
        
        String taskName = "Create Reports";
        String taskNumber = "1";
        String developerDeets = "Samantha Paulson";
        String taskDescription = "Sample task description";
        int duration = 4;
        dataStore.arrDeveloper.add(developerDeets);
        dataStore.arrTasks.add(taskName);
        dataStore.arrTaskid.add(dataStore.arrTasks.size());
        dataStore.arrDuration.add(duration);
        dataStore.arrStatus.add("To Do");
        dataStore.deleteTask(taskName);
        assertFalse(dataStore.arrTasks.contains(taskName));
    }


    
    
}
