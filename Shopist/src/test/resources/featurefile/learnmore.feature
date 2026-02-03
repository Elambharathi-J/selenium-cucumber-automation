Feature:  Learnmore

  @LoginLearnMore
  Scenario: error message validation
    #Given user navigates to SalesForce Login page
    When  user enters the username "learnmore" and password "123"
    And user clicks the login button
    Then validate the error message