Feature: Check Register form functionality

  Background: 
    Given User launch the browser
    And Enter the URL as "https://demo.automationtesting.in/Register.html"

  @UI
  Scenario Outline: Check Register form steps
    Given User is on "Register" page
    When User enters firstname "<Firstname>", lastname "<Lastname>", email "<Email>", password "<Password>" and confirm password "<Cpassword>"
    And Upload the user image
    And Select the Hobbies as "Cricket"

    Examples: 
      | Firstname | Lastname | Email           | Password  | Cpassword |
      | Nitin     | Singh    | Nitin@yahoo.com | Nitin@123 | Nitin@123 |
