Feature: Google Search
  Scenario: search my name
    Given I am chrome user
    When I visit google
    And key in shiva
    Then retrun the search results