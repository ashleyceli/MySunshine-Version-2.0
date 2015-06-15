package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     * FRAGMENT - Modular container within your activity
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> forecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            /**
             *fragment_main - Layout XML file resource
             * (\\res\layout\)
             * converts hierarchy of view object in memory
             */
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //Dummy Forecast Data
            String[] forecastArray = {
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/40",
                    "Wed - Cloudy - 72/63",
                    "Thurs - Asteroids - 75/65",
                    "Fri - Heavy Rain - 65/56",
                    "Sat - Eclipse - 60/51",
                    "Sun - Sunny - 80/68"
            };

            List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

            //The ArrayAdapter will take data from a source (e.g weekForecast array)
            //use it to populate the ListView it's attached to
            forecastAdapter =
                    new ArrayAdapter<String>(
                            //The current context (this fragment's current activity
                            getActivity(),
                            //ID of list item layout (xml file)
                            R.layout.list_item_forecast,
                            //ID of textview to populate
                            R.id.list_item_forecast_textview,
                            //Forecast data
                            weekForecast);

            //Get reference to the adapter, and attach this adapter to the ListView
            ListView weekView = (ListView) rootView.findViewById(R.id.listView_forecast);
            weekView.setAdapter(forecastAdapter);

            return rootView;
        }
    }
}
