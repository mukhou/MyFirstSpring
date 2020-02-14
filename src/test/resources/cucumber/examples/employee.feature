Feature: Employee feature

  Scenario: Verify employee get
    Given I have a saved employee
    When I call get endpoint
    Then I get back employee details