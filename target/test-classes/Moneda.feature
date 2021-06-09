#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step ---dado una condicion
#When: Some key actions ---cuando ejecuto tal cosa
#Then: To observe outcomes or validation ----entonces pasa esto
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Monedas

  @compararMonedas
  Scenario Outline: 
    Given la moneda local "<monedaLocal>"
    And la moneda extranjera "<monedaExtranjera>"
    When escribo las monedas en el buscador 
    And le doy submit
    Then leo el valor de la moneda

 

    Examples: 
      | monedaLocal     | monedaExtranjera |
      | peso colombiano | dolar americano  |

