package com.jooik.kaesehoch.domain;

/**
 * Created by tzhmufl2 on 30.11.13.
 */
public class Animal
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private Long id;

    private String name;

    // ------------------------------------------------------------------------
    // constructors...
    // ------------------------------------------------------------------------

    public Animal() {}

    public Animal(String name)
    {
        this.name = name;
    }

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
}
