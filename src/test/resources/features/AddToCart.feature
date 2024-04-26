# language: en
# Author: Juan Felipe Velasco Garcia

Feature: Add products to cart

  Background:
    Given the user enters the website

  @Test1
  Scenario Outline: The user adds a product to the cart without logging in
    When the user adds a product to the cart
      | productName   | quantity   |
      | <productName> | <quantity> |
    Then check the product in the cart
      | productName   |
      | <productName> |

    Examples:
      | productName       | quantity |
      | Iphone 6 32gb     | 1        |
      | Samsung galaxy s6 | 1        |
      | Nexus 6           | 1        |

    #Refinar test case
  @Test2
  Scenario Outline: The logged user adds a product to the cart
    And the user enters his credentials
      | user         | password  |
      | PragmaFelipe | pragma123 |
    When the user adds a product to the cart
      | productName   | quantity   |
      | <productName> | <quantity> |
    Then check the product in the cart
      | productName   |
      | <productName> |

    Examples:
      | productName      | quantity |
      | Sony vaio i7     | 1        |
      | Nokia lumia 1520 | 1        |
      | HTC One M9       | 1        |

  @Test3
  Scenario Outline: The user adds a product to the cart from the categories
    And select the category
      | category   |
      | <category> |
    When the user adds a product to the cart
      | productName   | quantity   |
      | <productName> | <quantity> |
    Then check the product in the cart
      | productName   |
      | <productName> |

    Examples:
      | category | productName    | quantity |
      | Phones   | Sony xperia z5 | 1        |
      | Laptops  | Dell i7 8gb    | 1        |
      | Monitors | ASUS Full HD   | 1        |

  @Test4
  Scenario Outline: The user adds two products from the same category
    And select the category
      | category   |
      | <category> |
    When the user adds a product to the cart
      | productName   | quantity   |
      | <productName> | <quantity> |
    And the user adds the second product to the cart
      | category   | productName2   | quantity   |
      | <category> | <productName2> | <quantity> |
    Then check the product in the cart
      | productName   |
      | <productName> |
    And check the second product in the cart
      | productName2   |
      | <productName2> |

    Examples:
      | category | productName      | productName2        | quantity |
      | Phones   | Nexus 6          | Iphone 6 32gb       | 1        |
      | Laptops  | Sony vaio i5     | 2017 Dell 15.6 Inch | 1        |
      | Monitors | Apple monitor 24 | ASUS Full HD        | 1        |

  @Test5
  Scenario Outline: The user adds two products from different categories
    When the user adds a product to the cart
      | category   | productName   | quantity   |
      | <category> | <productName> | <quantity> |
    And the user adds the second product to the cart
      | category2   | productName2   | quantity   |
      | <category2> | <productName2> | <quantity> |
    Then check the product in the cart
      | productName   |
      | <productName> |
    And check the second product in the cart
      | productName2   |
      | <productName2> |

    Examples:
      | category | productName      | category2 | productName2   | quantity |
      | Laptops  | Dell i7 8gb      | Phones    | Sony xperia z5 | 1        |
      | Monitors | Apple monitor 24 | Laptops   | MacBook Pro    | 1        |
      | Phones   | Nokia lumia 1520 | Monitors  | ASUS Full HD   | 1        |

    #Refinar test case
  @Test6
  Scenario Outline: The user adds n times the same product
    And select the category
      | category   |
      | <category> |
    When the user adds a product to the cart
      | productName   | quantity   |
      | <productName> | <quantity> |
    Then check the product and the quantity
      | productName   | quantity   |
      | <productName> | <quantity> |

    Examples:
      | category | productName       | quantity |
      | Monitors | ASUS Full HD      | 3        |
      | Phones   | Samsung galaxy s7 | 2        |
      | Laptops  | MacBook air       | 4        |

  @Test7
  Scenario Outline: validate the total of the cart
    And select the category
      | category   |
      | <category> |
    When the user adds a product to the cart
      | productName   | quantity   |
      | <productName> | <quantity> |
    Then check the total
      | price   | quantity   |
      | <price> | <quantity> |

    Examples:
      | category | productName      | price | quantity |
      | Monitors | Apple monitor 24 | 400   | 2        |
      | Phones   | Iphone 6 32gb    | 790   | 1        |
      | Laptops  | MacBook Pro      | 1100  | 5        |