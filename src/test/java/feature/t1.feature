#Author: John Thun from your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@us1
Feature: Navigate to the open Vacancies section
  As a​ user 
  I want to​ be able to quickly navigate to the open vacancies page 
  So that​ I can quickly view the open vacancies in SGDigital

  @us1_1
  Scenario: A new menu titled "Careers" in the top menu of SG Digital home page where a click on it will lead to the Careers page
    Given the web browser is at the SG Digital​ home page
    Then a new menu should be displayed in the top menu
    Then menu text should be “Careers”
    When a user clicks on the menu item "Careers" 
    Then he should be navigated into the Careers page
    
