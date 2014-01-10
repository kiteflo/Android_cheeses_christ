package com.jooik.kaesehoch.frags;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.jooik.kaesehoch.R;
import com.jooik.kaesehoch.domain.Cheese;

/**
 * Created by tzhmufl2 on 25.11.13.
 */
public class FragmentDetailsOverlay extends DialogFragment
{
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    private Cheese cheese;

    // ------------------------------------------------------------------------
    // public usage
    // ------------------------------------------------------------------------

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState)
    {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Drawable background = new ColorDrawable(getResources().getColor(R.color.overlay_body_beige));
        background.setAlpha(210);
        dialog.getWindow().setBackgroundDrawable(background);
        // dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setLayout(300,400);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_overlay, container);

        // tab slider
        sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager)view.findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        return view;
    }

    // ------------------------------------------------------------------------
    // inner classes
    // ------------------------------------------------------------------------

    /**
     * Used for tab paging...
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
            {
                // find first fragment...
                FragmentOverlayFirstTab fft = new FragmentOverlayFirstTab(cheese);
                return fft;
            }
            if (position == 1)
            {
                // find first fragment...
                FragmentOverlaySecondTab fft = new FragmentOverlaySecondTab();
                return fft;
            }
            else if (position == 2)
            {
                // find first fragment...
                FragmentOverlayThirdTab fft = new FragmentOverlayThirdTab();
                return fft;
            }

            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Beschreibung";
                case 1:
                    return "Bewertungen";
                case 2:
                    return "Kontext";
            }
            return null;
        }
    }

    // ------------------------------------------------------------------------
    // GETTER & SETTER
    // ------------------------------------------------------------------------

    public Cheese getCheese()
    {
        return cheese;
    }

    public void setCheese(Cheese cheese)
    {
        this.cheese = cheese;
    }
}