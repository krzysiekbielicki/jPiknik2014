package com.example;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.example.dagger.Injector;
import com.example.fragment.FirstFragment;
import com.example.fragment.SecondFragment;
import com.example.transaction.TransactionPerformedEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

public class MainActivity extends FragmentActivity {

    @Inject
    Bus bus;

    @InjectView(R.id.tabhost)
    FragmentTabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Injector.inject(this);
        ButterKnife.inject(this);
        bus.register(this);

        setupTabs();
    }

    private void setupTabs() {
        tabHost.setup(this, getSupportFragmentManager());
        tabHost.addTab(tabHost.newTabSpec("payu").setIndicator("PayU"), FirstFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("wire").setIndicator("Wire"), SecondFragment.class, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }

    @Subscribe
    public void onTransactionPerformed(TransactionPerformedEvent event) {

    }
}

