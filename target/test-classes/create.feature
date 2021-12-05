Feature: Create An Account testing

  Background:
    Given the home page is opened
    And Sign in is clicked

  Scenario Outline:
    Given the '<field>' is filled with '<parameter>'
    When the Create an account button is clicked
    Then the '<msg>' message is shown
    Examples:
      | field        | parameter         | msg                                                                                                                  |
      | email_create |                   | Invalid email address.                                                                                               |
      | email_create | test              | Invalid email address.                                                                                               |
      | email_create | test@email.com    | An account using this email address has already been registered. Please enter a valid password or request a new one. |