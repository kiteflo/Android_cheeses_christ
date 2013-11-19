package com.jooik.kaesehoch.domain.wrapper;

import com.jooik.kaesehoch.domain.Cheese;

import java.util.List;

/**
 * Created by tzhmufl2 on 19.11.13.
 */
public class CheeseWrapper
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private List<Cheese> cheeses;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public CheeseWrapper(){}

    public CheeseWrapper(List<Cheese> cheeses)
    {
        this.cheeses = cheeses;
    }

    // ------------------------------------------------------------------------
    // GETTER & SETTER
    // ------------------------------------------------------------------------

    public List<Cheese> getCheeses()
    {
        return cheeses;
    }

    public void setCheeses(List<Cheese> cheeses)
    {
        this.cheeses = cheeses;
    }
}
