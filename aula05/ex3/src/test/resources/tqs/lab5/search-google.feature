Feature: Search in Google

  Scenario: Book a flight
    When I navigate to "https://blazedemo.com/"
    And I select from "Mexico City"
    And I select to "Cairo"
    And I fill in my name with "Jon Snow"
    And I fill in my address with "123 Main Street"
    And I fill in my city with "Mexico City"
    And I fill in my state with "Mexico"
    And I fill in my zip code with "12345"
    And I fill in my credit card number with "12345678910"
    And I fill in my credit card month with "05"
    And I fill in my credit card year with "2017"
    And I fill in my credit card name with "Jon Snow"
    Then I should be "Jon Snow" from "123 Main Street", "Mexico City", "Mexico" at "12345" with "Jon Snow"'s credit card "12345678910" until "05" of "2017"
