<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Login and logout</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>3</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>true</rerunImmediately>
   <testSuiteGuid>ae963499-ec35-455d-b6b0-11a839f4ec7a</testSuiteGuid>
   <testCaseLink>
      <guid>f467f3fd-6c5c-44b4-bc51-2b3c2914fa6f</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/WEB/Login Logout/TC_Login</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>e36e1388-f0e6-4324-ba80-5c75e93c4bf4</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/WEB/Login Logout/TC_LoginWithInvalidCredential</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>23b4944f-827b-4f78-9e79-e4f7f3ec14e8</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/LoginData</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>23b4944f-827b-4f78-9e79-e4f7f3ec14e8</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>username</value>
         <variableId>97ad09f1-d67c-4741-b6b2-c003f70b94ea</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>23b4944f-827b-4f78-9e79-e4f7f3ec14e8</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>password</value>
         <variableId>2a357b73-7ca1-43b4-828b-bf721bb5a6ff</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>23b4944f-827b-4f78-9e79-e4f7f3ec14e8</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>errorMessage</value>
         <variableId>b5d103bc-aeb2-4b52-8d63-60b61e726be4</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>64d9ee9d-9884-484f-8909-4370ce2560c6</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/WEB/Login Logout/TC_Logout</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
</TestSuiteEntity>
