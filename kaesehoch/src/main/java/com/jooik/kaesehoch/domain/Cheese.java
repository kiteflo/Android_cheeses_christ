package com.jooik.kaesehoch.domain;

/**
 * Real world cheese representation.
 */
public class Cheese
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long id;
    private String name;
    private String description;
    private String maturingTime;
    private String imageURL;

    // ------------------------------------------------------------------------
    // GETTER & SETTER
    // ------------------------------------------------------------------------


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getMaturingTime()
    {
        return maturingTime;
    }

    public void setMaturingTime(String maturingTime)
    {
        this.maturingTime = maturingTime;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }
}
