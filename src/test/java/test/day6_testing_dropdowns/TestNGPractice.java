package test.day6_testing_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {
   // public static void main(String[] args) {}
    @BeforeClass
    public void before_class(){
        System.out.println("Before class is running");
    }
    @AfterClass
    public void after_class(){
        System.out.println("After class is running");
    }
    @BeforeMethod
    public void before_method(){
        System.out.println("Before method is running");
    }
    @AfterMethod
    public void after_method(){
        System.out.println("After method is running");
    }
 @Test
  public void test1(){
      System.out.println("Test1 is running");
      String actualTitle="Homepage";
      String expectedResult="Homepage";
     Assert.assertEquals(actualTitle,expectedResult,"Verification Test Failed");
    //  if(actualTitle.equals(expectedResult)){
     //     System.out.println("Title verification passed");
     // }else {
    //      System.out.println("Title verification failed");
    //  }
  }
  @Ignore
public void test2(){
    System.out.println("Test2 is running");

      Assert.assertEquals("string1","string2","Test2 failed");
}
@Test
public void test3(){
    System.out.println("Test3 is running...");
    String actrualTitle="Amazon prime";
    String expectedTitle="prime";
   // Assert.assertTrue(actrualTitle.contains(expectedTitle),"Test3 Failed");
    Assert.assertFalse(actrualTitle.contains(expectedTitle),"Test3 Failed(2)");
}
}
