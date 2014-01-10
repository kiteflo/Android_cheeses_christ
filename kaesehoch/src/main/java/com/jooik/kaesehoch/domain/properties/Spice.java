package com.jooik.kaesehoch.domain.properties;

/**
 * Created by tzhmufl2 on 08.12.13.
 */
public class Spice
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long id;
    private int spiceFactor; // sth. between 1 and 5...

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public Spice(){}
    public Spice(int spiceFactor){this.spiceFactor = spiceFactor;}

    // ------------------------------------------------------------------------
    // GETTER & SETTER
    // ------------------------------------------------------------------------

    public int getSpiceFactor()
    {
        return spiceFactor;
    }

    public void setSpiceFactor(int spiceFactor)
    {
        this.spiceFactor = spiceFactor;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
