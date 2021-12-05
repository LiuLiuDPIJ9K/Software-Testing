Feature: Testing the ContactUs page

  Background:
    Given the home page is opened
    And the Sign in is clicked

  Scenario:
    Given the email address is filled with "154029@email.com"
    And the Create account button is clicked
    And the first name is filled with "Jack"
    And the last name is filled with "Smith"
    And the password is filled with "Password"
    And the address is filled with "abc 123"
    And the city is filled with "New York"
    And phone number is filled with "6548852"
    When the register button is clicked
    Then a "The Zip/Postal code you've entered is invalid. It must follow this format: 00000" error message is shown