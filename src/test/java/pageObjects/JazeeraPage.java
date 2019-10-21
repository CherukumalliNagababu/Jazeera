package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;







public class JazeeraPage extends BaseClass {

	private static WebElement element;
	
	
	public JazeeraPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement oneyWay() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='OptOneWay']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement roundTrip() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='OptReturn']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement From() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='TxtFrom']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement From_Select() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ul[@id='destination_holder']/li/span"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement To() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='TxtTo']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement To_select() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//ul[@id='destination_holder']/li/span"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_Date_dep() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='TxtDepartDate']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_Date_Ret() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='TxtReturnDate']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement header_Month(String HeaderMonth) throws Exception {
		element = null;
		try {
			for(int i=0;i<=5;i++){
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sun'])[1]/preceding::span[4]"));
			if(element.getText().equals(HeaderMonth))
			{
				System.out.println(element.getText());
				break;
			}
			else{
				driver.findElement(By.xpath("//div[@class='flatpickr-calendar animate arrowTop open']/div[@class='flatpickr-month']/span[@class='flatpickr-next-month']/*[1]")).click();
			}
			}
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> select_Date(String Date) throws Exception {
		List<WebElement> element = null;
		
			
			try{
				// element = driver.findElements(By.xpath("//div[@class='calendar left single']//td[not(contains(@class,'off available'))]"));
				element = driver.findElements(By.xpath("//div[@class='dayContainer']//span[@class='flatpickr-day ']"));
			              
				           
			             
				 for (WebElement e1 : element) {
						String ele = e1.getText();
						

						if (ele.equals(Date)) {
							System.out.println("OneWay:Select Date:"+e1.getText());
							e1.click();	
							break;
						}
						// Thread.sleep(1000);
					}
				
				
		
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement Return_header_Month(String HeaderMonth) throws Exception {
		element = null;
		try {
			for(int i=0;i<=5;i++){
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sun'])[5]/preceding::span[4]"));
			if(element.getText().equals(HeaderMonth))
			{
				System.out.println(element.getText());
				break;
			}
			else{
				driver.findElement(By.xpath("//div[@class='flatpickr-calendar animate arrowTop open']/div[@class='flatpickr-month']/span[@class='flatpickr-next-month']/*[1]")).click();
			}
			}
			
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement adult_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//select[@id='SelAdult']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement child_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//select[@id='SelChild']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement infant_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//select[@id='SelInfant']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_BookNow() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.linkText("Book Now"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> selectFlightNumber_D(String APIFlightNUM) throws Exception {
		List<WebElement> element= null;
		try {
			
			element = driver.findElements(By.xpath("//div[@id='tab4']/table/tbody/tr/td/table/tbody/tr/td[2]/a"));
			
			int i=0;
			for(WebElement e:element)
			{
				String FlightNumber=e.getText();
				System.out.println("FlightNumber:"+FlightNumber);
				i += 2;
				System.out.println("I Value:"+i);
			
				try{
				if(APIFlightNUM.equals(FlightNumber))
				{
					
					
				driver.findElement(By.xpath("//div[@id='tab4']/table/tbody/tr["+i+"]/td[2]/span")).click();
				break;
				
				}
				}
			
				catch (Exception e2) {
					
				}
			}
			}
			
			 catch (Exception e) {
				
		}
		return element;
	}
	public static List<WebElement> selectFlightNumber_R(String APIFlightNUM) throws Exception {
		List<WebElement> element= null;
		try {
			
			element = driver.findElements(By.xpath("//div[@id='tab11']/table/tbody/tr/td/table/tbody/tr/td[2]/a"));
			
			int i=0;
			for(WebElement e:element)
			{
				String FlightNumber=e.getText();
				System.out.println("FlightNumber:"+FlightNumber);
				i += 2;
				System.out.println("I Value:"+i);
			
				try{
				if(APIFlightNUM.equals(FlightNumber))
				{
					
					
				driver.findElement(By.xpath("//div[@id='tab11']/table/tbody/tr["+i+"]/td[2]/span")).click();
				break;
				
				}
				}
			
				catch (Exception e2) {
					
				}
			}
			}
			
			 catch (Exception e) {
				
		}
		return element;
	}
	public static WebElement total_value() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Total'])[1]/following::label[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Srp_BookNow() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//em[contains(text(),'Book Now')]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	
	public static WebElement drp_title_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_0"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_title_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_1"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_title_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_2"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_2"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_2"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_2"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_title_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_3"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_3"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_3"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_3"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_title_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_4"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_4"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_4"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_4"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_title_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_5"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_5"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_5"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_5"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_title_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_6"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_6"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_6"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_6"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_title_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_7"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_7"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_7"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_7"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_title_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListTitle_8"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement firstname_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_8"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_8"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement gender_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_8"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	//Infant 1
	
	public static WebElement I_drp_title_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListAssign_0_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement I_firstname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_0_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement I_lastname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_0_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement I_gender_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_0_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement I_Date_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateDay_0_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement I_Month_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateMonth_0_0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement I_Year_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateYear_0_0"));
			PageUtils.scrollDown_small(driver);
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	//Infant 2
	
		public static WebElement I_drp_title_2() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListAssign_1_1"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement I_firstname_2() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_1_1"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement I_lastname_2() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_1_1"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement I_gender_2() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_1_1"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement I_Date_2() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateDay_1_1"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement I_Month_2() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateMonth_1_1"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement I_Year_2() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateYear_1_1"));
				PageUtils.scrollDown_small(driver);
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		//Infant 3
		
			public static WebElement I_drp_title_3() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListAssign_2_2"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement I_firstname_3() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_2_2"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement I_lastname_3() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_2_2"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement I_gender_3() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_2_2"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement I_Date_3() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateDay_2_2"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement I_Month_3() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateMonth_2_2"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement I_Year_3() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateYear_2_2"));
					PageUtils.scrollDown_small(driver);
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			
			//Infant 4
			
			public static WebElement I_drp_title_4() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListAssign_3_3"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement I_firstname_4() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxFirstName_3_3"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement I_lastname_4() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_TextBoxLastName_3_3"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement I_gender_4() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListGender_3_3"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement I_Date_4() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateDay_3_3"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement I_Month_4() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateMonth_3_3"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement I_Year_4() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_CONTROLGROUPPASSENGER_PassengerInputViewContactView_DropDownListBirthDateYear_3_3"));
					PageUtils.scrollDown_small(driver);
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			//Contact Information
			
			public static WebElement con_title() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_DropDownListTitle"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement con_firstName() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_TextBoxFirstName"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement con_lastName() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_TextBoxLastName"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement con_City() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_TextBoxCity"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement con_Country_clk() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_TEXTBOXCOUNTRY"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static List<WebElement> select_country(String ApiCountryName) throws Exception {
				List<WebElement> element = null;
				try {
					 element = driver.findElements(By.xpath("//input[@id='CONTROLGROUPCONTACT_ContactInputView_TEXTBOXCOUNTRY']/ul/li/a"));
					for(WebElement e:element) {
						
						String CountryName=e.getText();
						
					 if(CountryName.equals(ApiCountryName))
						{
							e.click();
							break;
						}
					}
					 
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			
			public static WebElement con_Country_code_clk() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_TEXTBOXCOUNTRYCODE"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static List<WebElement> select_country_code(String ApiCountrycode) throws Exception {
				List<WebElement> element = null;
				try {
					 element = driver.findElements(By.xpath("//input[@id='CONTROLGROUPCONTACT_ContactInputView_TEXTBOXCOUNTRYCODE']']/ul/li/a"));
					for(WebElement e:element) {
						
						String CountryCode=e.getText();
						
					 if(CountryCode.equals(ApiCountrycode))
						{
							e.click();
							break;
						}
					}
					 
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement txt_Mobile_Num() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_TextBoxOtherPhone"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement txt_Email() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_TextBoxEmailAddress"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement chk_PrevVisit() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_CheckBoxPrevVisit"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement Chk_PromoOpt() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPCONTACT_ContactInputView_CheckBoxPromoOpt"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement btn_Continue() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*Email Address'])[1]/following::em[1]"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement chk_Insurance() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Important Insurance Information'])[1]/preceding::span[1]"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement btn_Continue_AddOns() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Price Summary'])[1]/preceding::em[1]"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement btn_CreditCard() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.linkText("Credit Card"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement select_Card_Type() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("ExternalAccount_PaymentMethodCode"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			public static WebElement txt_Card_Number() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPPAYMENTBOTTOM_ControlGroupPaymentInputViewPaymentView_ExternalAccount_MC_ACCTNO"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement drp_exp_month() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPPAYMENTBOTTOM_ControlGroupPaymentInputViewPaymentView_ExternalAccount_MC_EXPDAT_MONTH"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement drp_exp_Year() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPPAYMENTBOTTOM_ControlGroupPaymentInputViewPaymentView_ExternalAccount_MC_EXPDAT_YEAR"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement txt_Card_holder_Name() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPPAYMENTBOTTOM_ControlGroupPaymentInputViewPaymentView_ExternalAccount_MC_CC::AccountHolderName"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement txt_CVV_Number() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.id("CONTROLGROUPPAYMENTBOTTOM_ControlGroupPaymentInputViewPaymentView_ExternalAccount_MC_CC::VerificationCode"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			public static WebElement btn_PayNow() throws Exception {
				element = null;
				try {
					element = driver.findElement(By.xpath("//a[@id='CONTROLGROUPPAYMENTBOTTOM_LinkButtonSubmit']/em"));
					
				} catch (Exception e) {
					
					throw (e);
				}
				return element;
			}
			
			
}
