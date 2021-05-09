package android.example.simplecalc;

import android.content.Context;

import androidx.test.filters.SmallTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.JMock1Matchers.equalTo;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matcher.*;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ExampleInstrumentedTest {

    private Calculator mCalculator;

    @Before
    public void setUp(){
        mCalculator = new Calculator();
    }

    @Test
    public void addTwoNumbers(){
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(Matchers.equalTo(2d)));
    }

    @Test
    public void addTwoNumberNegative(){
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(Matchers.equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats(){
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    @Test
    public void subTwoNumbers(){
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(Matchers.equalTo(0d)));
    }

    @Test
    public void subWorksWithNegativeResult(){
        double resultSub = mCalculator.sub(1d, 17d);
        assertThat(resultSub, is(-16d));
    }

    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(64d));
    }

    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv, is(16d));
    }
    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(32d,0);
        assertThat(resultDiv, is(Matchers.equalTo(Double.POSITIVE_INFINITY)));
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("android.example.simplecalc", appContext.getPackageName());
    }

}