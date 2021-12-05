Feature: Newsletter testing

  Background:
    Given the home page is opened

  Scenario Outline:
    Given the '<field>' is filled with '<parameter>'
    When the OK button is clicked
    Then the '<msg>' output message is shown
    Examples:
      | field            | parameter         | msg                                       |
      | newsletter-input |                   | Invalid email address.                    |
      | newsletter-input | testing           | Invalid email address.                    |
      | newsletter-input | valid@email.com   | This email address is already registered. |