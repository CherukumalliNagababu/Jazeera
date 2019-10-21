package jazeeraModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.Gson;

import groovy.transform.stc.PickAnyArgumentHint;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.CardDetails;
import pageObjects.Database;
import pageObjects.JazeeraPage;
import pageObjects.PageUtils;
import pageObjects.Pax;





public class PassengerDetailsJZ {
	
	//DOB
	
	
	
	static String countryName;
	static String countryCode;
	 
	static String infant1_dof_d;
	static String infant1_dof_m;
	static String infant1_dof_y;
	
	
	static String infant2_dof_d;
	static String infant2_dof_m;
	static String infant2_dof_y;
	
	
	static String infant3_dof_d;
	static String infant3_dof_m;
	static String infant3_dof_y;
	
	
	static String infant4_dof_d;
	static String infant4_dof_m;
	static String infant4_dof_y;
	
	
		 
	
	 
	
	
	
	
	
	
	static String adult_1_Title;
	static String adult_1_firstname;
	static String adult_1_lastname;
	static String adult_1_Gender;
	
	
	static String adult_2_Title;
	static String adult_2_firstname;
	static String adult_2_lastname;
	static String adult_2_Gender;
	
	
	static String adult_3_Title;
	static String adult_3_lastname;
	static String adult_3_firstname;
	static String adult_3_Gender;
	
	
	static String adult_4_Title;
	static String adult_4_lastname;
	static String adult_4_firstname;
	static String adult_4_Gender;
	
	
	static String adult_5_Title;
	static String adult_5_lastname;
	static String adult_5_firstname;
	static String adult_5_Gender;
	
	
	static String adult_6_Title;
	static String adult_6_lastname;
	static String adult_6_firstname;
	static String adult_6_Gender;
	
	static String adult_7_Title;
	static String adult_7_lastname;
	static String adult_7_firstname;
	static String adult_7_Gender;
	
	
	static String adult_8_Title;
	static String adult_8_lastname;
	static String adult_8_firstname;
	static String adult_8_Gender;
	
	
	static String adult_9_Title;
	static String adult_9_lastname;
	static String adult_9_firstname;
	static String adult_9_Gender;
	
	
	
	
	
	static String child_1_Title;
	static String child_1_firstname;
	static String child_1_lastname;
	static String child_1_Gender;
	
	
	static String child_2_Title;
	static String child_2_firstname;
	static String child_2_lastname;
	static String child_2_Gender;
	
	
	static String child_3_Title;
	static String child_3_firstname;
	static String child_3_lastname;
	static String child_3_Gender;
	
	
	static String child_4_Title;
	static String child_4_firstname;
	static String child_4_lastname;
	static String child_4_Gender;
	
	
	static String child_5_Title;
	static String child_5_firstname;
	static String child_5_lastname;
	static String child_5_Gender;
	
	
	static String child_6_Title;
	static String child_6_firstname;
	static String child_6_lastname;
	static String child_6_Gender;
	
	
	static String child_7_Title;
	static String child_7_firstname;
	static String child_7_lastname;
	static String child_7_Gender;
	
	
	static String child_8_Title;
	static String child_8_firstname;
	static String child_8_lastname;
	static String child_8_Gender;
	
	static String infant_1_Title;
	static String infant_1_firstname;
	static String infant_1_lastname;
	static String infant_1_Gender;
	
	
	static String infant_2_Title;
	static String infant_2_firstname;
	static String infant_2_lastname;
	static String infant_2_Gender;
	
	
	static String infant_3_Title;
	static String infant_3_firstname;
	static String infant_3_lastname;
	static String infant_3_Gender;
	
	
	static String infant_4_Title;
	static String infant_4_firstname;
	static String infant_4_lastname;
	static String infant_4_Gender;
	
	
	
	
	static String phoneNumber;
	static String emailId;
	static String CountryCode;
	static String mobileCode;
	static String CityName;
	static WebDriver driver;
	
	static String CustomeremailId;
	static String ProcessIdValue="";
	static String emailWithCustomerName;
	public static void ENTER() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		/*robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);*/
		
		
		
	}
	
    public static void adult1(Database  PnrDetails) throws Exception {
		PageUtils.isElementLocated(driver,	By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_0"));
		
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);

		PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_1());
		PageUtils.selectByVisibleText(JazeeraPage.drp_title_1(), adult_1_Title);

		JazeeraPage.firstname_1().sendKeys(adult_1_firstname);
		JazeeraPage.lastname_1().sendKeys(adult_1_lastname);
		
		PageUtils.isElementVisibil(driver, JazeeraPage.gender_1());
		PageUtils.selectByVisibleText(JazeeraPage.gender_1(), adult_1_Gender);
		 
		
        
}
public static void adult2() throws Exception {
    
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_2());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_2(), adult_2_Title);

	JazeeraPage.firstname_2().sendKeys(adult_2_firstname);
	JazeeraPage.lastname_2().sendKeys(adult_2_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_2());
	PageUtils.selectByVisibleText(JazeeraPage.gender_2(), adult_2_Gender);
	 
			
}
	
	
	
   


public static void adult3() throws Exception {
	

	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_3());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_3(), adult_3_Title);

	JazeeraPage.firstname_3().sendKeys(adult_3_firstname);
	JazeeraPage.lastname_3().sendKeys(adult_3_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_3());
	PageUtils.selectByVisibleText(JazeeraPage.gender_3(), adult_3_Gender);
	 

	
}
		
	
	
	
   
public static void adult4() throws Exception {
	
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_4());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_4(), adult_4_Title);

	JazeeraPage.firstname_4().sendKeys(adult_4_firstname);
	JazeeraPage.lastname_4().sendKeys(adult_4_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_4());
	PageUtils.selectByVisibleText(JazeeraPage.gender_4(), adult_4_Gender);
	 
    
}

public static void adult5() throws Exception {
	
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_5());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_5(), adult_5_Title);

	JazeeraPage.firstname_5().sendKeys(adult_5_firstname);
	JazeeraPage.lastname_5().sendKeys(adult_5_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_5());
	PageUtils.selectByVisibleText(JazeeraPage.gender_5(), adult_5_Gender);
	 
	
   
}

public static void adult6() throws Exception {
	

	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_6());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_6(), adult_6_Title);

	JazeeraPage.firstname_6().sendKeys(adult_6_firstname);
	JazeeraPage.lastname_6().sendKeys(adult_6_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_6());
	PageUtils.selectByVisibleText(JazeeraPage.gender_6(), adult_6_Gender);
	 
   
}
public static void adult7() throws Exception {
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_7());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_7(), adult_7_Title);

	JazeeraPage.firstname_7().sendKeys(adult_7_firstname);
	JazeeraPage.lastname_7().sendKeys(adult_7_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_7());
	PageUtils.selectByVisibleText(JazeeraPage.gender_7(), adult_7_Gender);
	 
		
}
			
		
	
	
   

public static void adult8() throws Exception {
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_8());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_8(), adult_8_Title);

	JazeeraPage.firstname_8().sendKeys(adult_8_firstname);
	JazeeraPage.lastname_8().sendKeys(adult_8_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_8());
	PageUtils.selectByVisibleText(JazeeraPage.gender_8(), adult_8_Gender);
	 
			

		}
			
		

public static void adult9() throws Exception {
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_9());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_9(), adult_9_Title);

	JazeeraPage.firstname_9().sendKeys(adult_9_firstname);
	JazeeraPage.lastname_9().sendKeys(adult_9_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.gender_9());
	PageUtils.selectByVisibleText(JazeeraPage.gender_9(), adult_9_Gender);
	 
	
}

public static void child1(String Title,String FN,String LN,String G) throws Exception {
		
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_2());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_2(),Title);

	JazeeraPage.firstname_2().sendKeys(FN);
	JazeeraPage.lastname_2().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_2());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_2(), G);
	 

}
			
	
	
   

public static void child2(String Title,String FN,String LN,String G) throws Exception {
	
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_3());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_3(), Title);

	JazeeraPage.firstname_3().sendKeys(FN);
	JazeeraPage.lastname_3().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_3());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_3(), G);
	 

   
}
public static void child3(String Title,String FN,String LN,String G) throws Exception {
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_4());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_4(), Title);

	JazeeraPage.firstname_4().sendKeys(FN);
	JazeeraPage.lastname_4().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_4());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_4(), G);
	 
		

}
public static void child4(String Title,String FN,String LN,String G) throws Exception {
	

	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_5());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_5(), Title);

	JazeeraPage.firstname_5().sendKeys(FN);
	JazeeraPage.lastname_5().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_5());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_5(), G);
	 


	
   
}
public static void child5(String Title,String FN,String LN,String G) throws Exception {
	
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_6());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_6(), Title);

	JazeeraPage.firstname_6().sendKeys(FN);
	JazeeraPage.lastname_6().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_6());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_6(), G);
	 
		

   
}
public static void child6(String Title,String FN,String LN,String G) throws Exception {
	
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_7());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_7(), Title);

	JazeeraPage.firstname_7().sendKeys(FN);
	JazeeraPage.lastname_7().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_7());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_7(), G);
	 
}
		


    

public static void child7(String Title,String FN,String LN,String G) throws Exception {
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_8());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_8(), Title);

	JazeeraPage.firstname_8().sendKeys(FN);
	JazeeraPage.lastname_8().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_8());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_8(), G);
	 
}
		


    

public static void child8(String Title,String FN,String LN,String G) throws Exception {
	PageUtils.isElementVisibil(driver, JazeeraPage.drp_title_9());
	PageUtils.selectByVisibleText(JazeeraPage.drp_title_9(), Title);

	JazeeraPage.firstname_9().sendKeys(FN);
	JazeeraPage.lastname_9().sendKeys(LN);
	
	//PageUtils.isElementVisibil(driver, JazeeraPage.gender_9());
	//PageUtils.selectByVisibleText(JazeeraPage.gender_9(),G);
	 
}
		

   

public static void Infant1() throws Exception {
	
	
	
	

	JazeeraPage.I_firstname_1().sendKeys(infant_1_firstname);
	JazeeraPage.I_lastname_1().sendKeys(infant_1_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_gender_1());
	PageUtils.selectByVisibleText(JazeeraPage.I_gender_1(), infant_1_Gender);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Date_1());
	PageUtils.selectByVisibleText(JazeeraPage.I_Date_1(), infant1_dof_d);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Month_1());
	PageUtils.selectByVisibleText(JazeeraPage.I_Month_1(), infant1_dof_m);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Year_1());
	PageUtils.selectByVisibleText(JazeeraPage.I_Year_1(), infant1_dof_y);
	 
}
		

	
	
	
	
    

public static void Infant2() throws Exception {
	JazeeraPage.I_firstname_2().sendKeys(infant_2_firstname);
	JazeeraPage.I_lastname_2().sendKeys(infant_2_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_gender_2());
	PageUtils.selectByVisibleText(JazeeraPage.I_gender_2(),infant_2_Gender);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Date_2());
	PageUtils.selectByVisibleText(JazeeraPage.I_Date_2(), infant2_dof_d);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Month_2());
	PageUtils.selectByVisibleText(JazeeraPage.I_Month_2(), infant2_dof_m);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Year_2());
	PageUtils.selectByVisibleText(JazeeraPage.I_Year_2(), infant2_dof_y);
	 
}
	
   
public static void Infant3() throws Exception {
	JazeeraPage.I_firstname_3().sendKeys(infant_3_firstname);
	JazeeraPage.I_lastname_3().sendKeys(infant_3_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_gender_3());
	PageUtils.selectByVisibleText(JazeeraPage.I_gender_3(), infant_3_Gender);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Date_3());
	PageUtils.selectByVisibleText(JazeeraPage.I_Date_3(), infant3_dof_d);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Month_3());
	PageUtils.selectByVisibleText(JazeeraPage.I_Month_3(), infant3_dof_m);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Year_3());
	PageUtils.selectByVisibleText(JazeeraPage.I_Year_3(),infant3_dof_y);
	 
}
		


public static void Infant4() throws Exception {
	
	JazeeraPage.I_firstname_4().sendKeys(infant_4_firstname);
	JazeeraPage.I_lastname_4().sendKeys(infant_4_lastname);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_gender_4());
	PageUtils.selectByVisibleText(JazeeraPage.I_gender_4(), infant_4_Gender);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Date_4());
	PageUtils.selectByVisibleText(JazeeraPage.I_Date_4(),infant4_dof_d);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Month_4());
	PageUtils.selectByVisibleText(JazeeraPage.I_Month_4(), infant4_dof_m);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.I_Year_4());
	PageUtils.selectByVisibleText(JazeeraPage.I_Year_4(), infant4_dof_y);
	 

		
	
}
		



		










public static void paxAPI(Database pnrDetails) throws InterruptedException, IOException
{		
	
	//randomMails();
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://stageapi.rehlat.com/v1/Rehlat/flights";
	
	RequestSpecification request = RestAssured.given();
	//request.accept("text/xml");
	JSONObject requestParams = new JSONObject();
	request.header("Content-Type", "text/json");
	requestParams.put("Domain", pnrDetails.Domain);
	requestParams.put("PnrId", pnrDetails.PnrId);
	//requestParams.put("ProcessId",  ProcessIdValue);
	//request.header("Accept", "text/xml");
   // request.contentType("text/json");
	//JSONObject requestParams = new JSONObject();
	//requestParams.put("id","142531");
	//requestParams.put("undefined", "\"142531\"");
	// Cast
	//requestParams.put("Language", "en");
	/*requestParams.put("To", "JED");
	requestParams.put("DepartureDate", "20190225");	
	requestParams.put("ReturnDate",  "20190228");
	requestParams.put("Currency", "USD");	 
	requestParams.put("Adults",  "1");
	requestParams.put("Children",  "0");
	requestParams.put("Infant",  "0");
	requestParams.put("CLASS",  "Economy");
	requestParams.put("UserName",  "rehlat");
	requestParams.put("Password",  "123456");*/
 
	//request.body(pnrDetails.PnrId);
	request.body(requestParams.toJSONString());
	Response response = request.post("/GetPaxDetailsForScraping");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	//System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	Gson g = new Gson();
	Pax[] mcArray = g.fromJson(s, Pax[].class);
	List<Pax> p = Arrays.asList(mcArray);
	/*Gson g = new Gson();
	List<Pax> p =  g.fromJson(s, List<Pax.class>);
	*/
	//System.out.println("Pnr: " + p.pnr);
	int adultPaxCount = 1;
	int childPaxCount = 1;
	int infantPaxCount = 1;
	
	
	
	
	
	

	 for(Pax pax:p){
		 if(pax.PaxType.equals("ADULT")){
			 
			
			 if(adultPaxCount==1)
			 {
				 adult_1_firstname=pax.FirstNameF3;
				 adult_1_lastname=pax.LastNameF3;
				String Title=pax.Title;
				if("Mr.".equals(Title))
				 {
					 adult_1_Title="Mr";
				 }
				 else if("Mrs.".equals(Title))
				 {
					 adult_1_Title="Mrs";
				 }
				 else if("Ms.".equals(Title))
				 {
					 adult_1_Title="Ms";
				 }
				 
				String Gen=pax.Gender;
				
				 if("M".equals(Gen))
				 {
					 adult_1_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_1_Gender="Female";
				 }
				 
				 countryName= pax.CountryName;
				
				  CityName=pax.FromCity;
				  phoneNumber=pax.PhoneNumber;
				   CustomeremailId=pax.Email;
				   
					/*
					 * String [] Customeremail=CustomeremailId.split("@");
					 * emailWithCustomerName=Customeremail[0]+""+"@mailsaudi.com";
					 * System.out.println("Using Mail Id:"+emailWithCustomerName);
					 */
				  
				  //emailId="travelme686@gmail.com";
				 // randomMails();
				  CountryCode=pax.MobileCountry;
				   mobileCode=pax.MobileCode;
				 
			 }
			 if(adultPaxCount==2)
			 {
				 adult_2_firstname=pax.FirstNameF3;
				 adult_2_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_2_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_2_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_2_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_2_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_2_Gender="Female";
				 }
				
			 
			 }
			 
			 if(adultPaxCount==3)
			 {
				 adult_3_firstname=pax.FirstNameF3;
				 adult_3_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_3_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_3_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_3_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_3_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_3_Gender="Female";
				 }
				 
				
				 
				 
			 }
			 
			 if(adultPaxCount==4)
			 {
				 adult_4_firstname=pax.FirstNameF3;
				 adult_4_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_4_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_4_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_4_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_4_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_4_Gender="Female";
				 }
				
				 
				 
			 }
			 if(adultPaxCount==5)
			 {
				 adult_5_firstname=pax.FirstNameF3;
				 adult_5_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_5_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_5_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_5_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_5_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_5_Gender="Female";
				 }
				 
				 
				 
			 }
			 if(adultPaxCount==6)
			 {
				 adult_6_firstname=pax.FirstNameF3;
				 adult_6_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_6_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_6_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_6_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_6_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_6_Gender="Female";
				 }
				
				
				 
				 
			 }
			 if(adultPaxCount==7)
			 {
				 adult_7_firstname=pax.FirstNameF3;
				 adult_7_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_7_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_7_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_7_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_7_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_7_Gender="Female";
				 }
				
				
				 
				 
			 }
			 if(adultPaxCount==8)
			 {
				 adult_8_firstname=pax.FirstNameF3;
				 adult_8_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_8_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_8_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_8_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_8_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_8_Gender="Female";
				 }
				 
				 
				 
				 
			 }
			 if(adultPaxCount==9)
			 {
				 adult_9_firstname=pax.FirstNameF3;
				 adult_9_lastname=pax.LastNameF3;
				 String Title=pax.Title;
					if("Mr.".equals(Title))
					 {
						 adult_9_Title="Mr";
					 }
					 else if("Mrs.".equals(Title))
					 {
						 adult_9_Title="Mrs";
					 }
					 else if("Ms.".equals(Title))
					 {
						 adult_9_Title="Ms";
					 }
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 adult_9_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 adult_9_Gender="Female";
				 }
				
				 
				 
			 }
			 
			 adultPaxCount +=1;
		 }
		 else if(pax.PaxType.equals("CHILD")){
			 
			 if(childPaxCount==1)
			 {
				 child_1_firstname=pax.FirstNameF3;
				 child_1_lastname=pax.LastNameF3;
				 child_1_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_1_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_1_Gender="Female";
				 }
				
				 
				 
				 
			 }
			 if(childPaxCount==2)
			 {
				 child_2_firstname=pax.FirstNameF3;
				 child_2_lastname=pax.LastNameF3;
				 child_2_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_2_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_2_Gender="Female";
				 }
			 }
			 
			 if(childPaxCount==3)
			 {
				 child_3_firstname=pax.FirstNameF3;
				 child_3_lastname=pax.LastNameF3;
				 child_3_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_3_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_3_Gender="Female";
				 }
				
			 }
			 
			 if(childPaxCount==4)
			 {
				 child_4_firstname=pax.FirstNameF3;
				 child_4_lastname=pax.LastNameF3;
				 child_4_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_4_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_4_Gender="Female";
				 }
			 }
			 
			 if(childPaxCount==5)
			 {
				 child_5_firstname=pax.FirstNameF3;
				 child_5_lastname=pax.LastNameF3;
				 child_5_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_5_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_5_Gender="Female";
				 }
				
			 }
			 
			 if(childPaxCount==6)
			 {
				 child_6_firstname=pax.FirstNameF3;
				 child_6_lastname=pax.LastNameF3;
				 child_6_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_6_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_6_Gender="Female";
				 }
				
			 }
			 
			 if(childPaxCount==7)
			 {
				 child_7_firstname=pax.FirstNameF3;
				 child_7_lastname=pax.LastNameF3;
				 child_7_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_7_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_7_Gender="Female";
				 }
				
			 }
			 
			 if(childPaxCount==8)
			 {
				 child_8_firstname=pax.FirstNameF3;
				 child_8_lastname=pax.LastNameF3;
				 child_8_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 child_8_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 child_8_Gender="Female";
				 }
				
			 }
			childPaxCount +=1;
		 }
		 else if(pax.PaxType.equals("INFANT")){
			 
			 if(infantPaxCount==1)
			 {
			 infant_1_firstname=pax.FirstNameF3;
			 infant_1_lastname=pax.LastNameF3;
			 infant_1_Title=pax.Title;
			 String Gen=pax.Gender;
				
			 if("M".equals(Gen))
			 {
				 infant_1_Gender="Male";
			 }
			 else if("F".equals(Gen))
			 {
				 infant_1_Gender="Female";
			 }
			 
			 String[] S=pax.DobStrF3.split("-");
			  infant1_dof_d=S[0];
			  infant1_dof_m=S[1];
			  infant1_dof_y=S[2];
			 }
			 
			 if(infantPaxCount==2)
			 {
				 infant_2_firstname=pax.FirstNameF3;
				 infant_2_lastname=pax.LastNameF3;
				 infant_2_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 infant_2_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 infant_2_Gender="Female";
				 }
				 String[] S=pax.DobStrF3.split("-");
				  infant2_dof_d=S[0];
				  infant2_dof_m=S[1];
				  infant2_dof_y=S[2];
				 
			 }
			 
			 if(infantPaxCount==3)
			 {
				 infant_3_firstname=pax.FirstNameF3;
				 infant_3_lastname=pax.LastNameF3;
				 infant_3_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 infant_3_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 infant_3_Gender="Female";
				 }
				 String[] S=pax.DobStrF3.split("-");
				  infant3_dof_d=S[0];
				  infant3_dof_m=S[1];
				  infant3_dof_y=S[2];
				
			 }
			 
			 if(infantPaxCount==4)
			 {
				 infant_4_firstname=pax.FirstNameF3;
				 infant_4_lastname=pax.LastNameF3;
				 infant_4_Title=pax.Title;
				 String Gen=pax.Gender;
					
				 if("M".equals(Gen))
				 {
					 infant_4_Gender="Male";
				 }
				 else if("F".equals(Gen))
				 {
					 infant_4_Gender="Female";
				 }
				 String[] S=pax.DobStrF3.split("-");
				  infant4_dof_d=S[0];
				  infant4_dof_m=S[1];
				  infant4_dof_y=S[2];
				 
			 }
			 infantPaxCount +=1;
		 }
		 
		 
		
		   
		    } 
	 
	 
	 System.out.println("------------------------------------------------------------------------------------");
	 
	
}

public static void enetCardApi(Database pnrDetails) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	//requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Amount",  pnrDetails.Amount);
	request.body(requestParams.toJSONString());
	Response response = request.post("/GetEnettCard");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	//System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	Gson g = new Gson();
	
	CardDetails card = g.fromJson(s, CardDetails.class);
	
			System.out.println(card.VirtualAccountNumber); 
			
	 cardNumber=card.VirtualAccountNumber;
	 expiryMonth=card.ExpiryMonth;
	 expiryYear=card.ExpiryYear;
	 CVV=card.CardSecurityCode;
	 transactionID=card.VNettTransactionID;
	
	
	
	

	
}

static String cardNumber;
static String CVV;
static String expiryMonth;
static String expiryYear;
static String transactionID;
/*public static void enterCardDetails(Database pnrDetails,WebDriver driver) throws Exception
{
	try{
	enetCardApi(pnrDetails);
	PageUtils.isElementDisplayed(driver, flyadealPage.select_Card_Type("Credit/Debit Card"));
	flyadealPage.select_Card_Type("Credit/Debit Card");
	PageUtils.isElementVisibil(driver, flyadealPage.txt_Card_Number());
	flyadealPage.txt_Card_Number().sendKeys(cardNumber);
	System.out.println("Enter Card Number:"+cardNumber);
	PageUtils.isElementVisibil(driver, flyadealPage.txt_Holder_Name());
	flyadealPage.txt_Holder_Name().sendKeys(adult_1_firstname);
	PageUtils.isElementVisibil(driver, flyadealPage.btn_card_month());
	flyadealPage.btn_card_month().click();
	PageUtils.isElementVisibil(driver, flyadealPage.select_card_Month(expiryMonth));
	flyadealPage.select_card_Month(expiryMonth).click();
	PageUtils.isElementVisibil(driver, flyadealPage.btn_card_year());
	flyadealPage.btn_card_year().click();
	PageUtils.isElementVisibil(driver, flyadealPage.select_card_year(expiryYear));
	flyadealPage.select_card_year(expiryYear).click();
	PageUtils.isElementVisibil(driver,flyadealPage.txt_CVV_Number());
	flyadealPage.txt_CVV_Number().sendKeys(CVV);
	System.out.println("Enter CVV Number:"+CVV);
	PageUtils.isElementVisibil(driver,flyadealPage.btn_Payment_Continue());
	flyadealPage.btn_Payment_Continue().click();
	//Thread.sleep(15000);
	PageUtils.getScreenShot(pnrDetails.PnrId,driver);
	
	}
	catch(Exception e)
	{
		PageUtils.getScreenShot(pnrDetails.PnrId,driver);
		passengersDetails.returnStatus_fail(pnrDetails.Domain,pnrDetails.PnrId,"Payment Gateway Error");
		driver.quit();
	}
	GetPnr(driver,pnrDetails);
}
*/

/*public static void GetPnr(WebDriver driver,Database pnrDetails) throws Exception
{
	PageUtils.isElementLocated(driver, By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Share on'])[1]/following::b[1]"));
	PageUtils.waitForFixedTime(BrowserContants.WAIT_MEDIUM);
	 PnrId=flyadealPage.PNR_get().getText();
	System.out.println("PNR ID:"+PnrId);
	PageUtils.getScreenShot(pnrDetails.PnrId,driver);
	PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
	returnStatus(pnrDetails);
	generateMail(pnrDetails);
}
*/
public static void randomMails() {
	emailId = PageUtils.getMail();
	System.out.println("Get Mail Id:"+emailId);
	
}

public static void returnStatus(Database pnrDetails,String PnrID,String WebSiteAmount) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	//requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Status",  "1");
	requestParams.put("Remarks",  PnrID);
	requestParams.put("WebSiteTotalBookingAmount",  WebSiteAmount);
	request.body(requestParams.toJSONString());
	Response response = request.post("/UpdatePnrStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
}

public static void returnStatus_fail(String domain,String pnrId,String remarks) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain", domain);
	requestParams.put("PnrId",  pnrId);
	//requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Status",  "0");
	requestParams.put("Remarks",  remarks);
	request.body(requestParams.toJSONString());
	Response response = request.post("/UpdatePnrStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
}

public static void readPnrId(Database pnrDetails) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	//requestParams.put("ProcessId",  ProcessIdValue);
	request.body(requestParams.toJSONString());
	Response response = request.post("/SetPnrReadStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	
}

public static void generateMail(Database pnrDetails) throws EmailException
{
	StringBuilder htmlStringBuilder=new StringBuilder();
	
	//Mail sent

	System.out.println("Started");
	 //StringBuilder htmlStringBuilder=new StringBuilder();
	 HtmlEmail email = new HtmlEmail();
	//Email email = new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	System.out.println("1");
	email.setAuthenticator(new DefaultAuthenticator("nagababu.cherukumalli@rehlat.com", "naga@qtselenium"));
	email.setSSLOnConnect(true);
	email.setFrom("naga123.ch@gmail.com");
	
	 Date mDate = new Date();
	 DateFormat date = new SimpleDateFormat("dd-MMMM-yyyy");
	 String Date=date.format(mDate);
	 System.out.println(Date);
		if (Date.equals(pnrDetails.DepartureDate)) {
			email.setSubject(
					"[HIGH PRIORITY] FlyaDeal Booking Using ENETT  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		} else {
			email.setSubject("FlyaDeal Booking Using ENETT  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		}
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>Dear Team,</tr>"));
	//email.setHtmlMsg(""+htmlStringBuilder.append("<tr>FlyaDeal transaction completed successful for BookingId <b> "+pnrDetails.PnrId+"</b>  with PNR <b> "+flyaDealModule.PnrId+"</b>  in <b> "+pnrDetails.Domain+"</b>  domain using enett card with transactionId <b>"+transactionID+"</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr></tr>"));
	
	email.addTo("qateam@rehlat.com");
	email.addCc("rajendra.purohit@rehlat.com");
	email.addCc("rajashekar.uppu@rehlat.com");
	 
	 //email.addTo("naga.ch199@gmail.com");
	
	
	System.out.println("2");
	email.send();
	System.out.println("END");
}


}
