package com.jooik.kaesehoch.frags;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jooik.kaesehoch.R;
import com.jooik.kaesehoch.domain.Cheese;
import com.jooik.kaesehoch.util.RetrieveImage;
import com.jooik.kaesehoch.util.ShadowProperties;

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
        tv_title.setTypeface(typeFace);
        tv_title.setTextColor(getResources().getColor(R.color.overlay_font_beige));
        tv_title.setShadowLayer(shadowProperties.getRadius(),
                shadowProperties.getDx(),
                shadowProperties.getDy(),
                shadowProperties.getColor());
        tv_title.setTextSize(45);
        tv_title.setText(cheese.getName());

        ImageView ivMainImage = (ImageView)view.findViewById(R.id.iv_cheese_mainimage);
        new RetrieveImage(ivMainImage).execute(cheese.getImageURL());
        ivMainImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return view;
    }
}