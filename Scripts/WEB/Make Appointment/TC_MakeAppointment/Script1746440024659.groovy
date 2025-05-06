import static com.kms.katalon.core.model.FailureHandling.STOP_ON_FAILURE

import internal.GlobalVariable as GlobalVariable

 //Get the CommonKeywords
CustomKey customKey = new CustomKey()
try {
	customKey.makeAppointment(facility, readmission, program, visitDate, comment)
}catch(ex) {
	customKey.failure("", STOP_ON_FAILURE)
}	
