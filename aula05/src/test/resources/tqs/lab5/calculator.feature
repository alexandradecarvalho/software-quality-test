Feature: Basic Arithmetic
  Background: A Calculator
    Given A calculator I just turned on

    Scenario: Addition
      When I add 4 and 5
      Then The result is 9

    Scenario: Subtraction
      When I subtract 7 to 2
      Then The result is 5

    Scenario Outline: Several Additions
      When I add <a> and <b>
      Then The result is <c>

    Examples: Single Digits
      | a | b | c  |
      | 1 | 2 | 3  |
      | 3 | 7 | 10 |
