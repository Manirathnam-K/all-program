Feature: Naukri Web Application Testing
Scenario: Login Functionality
  Given User launches the browser
  And User navigates to Naukri application
  When User enters valid email "ajaykirthick7@gmail.com" in the email field
  And User enters valid password "Ajay1983@007" in the password field
  And User clicks login button
  Then User should be redirected to homepage
  And User name "Ajay Kirthick" should be displayed

Scenario: Profile Update Basic Details
  Given User is on profile page
  When User selects experienced work status
  And User enters total experience
  And User enters current salary
  And User selects salary breakdown as fixed
  And User selects current location as "India"
  And User selects availability to join
  And User clicks save button
  Then Profile details should be updated successfully

Scenario: Resume Upload Functionality
  Given User is on profile page
  When User uploads resume file
  Then Resume should be uploaded successfully


Scenario: Resume Headline Update
  Given User is on profile page
  When User updates resume headline
  And User clicks save button
  Then Resume headline should be updated successfully


Scenario: Key Skills Update
  Given User is on profile page
  When User updates key skills
  And User clicks save button
  Then Key skills should be updated successfully


Scenario: Employment Update
  Given User is on profile page
  When User adds employment details
  And User clicks save button
  Then Employment details should be updated successfully


Scenario: Education Update
  Given User is on profile page
  When User adds education details
  And User clicks save button
  Then Education details should be updated successfully


Scenario: IT Skills Update
  Given User is on profile page
  When User adds IT skills details
  And User clicks save button
  Then IT skills should be updated successfully


Scenario: Project Update
  Given User is on profile page
  When User adds project details
  And User clicks save button
  Then Project details should be updated successfully


Scenario: Profile Summary Update
  Given User is on profile page
  When User updates profile summary
  And User clicks save button
  Then Profile summary should be updated successfully


Scenario: Career Profile Update
  Given User is on profile page
  When User updates career profile details
  And User clicks save button
  Then Career profile should be updated successfully


Scenario: Personal Details Update
  Given User is on profile page
  When User updates personal details
  And User clicks save button
  Then Personal details should be updated successfully


Scenario: Logout Functionality
  Given User is on profile page
  When User clicks on profile icon
  And User clicks logout button
  Then User should be redirected to login page
  
  
  

 
