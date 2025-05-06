import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.text.SimpleDateFormat as SimpleDateFormat
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

public class CustomKey {

	def login(String username, String password, String expectedErrorMessage) {
		WebUI.openBrowser('')
		WebUI.navigateToMaskedUrl('https://katalon-demo-cura.herokuapp.com/')
		WebUI.click(findTestObject('Object Repository/Login/btn_make_appointment'))
		WebUI.setText(findTestObject('Object Repository/Login/field_username'), username)
		WebUI.setText(findTestObject('Object Repository/Login/field_password'), password)
		WebUI.click(findTestObject('Object Repository/Login/btn_login'))

		if (expectedErrorMessage) {
			WebUI.verifyElementText(findTestObject('Object Repository/Login/error_message'), expectedErrorMessage, FailureHandling.STOP_ON_FAILURE)
		} else {
			// If no error message, verify login was successful
			WebUI.verifyElementPresent(findTestObject('Object Repository/MakeAppointment/make_appointment_title'), 10, FailureHandling.STOP_ON_FAILURE)
		}
	}

	def logout() {
		WebUI.waitForElementClickable(findTestObject('Object Repository/Login/btn_burger'), 10)
		WebUI.click(findTestObject('Object Repository/Login/btn_burger'))
		WebUI.click(findTestObject('Object Repository/Login/logout_button'))
		WebUI.closeBrowser()
	}

	def failure(String message, FailureHandling flowControl) {
		switch (flowControl) {
			case FailureHandling.OPTIONAL:
			//KeywordUtil.logInfo(message)
				break
			case FailureHandling.CONTINUE_ON_FAILURE:
			//KeywordUtil.markFailed(message)
				break
			case FailureHandling.STOP_ON_FAILURE:

				'get dateTime Now'
				SimpleDateFormat sDate = new SimpleDateFormat('dd-MM-yy HHmmss')
				String date = sDate.format(new Date())

				'error picture path'
				String path = "Reports"+message+date+".png"

				'take error picture'
				WebUI.takeScreenshot(path)

				'Close browser'
			//WebUI.closeBrowser()
				break
		}
	}

	def makeAppointment(String facility, String readmission, String program, String visitDate, String comment) {
		//Input validation
		if (![
					'Seoul CURA Healthcare Center',
					'Hongkong CURA Healthcare Center'
				].contains(facility)) {
			KeywordUtil.markFailedAndStop("Invalid facility: ${facility}")
		}
		if (![
					'Medicaid',
					'Medicare',
					'None'
				].contains(program)) {
			KeywordUtil.markFailedAndStop("Invalid program: ${program}")
		}

		WebUI.selectOptionByValue(findTestObject('Object Repository/MakeAppointment/facility_dropdown'), facility, true)

		if (readmission) {
			WebUI.check(findTestObject('Object Repository/MakeAppointment/hospital_readmission_checkbox'))
		} else {
			WebUI.uncheck(findTestObject('Object Repository/MakeAppointment/hospital_readmission_checkbox'))
		}

		def programXPath = "//input[@name='programs' and @value='${program}']"
		WebUI.click(findTestObject('Object Repository/MakeAppointment/healthcare_program_radio_button', ['programValue': program]))
		WebUI.click(findTestObject('Object Repository/MakeAppointment/visit_date_input'))
		WebUI.setText(findTestObject('Object Repository/MakeAppointment/visit_date_input'), visitDate)
		WebUI.setText(findTestObject('Object Repository/MakeAppointment/comment_textarea'), comment)
		WebUI.click(findTestObject('Object Repository/MakeAppointment/book_appointment_button'))

		WebUI.verifyElementPresent(findTestObject('Object Repository/MakeAppointment/confirmation_message'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/MakeAppointment/go_to_home_page'))
	}
}
