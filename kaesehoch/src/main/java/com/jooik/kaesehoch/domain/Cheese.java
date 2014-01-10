package com.jooik.kaesehoch.domain;

import com.jooik.kaesehoch.domain.properties.Condiment;
import com.jooik.kaesehoch.domain.properties.Intensity;
import com.jooik.kaesehoch.domain.properties.Spice;

import java.util.HashSet;
import java.util.Set;

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
    private Animal animal;

    // taste factors...
    private Set<Spice> spices = new HashSet<Spice>();
    private Set<Intensity> intensities = new HashSet<Intensity>();
    private Set<Condiment> condiments = new HashSet<Condiment>();

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

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }

    public Animal getAnimal() { return animal; }

    public void setAnimal(Animal animal) { this.animal = animal; }

    public Set<Spice> getSpices()
    {
        return spices;
    }

    public void setSpices(Set<Spice> spices)
    {
        this.spices = spices;
    }

    public Set<Intensity> getIntensities()
    {
        return intensities;
    }

    public void setIntensities(Set<Intensity> intensities)
    {
        this.intensities = intensities;
    }

    public Set<Condiment> getCondiments()
    {
        return condiments;
    }

    public void setCondiments(Set<Condiment> condiments)
    {
        this.condiments = condiments;
    }
}
