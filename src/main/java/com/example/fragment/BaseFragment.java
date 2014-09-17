package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.example.BarcodeScanner;
import com.example.R;
import com.example.dagger.Injector;
import com.example.transaction.AccountTransactionPerformer;
import com.example.transaction.RandomAmount;
import dagger.Lazy;

import javax.inject.Inject;
import javax.inject.Provider;

public abstract class BaseFragment extends Fragment {

    @Inject
    Provider<RandomAmount> randomAmountProvider;
    @Inject
    Lazy<BarcodeScanner> barcodeScanner;

    @InjectView(R.id.amount)
    EditText amount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.random)
    public void randomizeAmount() {
        amount.setText(String.valueOf(randomAmountProvider.get().getAmount()));
    }

    @OnClick(R.id.scan)
    public void scan() {
        Toast.makeText(getActivity(), "BarcodeScanner instance: " + barcodeScanner.get(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.transfer)
    public void transfer() {
        getAccountTransactionPerformer().transfer(getAmountFromUi());
    }

    private double getAmountFromUi() {
        return Double.parseDouble(amount.getText().toString());
    }

    protected abstract AccountTransactionPerformer getAccountTransactionPerformer();
}
