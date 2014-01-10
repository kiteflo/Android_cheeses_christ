package com.jooik.kaesehoch.domain.properties;

/**
 * Created by tzhmufl2 on 08.12.13.
 */
public class Condiment
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long id;
    private int condimentFactor; // sth. between 1 and 5...

    // ------------------------------------------------------------------------
    // constructors...
    // ------------------------------------------------------------------------

    public Condiment(){}
    public Condiment(int condimentFactor) {this.condimentFactor = condimentFactor; }

    // ------------------------------------------------------------------------
    // GETTER & SETTER
    // ------------------------------------------------------------------------

    public int getCondimentFactor()
    {
        return condimentFactor;
    }

    public void setCondimentFactor(int spiceFactor)
    {
        this.condimentFactor = spiceFactor;
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