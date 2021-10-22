

Feature: Cx to Amazon Website
  

  @cx
  Scenario: Authentification
    Given I am a user on Amazon website
    When I click on Bonjour button
    And I enter my email "emna.guedri.bn@gmail.com"
    And I click on continue button
    And I enter my password "Faculte02"
    And I click on s'identifier button
    Then Home page is displayed "Bonjour"
    


