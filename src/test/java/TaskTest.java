package todo;

import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class TaskTest {

  @Rule
   public ClearRule clearRule = new ClearRule();

  @Test
  public void task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

  @Test
  public void task_instantiatesWithDescription_true(){
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }

  @Test
  public void isCompletedisFalseAfterInstantation_false() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(false, myTask.isCompleted());
  }

  @Test
  public void getCreateAt_instantiatesWithCurrentTime_today() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(),
                myTask.getCreatedAt().getDayOfWeek());
  } //getCreatedAt return LocalDateTime.now()

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Buy groceries");
    assertTrue(Task.all().contains(firstTask));
    assertTrue(Task.all().contains(secondTask));
  } // puts the 2 tasks into an array and the all method returns all objects in array

  @Test
  public void newId_tasksInstantiateWithAnID_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(Task.all().size(), myTask.getId());
    } //gets the array, then the number of ojects in the array (Size),
    //then id to identify this String


  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Buy groceries");
    assertEquals(Task.find(secondTask.getId()), secondTask);
    }

  @Test
  public void find_returnsNullWhenNoTaskFound_null() {
    assertTrue(Task.find(999) == null);
    }

  @Test
  public void clear_emptiesAllTasksFromArrayList() {
    Task myTask = new Task("Mow the lawn");
    Task.clear();
    assertEquals(Task.all().size(), 0);
  }

}
