package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
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
     */
    public static class PlaceholderFragment extends Fragment {

        /* Udacity initializes the adapter outside */
        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            /* StackOverflow Version
            http://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line */
            ArrayList<String> Weahter_list = new ArrayList<>();

            Weahter_list.add("Today - Sunny - 88/63");
            Weahter_list.add("Tomorrow - Foggy - 70/46");
            Weahter_list.add("Weds - Rain - 65/56");
            Weahter_list.add("Thurs - Cloudy - 65/56");
            Weahter_list.add("Fri - Cloudy - 65/56");
            Weahter_list.add("Sat - Sunny - 65/56");

            /* Udacity version */
            String[] AltWeather_list = {
                    "Mon 6/23 - Sunny - 31/17",
                    "Tue 6/24 - Foggy - 21/8",
                    "Wed 6/25 - Cloudy - 22/17",
                    "Thurs 6/26 - Rainy - 18/11",
                    "Fri 6/27 - Foggy - 21/10",
                    "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                    "Sun 6/29 - Sunny - 20/7"
            };

            List<String> weekForecast = new ArrayList<String>(Arrays.asList(AltWeather_list));

            /* Udacity Version of constructing the adapter */
            mForecastAdapter =
                new ArrayAdapter<String>(
                         getActivity(), // The current context (this activity)
                         R.layout.list_item_forecast, // The name of the layout ID.
                         R.id.list_item_forecast_textview, // The ID of the textview to populate.
                         weekForecast); // The array called


//            My attempt at initializing and constructing an adapter
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,weekForecast);

//            Call the adapter according to the documentation not yet learned on Udacity

/*            ListView listView = (R.layout.list_item_forecast) findViewById(R.layout.list_item_forecast);
            listView.setAdapter(adapter);*/

//            FrameLayout listview_forecast = this.find
            /* Udacity version of 1) finding the list view and 2) calling the view with the adapter method*/
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(adapter);

            return rootView;
        }
    }
}
