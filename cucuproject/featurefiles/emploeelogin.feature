
@tag
Feature: Title of your feature
  I want to use this template to validate new employee Registration

  @tag1
  Scenario: Check New Employee Registration With Valid Data
  
   Given i open the browser with url "http://orangehrm.qedgetech.com"
  When i enter username as "Admin"
  And i enter password as "Qedge123!@#"
  And i click login
  Then i should see admin module 
    When i goto add employee page
    And i enter firstname as "sabhyatha"
    And i enter last name as "samskaram"
    And click save
    Then i should see registered employee in employee list
    When i click logout
  Then i close browser

 
