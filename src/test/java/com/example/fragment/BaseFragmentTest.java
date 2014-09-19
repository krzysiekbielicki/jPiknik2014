package com.example.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import com.example.R;
import com.example.dagger.Injector;
import com.example.transaction.RandomAmount;
import org.fest.assertions.api.ANDROID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;

import javax.inject.Inject;

import static org.mockito.BDDMockito.given;

@RunWith(RobolectricTestRunner.class)
public class BaseFragmentTest {

    @Inject
    RandomAmount randomAmount;

    private Fragment fragment;

    @Before
    public void setUp() throws Exception {
        Injector.reset(new RandomAmountMockModule());
        Injector.inject(this);
        fragment = createFragment();
    }

    @Test
    public void shouldPutRandomNumberInAmountAfterButtonClick() {
        // given
        double value = 100.0;
        given(randomAmount.getAmount()).willReturn(value);
        Button button = ButterKnife.findById(fragment.getView(), R.id.random);

        // when
        button.performClick();

        // then
        EditText amount = ButterKnife.findById(fragment.getView(), R.id.amount);
        ANDROID.assertThat(amount).hasTextString(String.valueOf(value));
    }

    private Fragment createFragment() {
        FragmentActivity activity = new ActivityController<FragmentActivity>(FragmentActivity.class).create().resume().get();
        Fragment fragment = new FirstFragment();
        activity.getSupportFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        return fragment;
    }
}