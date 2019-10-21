package flows;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.google.gson.Gson;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jazeeraModules.BrowserContants;
import jazeeraModules.JZModules;
import jazeeraModules.PassengerDetailsJZ;
import pageObjects.BaseClass;
import pageObjects.Database;


public class JazeeraFlow {
	static WebDriver driver;
	private Database PnrDetails;
	boolean status;


	@Test
	public void test() throws Exception {

		
		if (BrowserContants.ENV.equals("PRD")) {
			RestAssured.baseURI = BrowserContants.PRD_API_URL;
			System.out.println(BrowserContants.PRD_API_URL);
			System.out.println("naga");
		} else if (BrowserContants.ENV.equals("STG")) {
			RestAssured.baseURI = BrowserContants.STG_API_URL;
			System.out.println(BrowserContants.STG_API_URL);
		}
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "text/json");
		Response response = request.get("/GetBookingFromQueue?airline=j9");
		System.out.println("Response body: " + response.body().asString());
		String s=response.body().asString();
		System.out.println(s);
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		
		
		
		
		Gson g = new Gson();
		Database[] mcArray = g.fromJson(s, Database[].class);
		List<Database> p = Arrays.asList(mcArray);
		for(Database data:p){
			try{
				
				PnrDetails=data;
				
				
             String[] depar=data.DepartureDate.split("-");
				
				String Dep_date=depar[0];
				String Dep_Mon=depar[1];
				String Dep_year=depar[2];
				System.out.println("DepartureDate:"+Dep_date);
				 System.out.println("DepartureMonth:"+Dep_Mon);
				 System.out.println("DepartureYear:"+Dep_year);
				String Ret_date= null;
				String Ret_Mon = null;
				String Ret_year= null;
				
				if(data.TripType.toLowerCase().equals("roundtrip")){
               String[] retu=data.ReturnDate.split("-");
				
				 Ret_date=retu[0];
				 Ret_Mon=retu[1];
				 Ret_year=retu[2];
				 System.out.println(Ret_date);
				 System.out.println(Ret_Mon);
				 System.out.println(Ret_year);
				 System.out.println(PnrDetails.TripType);
				 System.out.println(PnrDetails.From);
				 System.out.println(PnrDetails.To);
				 
				}
		
		  ChromeOptions options = new ChromeOptions();
		 options.addArguments("--start-maximized");
		  System.setProperty("webdriver.chrome.driver",  "E:\\Softwares\\chromedriver.exe"); 
		  driver = new ChromeDriver(options);
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.manage().deleteAllCookies();
		 driver.get("https://www.jazeeraairways.com/"); 
		 new BaseClass(driver);
		 
		  JZModules.tripType(driver,PnrDetails); 
		  JZModules.enterFromAndTo(driver,PnrDetails);
		  JZModules.selectDateAndPassengersNum(driver,PnrDetails,Dep_Mon,Dep_date,Ret_Mon,Ret_date); 
		  JZModules.clickBookNow(driver);
		  Thread.sleep(5000);
		  JZModules.selectFlight(driver,PnrDetails,Float.parseFloat(PnrDetails.Amount));
		  JZModules.enterPassengerDetails(driver,PnrDetails);
		  JZModules.enterContactDetails();
		  JZModules.ChkAddOns();
		  JZModules.enterCardDetails(PnrDetails);
		
		
				// driver.quit();

			}
		
			 catch(Exception e)
			{
				// pnrId, Domain, status, remarks

			    PassengerDetailsJZ.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId,JZModules.status);
				System.out.println("PNR ID:"+PnrDetails.PnrId +" DOMAIN NAME "+PnrDetails.Domain+"  FAIL  "+""+e.getMessage());
				System.out.println(e);
					
				continue;
			}
		}
	}

			

}
