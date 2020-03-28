package com.lin.reswipecard;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.lin.cardlib.CardSetting;
import com.lin.cardlib.utils.ReItemTouchHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.lin.reswipecard", appContext.getPackageName());
    }

    @Test
    public void txTest() {
        CardSetting setting = new CardSetting.Builder()
                .setSwipeDirection(ReItemTouchHelper.DOWN)
                .build();

    }
}
