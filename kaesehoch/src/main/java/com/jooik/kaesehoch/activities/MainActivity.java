package com.jooik.kaesehoch.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jooik.kaesehoch.R;
import com.jooik.kaesehoch.domain.Cheese;
import com.jooik.kaesehoch.domain.wrapper.CheeseWrapper;
import com.jooik.kaesehoch.frags.FragmentCheeseList;
import com.jooik.kaesehoch.network.IRestCallback;
import com.jooik.kaesehoch.util.ISquareItem;
import com.jooik.kaesehoch.util.ShadowProperties;
import com.jooik.kaesehoch.util.SquareItem;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements IRestCallback<Cheese>
{

    // ------------------------------------------------------------------------
    // member declaration
    // ------------------------------------------------------------------------

    private ProgressDialog progressDialog = null;

    // ------------------------------------------------------------------------
    // class method overriding
    // ------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initItems()
    {
        // trigger server call
        ServerCall call = new ServerCall("http://localhost:8080/3kaesehoch/rest/cheese",
                this);
        call.execute();
    }

    // ------------------------------------------------------------------------
    // interface implementation
    // ------------------------------------------------------------------------

    @Override
    public void preExecute()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading cheese...");
        progressDialog.show();
    }

    @Override
    public void postExecute(List<Cheese> response)
    {
        progressDialog.dismiss();

        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/SignPainter_HouseScript.ttf");

        int font_large = 35;
        int font_medium = 28;
        int font_small = 20;
        int font_color = Color.WHITE;
        ShadowProperties shadowProperties = new ShadowProperties(30,0,0,Color.BLACK);

        // tranform cheese to viewable square items...
        List<ISquareItem> squareItems = new ArrayList<ISquareItem>();

        for (Cheese cheese : response)
        {
            SquareItem squareItem = new SquareItem(cheese.getName(),cheese.getImageURL());
            squareItem.setCheese(cheese);
            squareItem.applyFontStyle(font_large,font_medium,font_small,face,font_color,shadowProperties);
            squareItems.add(squareItem);
        }

        FragmentCheeseList cheeseListFragment = new FragmentCheeseList();
        cheeseListFragment.setItems(squareItems);
        cheeseListFragment.setPadding(15);
        cheeseListFragment.setBackgroundColor("#000000");
        cheeseListFragment.setAvoidDuplicateRandomLayouts(true);

        getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, cheeseListFragment)
                    .commit();

    }

    @Override
    public String inExecute()
    {
        return null;
    }

    @Override
    public void cancelExecute()
    {

    }

    // ------------------------------------------------------------------------
    // inner classes
    // ------------------------------------------------------------------------

    /**
     * Server call wrapper.
     */
    private class ServerCall extends AsyncTask<String, Void, List<Cheese>>
    {
        private IRestCallback callback;
        private String url;

        public ServerCall(String url,IRestCallback callback)
        {
            this.url = url;
            this.callback = callback;
        }

        @Override
        protected void onPostExecute(List<Cheese> result) {
            super.onPostExecute(result);
            callback.postExecute(result);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.preExecute();
        }
        @Override
        protected List<Cheese> doInBackground(String... params) {
            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            CheeseWrapper cheeseWrapper = restTemplate.getForObject(url, CheeseWrapper.class);
            return cheeseWrapper.getCheeses();
        }
    }
}
