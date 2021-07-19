/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/

package roomiesApp.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.*;
import java.sql.Date;

@Entity
// line 22 "../../roomiesapp.ump"
public class Roomie
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Roomie> roomiesByUsername = new HashMap<String, Roomie>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Roomie Attributes
  @Id
  private String username;
  private String phone;
  private String email;
  private String password;

  //Roomie Associations
  @OneToMany(targetEntity=Expense.class, mappedBy="roomie", fetch=FetchType.EAGER)
  private List<Expense> expenses;
  @ManyToOne
  @JoinColumn(name="eazzyRoomie")
  private EazzyRoomie eazzyRoomie;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Roomie(String aUsername, EazzyRoomie aEazzyRoomie)
  {
    phone = null;
    email = null;
    password = null;
    if (!setUsername(aUsername))
    {
      throw new RuntimeException("Cannot create due to duplicate username. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    expenses = new ArrayList<Expense>();
    boolean didAddEazzyRoomie = setEazzyRoomie(aEazzyRoomie);
    if (!didAddEazzyRoomie)
    {
      throw new RuntimeException("Unable to create roomy due to eazzyRoomie. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    String anOldUsername = getUsername();
    if (anOldUsername != null && anOldUsername.equals(aUsername)) {
      return true;
    }
    if (hasWithUsername(aUsername)) {
      return wasSet;
    }
    username = aUsername;
    wasSet = true;
    if (anOldUsername != null) {
      roomiesByUsername.remove(anOldUsername);
    }
    roomiesByUsername.put(aUsername, this);
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  
  public String getUsername()
  {
    return username;
  }
  /* Code from template attribute_GetUnique */
  public static Roomie getWithUsername(String aUsername)
  {
    return roomiesByUsername.get(aUsername);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithUsername(String aUsername)
  {
    return getWithUsername(aUsername) != null;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
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
  /* Code from template association_GetOne */
  @ManyToOne
  @JoinColumn(name="eazzyRoomie")
  public EazzyRoomie getEazzyRoomie()
  {
    return eazzyRoomie;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExpenses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Expense addExpense(Date aDate, String aDescription, int aCost, String aClaimant, EazzyRoomie aEazzyRoomie)
  {
    return new Expense(aDate, aDescription, aCost, aClaimant, aEazzyRoomie, this);
  }

  public boolean addExpense(Expense aExpense)
  {
    boolean wasAdded = false;
    if (expenses.contains(aExpense)) { return false; }
    Roomie existingRoomie = aExpense.getRoomie();
    boolean isNewRoomie = existingRoomie != null && !this.equals(existingRoomie);
    if (isNewRoomie)
    {
      aExpense.setRoomie(this);
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
    //Unable to remove aExpense, as it must always have a roomie
    if (!this.equals(aExpense.getRoomie()))
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
  /* Code from template association_SetOneToMany */
  public boolean setEazzyRoomie(EazzyRoomie aEazzyRoomie)
  {
    boolean wasSet = false;
    if (aEazzyRoomie == null)
    {
      return wasSet;
    }

    EazzyRoomie existingEazzyRoomie = eazzyRoomie;
    eazzyRoomie = aEazzyRoomie;
    if (existingEazzyRoomie != null && !existingEazzyRoomie.equals(aEazzyRoomie))
    {
      existingEazzyRoomie.removeRoomy(this);
    }
    eazzyRoomie.addRoomy(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    roomiesByUsername.remove(getUsername());
    for(int i=expenses.size(); i > 0; i--)
    {
      Expense aExpense = expenses.get(i - 1);
      aExpense.delete();
    }
    EazzyRoomie placeholderEazzyRoomie = eazzyRoomie;
    this.eazzyRoomie = null;
    if(placeholderEazzyRoomie != null)
    {
      placeholderEazzyRoomie.removeRoomy(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "email" + ":" + getEmail()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "eazzyRoomie = "+(getEazzyRoomie()!=null?Integer.toHexString(System.identityHashCode(getEazzyRoomie())):"null");
  }
}