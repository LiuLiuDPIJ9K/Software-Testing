Feature: Contact Us testing

  Background:
    Given the home page is opened
    And Contact us is clicked

  Scenario Outline:
    Given the '<field>' is filled with '<parameter>'
    When the Send button is clicked
    Then the '<msg>' error message is shown
    Examples:
      | field   | parameter         | msg                          |
      | email   |                   | Invalid email address.       |
      | email   | test              | Invalid email address.       |
      | email   | test@email.com    | The message cannot be blank. |
      | message | test              | Invalid email address.       |