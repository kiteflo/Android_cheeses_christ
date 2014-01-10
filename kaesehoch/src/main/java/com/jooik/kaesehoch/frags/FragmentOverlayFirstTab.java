package com.jooik.kaesehoch.frags;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jooik.kaesehoch.R;
import com.jooik.kaesehoch.domain.Cheese;
import com.jooik.kaesehoch.domain.properties.Condiment;
import com.jooik.kaesehoch.domain.properties.Intensity;
import com.jooik.kaesehoch.domain.properties.Spice;
import com.jooik.kaesehoch.libs.TextJustify;
import com.jooik.kaesehoch.util.RetrieveImage;
import com.jooik.kaesehoch.util.ShadowProperties;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by tzhmufl2 on 25.11.13.
 */
public class FragmentOverlayFirstTab extends Fragment
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private View view;
    private Cheese cheese;

    public FragmentOverlayFirstTab(){}

    public FragmentOverlayFirstTab(Cheese cheese)
    {
        this.cheese = cheese;
    }

    // ------------------------------------------------------------------------
    // public usage
    // ------------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_overlay_first_tab, container, false);

        // apply custom fonts as stupid Android does not give you the possibility
        // of specifying "advanced" properties (such as custom font style) via XML...
        TextView tv_title = (TextView)view.findViewById(R.id.tv_tab1_title);
        Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SignPainter_HouseScript.ttf");
        ShadowProperties shadowProperties = new ShadowProperties(30,0,0, Color.BLACK);
        applyFont(tv_title, 45);
        tv_title.setText(cheese.getName());

        // apply font to condiment
        TextView tv_condiment = (TextView)view.findViewById(R.id.tv_condiment);
        applyFont(tv_condiment,25);

        // apply font to spice
        TextView tv_spice = (TextView)view.findViewById(R.id.tv_spice);
        applyFont(tv_spice,25);

        // apply font to intensity
        TextView tv_intensity = (TextView)view.findViewById(R.id.tv_intensity);
        applyFont(tv_intensity,25);

        // apply cheese ratings...
        applyRatings(view);

        // set description title...
        TextView tv_description_title =(TextView)view.findViewById(R.id.tv_description_title);
        applyFont(tv_description_title,35);

        // set description contents...
        TextView tv_description = (TextView)view.findViewById(R.id.tv_description);
        tv_description.setTextColor(getResources().getColor(R.color.overlay_font_beige));
        tv_description.setTextSize(15);
        tv_description.setText(cheese.getDescription());
        TextJustify.run(tv_description, 305f);

        ImageView ivMainImage = (ImageView)view.findViewById(R.id.iv_cheese_mainimage);
        new RetrieveImage(ivMainImage).execute(cheese.getImageURL());
        ivMainImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return view;
    }

    //-------------------------------------------------------------------------
    // private usage
    // ------------------------------------------------------------------------

    /**
     * Apply cheese ratings...
     * @param view
     */
    private void applyRatings(View view)
    {
        // apply condiment rating...
        Set<Condiment> condiments = cheese.getCondiments ();
        int votings = 0;
        int stars = 0;
        Iterator<Condiment> condimentIterator = condiments.iterator();
        while (condimentIterator.hasNext())
        {
            Condiment condiment = condimentIterator.next();
            votings++;
            stars = stars + condiment.getCondimentFactor();
        }

        float rating = stars/votings;
        RatingBar ratingBar = (RatingBar)view.findViewById(R.id.rb_condiment);
        ratingBar.setRating(rating);

        // apply spice rating...
        Set<Spice> spices = cheese.getSpices();
        votings = 0;
        stars = 0;
        Iterator<Spice> spiceIterator = spices.iterator();
        while (spiceIterator.hasNext())
        {
            Spice spice = spiceIterator.next();
            votings++;
            stars = stars + spice.getSpiceFactor();
        }

        rating = stars/votings;
        ratingBar = (RatingBar)view.findViewById(R.id.rb_spice);
        ratingBar.setRating(rating);

        // apply intensity rating...
        Set<Intensity> intensities = cheese.getIntensities();
        votings = 0;
        stars = 0;
        Iterator<Intensity> intensityIterator = intensities.iterator();
        while (intensityIterator.hasNext())
        {
            Intensity intensity = intensityIterator.next();
            votings++;
            stars = stars + intensity.getIntensityFactor();
        }

        rating = stars/votings;
        ratingBar = (RatingBar)view.findViewById(R.id.rb_intensity);
        ratingBar.setRating(rating);
    }

    /**
     * Apply GTA font to label...
     * @param textView
     */
    private void applyFont(TextView textView,int fontSize)
    {
        Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SignPainter_HouseScript.ttf");
        ShadowProperties shadowProperties = new ShadowProperties(30,0,0, Color.BLACK);

        textView.setTypeface(typeFace);
        textView.setTextColor(getResources().getColor(R.color.overlay_font_beige));
        textView.setShadowLayer(shadowProperties.getRadius(),
                shadowProperties.getDx(),
                shadowProperties.getDy(),
                shadowProperties.getColor());
        textView.setTextSize(fontSize);
    }
}