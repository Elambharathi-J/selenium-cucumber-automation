Feature: To validate the Amazon Functionality
  #before
  @sc01 @Learnmore
  Scenario: Search Functionality
    #Given user navigate to Amazon Homepage
    When user enters the product name "Mouse" in search box
    And user clicks the search icon
    Then user validates the title of search result page

  Scenario: sign in validation
    Given user navigate to Amazon Homepage

    #before
    @MouseActions
   Scenario: Title validation
     Given user navigate to Amazon Homepage
     When user clicks on baby wishlist
     Then  validate the title

     #after
     @staticDropdown
    Scenario: Static dropdown handling
      #Given user navigate to Amazon Homepage
      When user selects the value from the category dropdown
       And user extract the value from the category dropdown
       Then validate the dropdown value

    #after
    @draganddrop
   Scenario: Drag and Drop
     # Given user navigate to jquery
      When user performs drag and drop actions

    @WikiTable
   Scenario: Table Handling
     Given user extract the column one values