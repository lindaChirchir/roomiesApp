/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/

package model;
import java.sql.Date;

// line 17 "../roomiesapp.ump"
public class Expense
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Expense Attributes
  private Date date;
  private String description;
  private int cost;
  private Roomie claimant;

  //Expense Associations
  private EazzyRoomie eazzyRoomie;
  private Roomie roomie;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Expense(Date aDate, String aDescription, int aCost, Roomie aClaimant, EazzyRoomie aEazzyRoomie, Roomie aRoomie)
  {
    date = aDate;
    description = aDescription;
    cost = aCost;
    claimant = aClaimant;
    boolean didAddEazzyRoomie = setEazzyRoomie(aEazzyRoomie);
    if (!didAddEazzyRoomie)
    {
      throw new RuntimeException("Unable to create expense due to eazzyRoomie. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddRoomie = setRoomie(aRoomie);
    if (!didAddRoomie)
    {
      throw new RuntimeException("Unable to create expense due to roomie. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setCost(int aCost)
  {
    boolean wasSet = false;
    cost = aCost;
    wasSet = true;
    return wasSet;
  }

  public boolean setClaimant(Roomie aClaimant)
  {
    boolean wasSet = false;
    claimant = aClaimant;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public String getDescription()
  {
    return description;
  }

  public int getCost()
  {
    return cost;
  }

  public Roomie getClaimant()
  {
    return claimant;
  }
  /* Code from template association_GetOne */
  public EazzyRoomie getEazzyRoomie()
  {
    return eazzyRoomie;
  }
  /* Code from template association_GetOne */
  public Roomie getRoomie()
  {
    return roomie;
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
      existingEazzyRoomie.removeExpense(this);
    }
    eazzyRoomie.addExpense(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRoomie(Roomie aRoomie)
  {
    boolean wasSet = false;
    if (aRoomie == null)
    {
      return wasSet;
    }

    Roomie existingRoomie = roomie;
    roomie = aRoomie;
    if (existingRoomie != null && !existingRoomie.equals(aRoomie))
    {
      existingRoomie.removeExpense(this);
    }
    roomie.addExpense(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    EazzyRoomie placeholderEazzyRoomie = eazzyRoomie;
    this.eazzyRoomie = null;
    if(placeholderEazzyRoomie != null)
    {
      placeholderEazzyRoomie.removeExpense(this);
    }
    Roomie placeholderRoomie = roomie;
    this.roomie = null;
    if(placeholderRoomie != null)
    {
      placeholderRoomie.removeExpense(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "," +
            "cost" + ":" + getCost()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "claimant" + "=" + (getClaimant() != null ? !getClaimant().equals(this)  ? getClaimant().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "eazzyRoomie = "+(getEazzyRoomie()!=null?Integer.toHexString(System.identityHashCode(getEazzyRoomie())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "roomie = "+(getRoomie()!=null?Integer.toHexString(System.identityHashCode(getRoomie())):"null");
  }
}