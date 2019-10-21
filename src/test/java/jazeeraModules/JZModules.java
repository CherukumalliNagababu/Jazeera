package jazeeraModules;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


import pageObjects.Database;
import pageObjects.JazeeraPage;
import pageObjects.PageUtils;







public class JZModules extends PassengerDetailsJZ {
	public static String status;
	
	public static void tripType(WebDriver driver,Database PnrDetails) throws Exception {
		
		
		
		try{
			
			if ("OneWay".equals(PnrDetails.TripType)) {
				
				PageUtils.isElementVisibil(driver, JazeeraPage.oneyWay());
				JazeeraPage.oneyWay().click();
				System.out.println("Select OneWay Trip");
				
			} else if ("RoundTrip".equals(PnrDetails.TripType))
				/*
				 * PageUtils.isElementVisibil(driver, JazeeraPage.roundTrip());
				 * JazeeraPage.roundTrip().click();
				 */
				System.out.println("Select Round Trip");
			  
			
			}
			catch(Exception e)
			{
				status="TripType error";
				PageUtils.getScreenShot(PnrDetails.PnrId,driver);
				driver.quit();
				
			}
			PageUtils.getScreenShot(PnrDetails.PnrId,driver);
		
		
		
	}
	
	public static void enterFromAndTo(WebDriver driver,Database PnrDetails) throws Exception
	{
		
		PageUtils.isElementVisibil(driver, JazeeraPage.From());
		JazeeraPage.From().click();
		Thread.sleep(2000);
		
		JazeeraPage.From().sendKeys(PnrDetails.From);
		PageUtils.isElementVisibil(driver, JazeeraPage.From_Select());
		JazeeraPage.From_Select().click();
		
		PageUtils.isElementVisibil(driver, JazeeraPage.To());
		JazeeraPage.To().click();
		Thread.sleep(2000);
		JazeeraPage.To().sendKeys(PnrDetails.To);
		PageUtils.isElementVisibil(driver, JazeeraPage.To_select());
		JazeeraPage.To_select().click();
		
		
	}
	
	public static void selectDateAndPassengersNum(WebDriver driver,Database PnrDetails,String D_Month,String D_Date,String R_Month,String R_Date) throws Exception
	{
		Thread.sleep(2000);
		
		
		if ("OneWay".equals(PnrDetails.TripType)) {
			
		
		JazeeraPage.btn_Date_dep().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
		JazeeraPage.header_Month(D_Month);
		Thread.sleep(2000);
		JazeeraPage.select_Date(D_Date);
		}
		else if ("RoundTrip".equals(PnrDetails.TripType))
		{
			JazeeraPage.btn_Date_dep().click();
			PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
			JazeeraPage.header_Month(D_Month);
			Thread.sleep(2000);
			JazeeraPage.select_Date(D_Date);
			
			JazeeraPage.btn_Date_Ret().click();
			PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
			JazeeraPage.Return_header_Month(R_Month);
			Thread.sleep(2000);
			JazeeraPage.select_Date(R_Date);
		}
		
		
		String a=PnrDetails.Adults;
		String c=PnrDetails.Childs;
		String i=PnrDetails.Infants;
		
		Select s=new Select(JazeeraPage.adult_increase());
		s.selectByVisibleText(a);
		
		if(c.equals("0"))
		{
		System.out.println("Childs are :0");
		}
		else {
			Select s1=new Select(JazeeraPage.child_increase());
			s1.selectByVisibleText(c);
		}
		
		if(i.equals("0"))
		{
		System.out.println("Infants are :0");
		}
		else {
		Select s2=new Select(JazeeraPage.infant_increase());
		s2.selectByVisibleText(i);
		}
	}
	
	public static void clickBookNow(WebDriver driver) throws Exception
	{
	
		JazeeraPage.btn_BookNow().click();
}
	
	public static void selectFlight(WebDriver driver,Database PnrDetails,double currency) throws Exception
	{
		if ("OneWay".equals(PnrDetails.TripType))
		{
			
		JazeeraPage.selectFlightNumber_D(PnrDetails.DepartureFlightNumber);
		}
		
		else if ("RoundTrip".equals(PnrDetails.TripType))
		{
		JazeeraPage.selectFlightNumber_D(PnrDetails.DepartureFlightNumber);
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		JazeeraPage.selectFlightNumber_R(PnrDetails.ReturnFlightNumber);
		}
		//"J9  213"
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		String Amount=JazeeraPage.total_value().getText();
		
		String[] WEBAM=Amount.split(" ");
		String WEBAMOUNT=WEBAM[0];
		//System.out.println("Amount:"+WEBAMOUNT);
		
		String plu = WEBAMOUNT.replaceAll(",", "");
		float WebAmount = Float.parseFloat(plu);

		if (currency >= WebAmount) {
			
			System.out.println("API Amount:" + PnrDetails.Amount);
			System.out.println("WebSite Amount:" + WebAmount);
		} else {
			 PassengerDetailsJZ.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId,"Api amount is greater than website amount");
			System.out.println("API Amount:" + PnrDetails.Amount + "WebSite Amount:" + WebAmount);
			driver.quit();
			
			
		}
		
		JazeeraPage.btn_Srp_BookNow().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
	}
	
	
	 public static void enterPassengerDetails(WebDriver driver,Database  PnrDetails) throws Exception {
	  
	  //try{ 
		  PassengerDetailsJZ.paxAPI(PnrDetails);
	  
	  
	  String numofAdults =PnrDetails.Adults; 
	  String numofChilds = PnrDetails.Childs; 
	  String numofInfants = PnrDetails.Infants;
	 
	 
		
	
		if (numofAdults.equals("1")) {
			PageUtils.getScreenShot(PnrDetails.PnrId, driver);
			PassengerDetailsJZ.adult1(PnrDetails);
			
			
		
		} else if (numofAdults.equals("2")) {
			System.out.println("Adults 2-----------------");
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
		}
		else if (numofAdults.equals("3")) {
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
			PassengerDetailsJZ.adult3();
		}
		else if (numofAdults.equals("4")) {
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
			PassengerDetailsJZ.adult3();
			PassengerDetailsJZ.adult4();
		}
		else if (numofAdults.equals("5")) {
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
			PassengerDetailsJZ.adult3();
			PassengerDetailsJZ.adult4();
			PassengerDetailsJZ.adult5();
		
		}
		else if (numofAdults.equals("6")) {
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
			PassengerDetailsJZ.adult3();
			PassengerDetailsJZ.adult4();
			PassengerDetailsJZ.adult5();
			PassengerDetailsJZ.adult6();
		}
		else if (numofAdults.equals("7")) {
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
			PassengerDetailsJZ.adult3();
			PassengerDetailsJZ.adult4();
			PassengerDetailsJZ.adult5();
			PassengerDetailsJZ.adult6();
			PassengerDetailsJZ.adult7();
		}
		else if (numofAdults.equals("8")) {
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
			PassengerDetailsJZ.adult3();
			PassengerDetailsJZ.adult4();
			PassengerDetailsJZ.adult5();
			PassengerDetailsJZ.adult6();
			PassengerDetailsJZ.adult7();
			PassengerDetailsJZ.adult8();
		}
		else if (numofAdults.equals("9")) {
			PassengerDetailsJZ.adult1(PnrDetails);
			PassengerDetailsJZ.adult2();
			PassengerDetailsJZ.adult3();
			PassengerDetailsJZ.adult4();
			PassengerDetailsJZ.adult5();
			PassengerDetailsJZ.adult6();
			PassengerDetailsJZ.adult7();
			PassengerDetailsJZ.adult8();
			PassengerDetailsJZ.adult9();
		}
	
		if(numofChilds.equals("1"))
		{
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			
		}
		else if(numofChilds.equals("2"))
		{
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			
		}
		else if(numofChilds.equals("3"))
		{
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			
		
			
		}
		else if(numofChilds.equals("4"))
		{
			

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			}
		
		}
		else if(numofChilds.equals("5"))
		{
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			}
			
		}
		else if(numofChilds.equals("6"))
		{
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);

			}
				
		}
		else if(numofChilds.equals("7"))
		{
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_7_Title,child_7_firstname,child_7_lastname,child_7_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_7_Title,child_7_firstname,child_7_lastname,child_7_Gender);

			}
		}
		
		
		else if(numofChilds.equals("8"))
		{
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child1(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			else if ("8".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_1_Title,child_1_firstname,child_1_lastname,child_1_Gender);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child2(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
			else if ("7".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_2_Title,child_2_firstname,child_2_lastname,child_2_Gender);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child3(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			else if ("6".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_3_Title,child_3_firstname,child_3_lastname,child_3_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child4(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			} else if ("5".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_4_Title,child_4_firstname,child_4_lastname,child_4_Gender);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child5(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			} else if ("4".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_5_Title,child_5_firstname,child_5_lastname,child_5_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child6(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);

			} else if ("3".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_6_Title,child_6_firstname,child_6_lastname,child_6_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child7(child_7_Title,child_7_firstname,child_7_lastname,child_7_Gender);
			} else if ("2".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_7_Title,child_7_firstname,child_7_lastname,child_7_Gender);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				PassengerDetailsJZ.child8(child_8_Title,child_8_firstname,child_8_lastname,child_8_Gender);
			} 
		}
		
		if (numofInfants.equals("1")) {
			
			PassengerDetailsJZ.Infant1();
			
		
		} else if (numofInfants.equals("2")) {
			PassengerDetailsJZ.Infant1();
			PassengerDetailsJZ.Infant2();
		}
		else if (numofInfants.equals("3")) {
			PassengerDetailsJZ.Infant1();
			PassengerDetailsJZ.Infant2();
			PassengerDetailsJZ.Infant3();
		}
		else if (numofInfants.equals("4")) {
			PassengerDetailsJZ.Infant1();
			PassengerDetailsJZ.Infant2();
			PassengerDetailsJZ.Infant3();
			PassengerDetailsJZ.Infant4();
		}
			
		
	  //}
		//catch(Exception e)
		//{
			//PageUtils.getScreenShot(PnrDetails.PnrId,driver);
			//PassengerDetailsJZ.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId,"Document Details Element Not Found");
			//driver.quit();
		//}
		
		
		Thread.sleep(2000);
	  
		System.out.println("Enter All Passenger Details Successfully");
		
		
		
		
		
	}


	
   
		
	
      

public static void enterContactDetails()throws Exception
{
	JazeeraPage.con_City().sendKeys(PassengerDetailsJZ.CityName);
	
	JazeeraPage.con_Country_clk().click();
	Thread.sleep(2000);
	JazeeraPage.con_Country_clk().sendKeys(countryName);
	System.out.println("countryName:"+countryName);
	Thread.sleep(2000);
	JazeeraPage.con_Country_clk().sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	//JazeeraPage.select_country("");
	
	JazeeraPage.con_Country_code_clk().click();
	Thread.sleep(2000);
	JazeeraPage.con_Country_code_clk().sendKeys(countryName);
	Thread.sleep(2000);
	System.out.println("CountryCode:"+countryName);
	JazeeraPage.con_Country_code_clk().sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	//JazeeraPage.select_country_code("");
	
	JazeeraPage.txt_Mobile_Num().sendKeys(phoneNumber);
	JazeeraPage.txt_Email().sendKeys(CustomeremailId);
	
	JazeeraPage.chk_PrevVisit().click();
	Thread.sleep(5000);
	JazeeraPage.Chk_PromoOpt().click();
	Thread.sleep(5000);
	JazeeraPage.btn_Continue().click();
	
}


public static void ChkAddOns() throws Exception
{
	PageUtils.isElementVisibil(driver, JazeeraPage.chk_Insurance());
	JazeeraPage.chk_Insurance().click();
	
	JazeeraPage.btn_Continue_AddOns().click();
	PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
	
}

public static void enterCardDetails(Database PnrDetails) throws Exception
{
	enetCardApi(PnrDetails);
	PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
	
	PageUtils.isElementVisibil(driver, JazeeraPage.btn_CreditCard());
	JazeeraPage.btn_CreditCard().click();
	Thread.sleep(2000);
	PageUtils.selectByVisibleText(JazeeraPage.select_Card_Type(), "Master Card");
	JazeeraPage.txt_Card_Number().sendKeys(cardNumber);
	
	PageUtils.selectByVisibleText(JazeeraPage.drp_exp_month(), expiryMonth);
	Thread.sleep(2000);
	PageUtils.selectByVisibleText(JazeeraPage.drp_exp_Year(), expiryYear);
	
	String s= adult_1_firstname+""+adult_1_lastname;
	s = s.substring(0, Math.min(s.length(), 9));
	JazeeraPage.txt_Card_holder_Name().sendKeys(s);
	System.out.println("ENTER CARD HOLDER NAME:"+s);
	
	
	JazeeraPage.txt_CVV_Number().sendKeys(CVV);
	JazeeraPage.btn_PayNow().click();
	
}

}
 		


