package com.example.week6weekend;

import com.example.week6weekend.model.helpers.OkHttpHelper;
import com.example.week6weekend.view.activities.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertNotNull;

public class RoboElectricTest {
    @RunWith(RobolectricTestRunner.class)
    @Config(manifest = Config.NONE)
    public class MainActivityTest {
        private MainActivity activity;

        @Before
        public void setUp() throws Exception {
            activity = Robolectric.buildActivity(MainActivity.class)
                    .create()
                    .resume()
                    .get();
        }

        @Test
        public void shouldNotBeNull() throws Exception {
            assertNotNull(activity);
        }

        @Test
        public void shouldHaveRecycler() throws Exception {
            assertNotNull(activity.findViewById(R.id.rvActMain));
        }

        @Test
        public void checkViewModelCall() throws Exception {
            assertNotNull(activity.activityMainBinding.getMainViewModel());
        }

        @Test
        public void checkApiCall() throws Exception {
            OkHttpHelper okHttpHelper = new OkHttpHelper();
        }
    }
}
