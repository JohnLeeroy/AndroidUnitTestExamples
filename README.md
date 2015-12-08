

# Test Patron Buying a Drink
### Setup
We create Matt to test the Patron class.  
PatronHelper is a child of the Patron class which helps reveal unaccesable properties for our tests.  
We also create a mocked Cafe object.  It emulates the class without knowing about the implementation.

@Before is called before every test.  
```java
    @Before
    public void SetUp(){
        mMatt = new PatronHelper("Matt", 100);
        mCafe = mock(Cafe.class);
    }
```
### Creating a mocked Drink
```java
    DrinkInterface getMockedDrink(String targetDrinkName, float cost) {
        //Creates the mocked object based on the class
        DrinkInterface nukaColaMock = mock(DrinkInterface.class);

        //when getCost is called on the object, return 
        when(nukaColaMock.getCost()).thenReturn(cost);
        when(nukaColaMock.getName()).thenReturn(targetDrinkName);
        return nukaColaMock;
    }
```
Creates a mocked or dummy DrinkInterface object without copying any of the functionality.
```java
        DrinkInterface nukaColaMock = mock(DrinkInterface.class);
```
When getCost is called, it will return the value of cost.  
When getName is called, it will return the value of targetDrinkName.

```java
    when(nukaColaMock.getCost()).thenReturn(cost);
    when(nukaColaMock.getName()).thenReturn(targetDrinkName);
```

### All Together Now
This creates a Nuka Cola mocked drink.  
Makes sure the mocked cafe returns Nuka Cola.  
Check if Matt has a Nuka Cola soft drink.  
```java
    @Test
    public void BuyDrinkWithEnoughMoney() throws Patron.NotEnoughMoneyException {
        //create mocked drink
        String targetDrinkName = "Nuka Cola";
        DrinkInterface nukaColaMock = getMockedDrink(targetDrinkName, 4);
        
        when(mCafe.sellDrink(targetDrinkName)).thenReturn(nukaColaMock);

        mMatt.enterCafe(mCafe);
        mMatt.purchaseDrinkFromCafe(targetDrinkName);

        assertFalse(mMatt.mDrinksInPossession.isEmpty());
        assert(mMatt.mDrinksInPossession.get(0) == nukaColaMock);
    }
```
---
### Checkout more examples in the codebase
