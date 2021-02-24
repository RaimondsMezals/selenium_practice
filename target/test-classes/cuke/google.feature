#Author: your.email@your.domain.com
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

Feature: Google various search terms
  I want to use this template for my feature file


  Scenario Outline: Google Kitten images
  	Given That I can access "<Domain>"
		When I search for "<Animal>"
		And I select the images tab
		Then I should be able to view images of "<Animal>"


    Examples: 
      | Animal		| Domain  							|
      | Kittens 	| http://www.google.com	|
      | Penguins 	| http://www.google.com |
      | Lions 		| http://www.google.com |
      | Puppies		| http://www.google.com |
      | Fish			| http://www.google.com |
