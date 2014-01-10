package com.jooik.kaesehoch.domain.properties;

/**
 * Created by tzhmufl2 on 08.12.13.
 */
public class Intensity
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long id;
    private int intensityFactor; // sth. between 1 and 5...

    // ------------------------------------------------------------------------
    // constructors...
    // ------------------------------------------------------------------------

    public Intensity(){}
    public Intensity(int intensityFactor) {this.intensityFactor = intensityFactor; }

    // ------------------------------------------------------------------------
    // GETTER & SETTER
    // ------------------------------------------------------------------------

    public int getIntensityFactor()
    {
        return intensityFactor;
    }

    public void setIntensityFactor(int intensityFactor)
    {
        this.intensityFactor = intensityFactor;
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