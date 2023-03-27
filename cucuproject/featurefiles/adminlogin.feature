@tag
Feature: Admin login
  I want to use this template to check Admin Login

  @tag1
  Scenario: Check Admin Login with valid data
  
  Given i open the browser with url "http://orangehrm.qedgetech.com"
  Then i should see login page
  When i enter username as "Admin"
  And i enter password as "Qedge123!@#"
  And i click login
  Then i should see admin module
  When i click logout
  Then i should see login page
  Then i close browser
  
  
  
  @tag2
  
  Scenario Outline: check Admin Loogin with Invalid data
  
  Given i open the browser with url "http://orangehrm.qedgetech.com"
  Then i should see login page
  When i enter username as "<username>"
  And i enter password as "<password>"
  And i click login
  Then is errormessage displayed
  Then i close browser
  
  Examples:
  
  |username|password|
  |Admin|xyz|
  |abc|Qedge123!@#|
  |xyz|abc|
  
  
