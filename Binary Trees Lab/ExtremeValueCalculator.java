/*
  ExtremeValueCalculator class
  @author Preston Stosur-Bassett
  Creation Date: 2.11.14

  The ExtremeValueCalculator implements NodeVisitor interface.
  It determines the largest and smallest values in a tree.
*/

import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;


public class ExtremeValueCalculator implements NodeVisitor {
  private Object largest = null;
  private Object smallest = null;
  private String typed;

  /*
    The constructor of ExtremeValueCalculator will create a new object and set the instance variables of the objects that it will be calculating
    @param String dataType a string of the data type that this class can calculate, either 'String' or 'Integer'
    @throws IllegalArgumentException when the datatype passed to it is not String or Integer
  */
  public ExtremeValueCalculator(String dataType) {
    if(dataType.equals("String")) {
      //Cast the largest and smallest as strings
      largest = (String) largest;
      smallest = (String) smallest;
    }
    else if(dataType.equals("Integer")) {
      //Cast the largest and smallest as Integers
      largest = (Integer) largest;
      smallest = (Integer) smallest;
    }
    else {
      //Handle something else here
      throw new IllegalArgumentException;
    }
    typed = dataType;
  }

  /*
    visit method determines the largest and smallest values in the tree
    @param Object data
    @throws InputMismatchException when the data type of the Object passed to this method is not the same as the data type `this` object was initialzied with
    @throws IllegalArgumentException when the data type of the object passed to thsi method is not either String or Integer
  */
  public void visit(Object data) {
    if(typed.equals("String")) {
      //Handle String comparisons here
      if(data instanceOf String) {
        //Go ahead cast and do comparison
        String stringData = (String)data;
        if(stringData.compareTo(largest) > 0) {
          largest = stringData;
        }
        if(stringData.compareTo(smallest) < 0) {
          smallest = stringData;
        }
      }
      else {
        //Throw an error, data types do not match
        throw new InputMisMatchException;
      }
    }
    else if(typed.equals("Integer")) {
      //Hanlde Integer comparisons here
      if(data instanceOf Integer) {
        //Go ahead an cast and do comparison
        Integer integerData = (Integer)data;
        if(integerData.compareTo(largest) > 0) {
          largest = integerData;
        }
        if(integerData.compareTo(smallest) < 0) {
          smallest = integerData;
        }
      }
      else {
        //Throw an error, data types do not match
        throw new InputMismatchException;
      }
    }
    else {
      //Handle something else here
      throw new IllegalArgumentException;
    }
  }

  /*
    getLargest returns the largest value of the traversed tree
    @return Object largest the largest value in the tree, null if tree has not been traversed
  */
  public Object getLargest() {
    Object returnLargest = (Object)largest;
    return returnLargest;
  }

  /*
    getSmallest returns the smallest value of the traversed tree
    @return Object smallest the smallest value in the tree, null if the tree has not been traversed
  */
  public Object getSmallest() {
    Object returnSmallest = (Object)smallest;
    return returnSmallest;
  }
}
