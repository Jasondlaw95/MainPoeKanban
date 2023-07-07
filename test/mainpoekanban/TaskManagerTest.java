/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package mainpoekanban;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jason
 */
public class TaskManagerTest {
    
    public TaskManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task task = null;
        TaskManager instance = new TaskManager();
        instance.addTask(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTasks method, of class TaskManager.
     */
    @Test
    public void testGetTasks() {
        System.out.println("getTasks");
        TaskManager instance = new TaskManager();
        List<Task> expResult = null;
        List<Task> result = instance.getTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTasksWithStatusDone method, of class TaskManager.
     */
    @Test
    public void testDisplayTasksWithStatusDone() {
        System.out.println("displayTasksWithStatusDone");
        TaskManager instance = new TaskManager();
        instance.displayTasksWithStatusDone();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTaskWithLongestDuration method, of class TaskManager.
     */
    @Test
    public void testDisplayTaskWithLongestDuration() {
        System.out.println("displayTaskWithLongestDuration");
        TaskManager instance = new TaskManager();
        instance.displayTaskWithLongestDuration();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTaskByName method, of class TaskManager.
     */
    @Test
    public void testSearchTaskByName() {
        System.out.println("searchTaskByName");
        String taskName = "";
        TaskManager instance = new TaskManager();
        instance.searchTaskByName(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTasksByDeveloper method, of class TaskManager.
     */
    @Test
    public void testSearchTasksByDeveloper() {
        System.out.println("searchTasksByDeveloper");
        String developerName = "";
        TaskManager instance = new TaskManager();
        instance.searchTasksByDeveloper(developerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTaskByName method, of class TaskManager.
     */
    @Test
    public void testDeleteTaskByName() {
        System.out.println("deleteTaskByName");
        String taskName = "";
        TaskManager instance = new TaskManager();
        instance.deleteTaskByName(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTaskReport method, of class TaskManager.
     */
    @Test
    public void testDisplayTaskReport() {
        System.out.println("displayTaskReport");
        TaskManager instance = new TaskManager();
        instance.displayTaskReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
