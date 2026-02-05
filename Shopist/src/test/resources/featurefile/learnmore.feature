Feature:  Learnmore

  @LoginLearnMore
  Scenario Outline: error message validation
    #Given user navigates to SalesForce Login page
    #beforestep
    When  user enters the username "<UserName>" and password "<Password>"
    #afterstep
    And user clicks the login button
    #afterstep
    Then validate the error message
    #afterstep

  Examples:
    |UserName | Password|
    |abc      |123      |
    |lmti     |xyz      |