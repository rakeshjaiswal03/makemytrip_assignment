
@mmt
Feature: assingment of  Custom Travel Solutions Pune

  @mmt1
  Scenario Outline: testing MakeMyTrip
  Given launch browser and launch MakeMyTrip website
    And validate MMT Home page is displayed 
    And navigate to Hotels screen
   ### And click on Hotels menu
    When Search location "<city>"
    When From date should be 30 days from today
    When To date should be 32 days from today
    And Search result 
    And Capture the count of results
    Then observer top two hotels and capture the rate
    And Open details page of both entries and capture rates
    And campare rate and provide conclusion
   
  Examples: 
      |city		|
      |london |
