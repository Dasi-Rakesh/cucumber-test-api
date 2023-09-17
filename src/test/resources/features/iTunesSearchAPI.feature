@SearchAPI
Feature: iTunes Search API Testing

  Scenario: Search for Jack Johnson's content
    Given the base URL is "https://itunes.apple.com"
    When a GET request is sent to "/search" with parameters:
      | term          | jack+johnson |
    Then the response status code should be 200
    And the response should contain "Jack Johnson"

  Scenario: Search for Jack Johnson's music videos
    Given the base URL is "https://itunes.apple.com"
    When a GET request is sent to "/search" with parameters:
      | term    | jack+johnson |
      | entity  | musicVideo  |
    Then the response status code should be 200
    And the response should contain "Jack Johnson"
    And the response should contain "music-video"

  Scenario: Lookup Jack Johnson by iTunes artist ID
    Given the base URL is "https://itunes.apple.com"
    When a GET request is sent to "/lookup" with parameters:
      | id  | 909253 |
    Then the response status code should be 200
    And the response should contain "Jack Johnson"

