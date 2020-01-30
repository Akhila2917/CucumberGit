Feature: Pixel store Pos

  Background: 
    Given Sales executive logged into the machine

 @RegressionTest
 Scenario: Executive signup
 Given executive is at the signup registration
 When executive provides "admin"and "admin"
 Then signup successful
 @smoke @RegressionTest
 Scenario: shopping to cart
 Given executive added the items to cart
 When items price is calculated
 Then bill is generated with final amount
@FunctionalTest
  Scenario Outline: Sales executive signIn
    When Sales executive provides "<user>" and "<password>" as credentials
    Then Login is successful

    Examples: 
      | user    | password    |
      | Lalitha | password123 |
      | John    | Ravi123     |
@datadriven
Scenario: search a product
When Larry searches for product in search field
     |Head|
     |Hand|
     |Lap|
Then Larry verifies the product