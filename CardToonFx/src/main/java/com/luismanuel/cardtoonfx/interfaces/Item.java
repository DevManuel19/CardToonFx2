package com.luismanuel.cardtoonfx.interfaces;

public interface Item {
    //This is a generic interface to interoperate between Movie and Book class
    //It is used in MainController.java to set the data in the grid

    //Both Book and Movie classes implement this interface so the grid can be
    //filled with both types of objects.

    //For this project, both are separated, but they could be in the same grid
    //This means you can put both books and movies in the same grid

    /**
     * This method returns the resource of the object
     * @return String resource
     */
    public String getResource();

    /**
     * This method returns the class type of the object
     * This is used to distinguish between Book and Movie since instanceof is not allowed
     * @return Class classType
     */
    public Class getClassType();
}
