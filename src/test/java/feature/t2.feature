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
@us2
Feature: Search for a specific vacancy
 As a​ user 
 I want to​ be able to search on the open vacancies in the careers page 
 So that​ I can quickly find the open vacancies in Singapore that I’m interested in

  @us2_1
  Scenario: A free text filter field for keyword search with only alphanumeric and space characters such that any special character will be cleared
    Given the web browser is at the SG Digital​ Careers page
    Then a free text filter field is available to the user in the careers page for a keyword search
    When the 26 Alphabetic characters, the number 0 to 9, the spaces, the special characters  are entered in the filter input
    Then the alnumeric characters and spaces remain in the fiter input with the special character cleared
   
  @us2_2 
  Scenario Outline: If the user presses “Enter” or click "Search" a search action should be triggered and the new results will be displayed
    When the user performs action as "<action>" a search action should be triggered
    Then the new results will be displayed
    
  Examples: 
      |  action    |
      |Hit Enter   | 
      |Click Search|
      
   @us2_3
  Scenario: a “Location” filter is available, listing all available locations for the open vacancies such that filtering should apply automatically upon selecting a location
    Given the “Location” filter is available to list all available locations for the open vacancies
    When a location is selected
    Then filtering should apply automatically
      
      
      

