/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/

package model;
import java.util.*;
import java.sql.Date;

// line 4 "../roomiesapp.ump"
public class EazzyRoomie
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EazzyRoomie Associations
  private List<Roomie> roomies;
  private List<Expense> expenses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EazzyRoomie()
  {
    roomies = new ArrayList<Roomie>();
    expenses = new ArrayList<Expense>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Roomie getRoomy(int index)
  {
    Roomie aRoomy = roomies.get(index);
    return aRoomy;
  }

  public List<Roomie> getRoomies()
  {
    List<Roomie> newRoomies = Collections.unmodifiableList(roomies);
    return newRoomies;
  }

  public int numberOfRoomies()
  {
    int number = roomies.size();
    return number;
  }

  public boolean hasRoomies()
  {
    boolean has = roomies.size() > 0;
    return has;
  }

  public int indexOfRoomy(Roomie aRoomy)
  {
    int index = roomies.indexOf(aRoomy);
    return index;
  }
  /* Code from template association_GetMany */
  public Expense getExpense(int index)
  {
    Expense aExpense = expenses.get(index);
    return aExpense;
  }

  public List<Expense> getExpenses()
  {
    List<Expense> newExpenses = Collections.unmodifiableList(expenses);
    return newExpenses;
  }

  public int numberOfExpenses()
  {
    int number = expenses.size();
    return number;
  }

  public boolean hasExpenses()
  {
    boolean has = expenses.size() > 0;
    return has;
  }

  public int indexOfExpense(Expense aExpense)
  {
    int index = expenses.indexOf(aExpense);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRoomies()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Roomie addRoomy(String aUsername)
  {
    return new Roomie(aUsername, this);
  }

  public boolean addRoomy(Roomie aRoomy)
  {
    boolean wasAdded = false;
    if (roomies.contains(aRoomy)) { return false; }
    EazzyRoomie existingEazzyRoomie = aRoomy.getEazzyRoomie();
    boolean isNewEazzyRoomie = existingEazzyRoomie != null && !this.equals(existingEazzyRoomie);
    if (isNewEazzyRoomie)
    {
      aRoomy.setEazzyRoomie(this);
    }
    else
    {
      roomies.add(aRoomy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoomy(Roomie aRoomy)
  {
    boolean wasRemoved = false;
    //Unable to remove aRoomy, as it must always have a eazzyRoomie
    if (!this.equals(aRoomy.getEazzyRoomie()))
    {
      roomies.remove(aRoomy);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRoomyAt(Roomie aRoomy, int index)
  {  
    boolean wasAdded = false;
    if(addRoomy(aRoomy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoomies()) { index = numberOfRoomies() - 1; }
      roomies.remove(aRoomy);
      roomies.add(index, aRoomy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRoomyAt(Roomie aRoomy, int index)
  {
    boolean wasAdded = false;
    if(roomies.contains(aRoomy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoomies()) { index = numberOfRoomies() - 1; }
      roomies.remove(aRoomy);
      roomies.add(index, aRoomy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRoomyAt(aRoomy, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExpenses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Expense addExpense(Date aDate, String aDescription, int aCost, Roomie aClaimant, Roomie aRoomie)
  {
    return new Expense(aDate, aDescription, aCost, aClaimant, this, aRoomie);
  }

  public boolean addExpense(Expense aExpense)
  {
    boolean wasAdded = false;
    if (expenses.contains(aExpense)) { return false; }
    EazzyRoomie existingEazzyRoomie = aExpense.getEazzyRoomie();
    boolean isNewEazzyRoomie = existingEazzyRoomie != null && !this.equals(existingEazzyRoomie);
    if (isNewEazzyRoomie)
    {
      aExpense.setEazzyRoomie(this);
    }
    else
    {
      expenses.add(aExpense);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeExpense(Expense aExpense)
  {
    boolean wasRemoved = false;
    //Unable to remove aExpense, as it must always have a eazzyRoomie
    if (!this.equals(aExpense.getEazzyRoomie()))
    {
      expenses.remove(aExpense);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addExpenseAt(Expense aExpense, int index)
  {  
    boolean wasAdded = false;
    if(addExpense(aExpense))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExpenses()) { index = numberOfExpenses() - 1; }
      expenses.remove(aExpense);
      expenses.add(index, aExpense);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveExpenseAt(Expense aExpense, int index)
  {
    boolean wasAdded = false;
    if(expenses.contains(aExpense))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExpenses()) { index = numberOfExpenses() - 1; }
      expenses.remove(aExpense);
      expenses.add(index, aExpense);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExpenseAt(aExpense, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (roomies.size() > 0)
    {
      Roomie aRoomy = roomies.get(roomies.size() - 1);
      aRoomy.delete();
      roomies.remove(aRoomy);
    }
    
    while (expenses.size() > 0)
    {
      Expense aExpense = expenses.get(expenses.size() - 1);
      aExpense.delete();
      expenses.remove(aExpense);
    }
    
  }

}