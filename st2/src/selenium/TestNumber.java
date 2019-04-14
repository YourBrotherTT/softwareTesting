package selenium;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNumber {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver(); 
	  baseUrl = "http://121.193.130.195:8800/login";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //等待一个元素被发现、命令完成，超出了设置的时间则跑出异常
	  driver.manage().window().maximize();
  }//打开网页

  @Test
  public void testNumber() throws Exception {
    driver.get(baseUrl + "/"); 
     
    InputExcel in = new InputExcel();
    List<People> list = in.importXLS();
    //读取excel表数据，并保存到list里面 
    for(int i = 0 ; i < list.size() ; i++) {
    	People thisOne = list.get(i); //当前list中进行比对的人
    	String passId = thisOne.id;	//3016218182
    	String passWd = passId.substring(4,10);	//218182
    	driver.findElement(By.name("id")).sendKeys(passId);
        driver.findElement(By.name("password")).sendKeys(passWd);
    	driver.findElement(By.id("btn_login")).click();
    	//登陆成功
    	assertEquals(thisOne.id, driver.findElement(By.id("student-id")).getText());
	    assertEquals(thisOne.name, driver.findElement(By.id("student-name")).getText());
	    assertEquals(thisOne.url, driver.findElement(By.id("student-git")).getText());
	  //比list中的人和当前网页上人的信息
	    driver.findElement(By.id("btn_logout")).click();
	    driver.findElement(By.id("btn_return")).click();
	    driver.findElement(By.name("id")).clear();
	    //退回到登陆界面
    	
	    System.out.println(thisOne.id + "完成");
    }
  }

  @After
  public void tearDown() throws Exception {
  }
  
}

