import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject

try {
	//Initiate object id
	def postUserNew 	  = 'Object Repository/API/POST_Create_user'
	def getUserByUsername = 'Object Repository/API/GET_username'
	def putUser			  = 'Object Repository/API/PUT_user'
	
	def json = new JsonSlurper()
	//post user new
	ResponseObject postUser = WS.sendRequest(findTestObject(postUserNew))
	WS.verifyResponseStatusCode(postUser, 200)
	assertThat(postUser.getStatusCode()).isEqualTo(200)
	def getResponse = postUser.getResponseText()
	def getData = json.parseText(getResponse)
	String usname = getData.username
	String fiName = getData.firstName 
	GlobalVariable.username = usname 
	GlobalVariable.first_name = fiName
	
	String respName, respFiname
	respName   = getData.username
	respFiname = getData.firstName
	
	if(respName == GlobalVariable.username && respFiname == GlobalVariable.first_name){  
		//mark test success
		KeywordUtil.markPassed("Create user success")
	}else{
		//mark test failed
		KeywordUtil.markFailed('User not created')
	}
	
	//get username
	ResponseObject getUser = WS.sendRequest(findTestObject(getUserByUsername))
	WS.verifyResponseStatusCode(getUser, 200)
	assertThat(getUser.getStatusCode()).isEqualTo(200)
	getResponse = getUser.getResponseText()
	getData = json.parseText(getResponse)
	
	if(respName == GlobalVariable.username){
		//mark test success
		KeywordUtil.markPassed("User detail listed")
	}else{
		//mark test failed
		KeywordUtil.markFailed('User not listed')
	}
	
	//put user existing
	ResponseObject updateUser = WS.sendRequest(findTestObject(putUser))
	WS.verifyResponseStatusCode(getUser, 200)
	assertThat(updateUser.getStatusCode()).isEqualTo(200)
	getResponse = updateUser.getResponseText()
	getData = json.parseText(getResponse)
	
	if(respFiname != GlobalVariable.first_name){
		//mark test success
		KeywordUtil.markPassed("Update user success")
	}else{
		//mark test failed
		KeywordUtil.markFailed('User not updated')
	}
	
	
}catch(ex) {
	println ex
}