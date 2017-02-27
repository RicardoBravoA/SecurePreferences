package com.rba.securesharedpreference.main;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.rba.securesharedpreference.R;
import com.rba.securesharedpreference.storage.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.tilDescription) TextInputLayout tilDescription;
    @BindView(R.id.txtDescription) AppCompatEditText txtDescription;
    @BindView(R.id.lblDescription) AppCompatTextView lblDescription;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mainPresenter = new MainPresenter(this);
        load();

    }

    @Override
    public void load() {
        String description = SessionManager.getDescription(this);

        if(!description.isEmpty()){
            txtDescription.setText(description);
            lblDescription.setText(getString(R.string.description_label, description));
            lblDescription.setVisibility(View.VISIBLE);
        }else{
            lblDescription.setVisibility(View.GONE);
        }

    }

    @OnClick(R.id.btnSave)
    public void onClickSave(){
        String description = txtDescription.getText().toString().trim();
        if(mainPresenter.isdDescription(description)){
            SessionManager.addDescription(this, description);
            load();
        }else{
            Toast.makeText(this, "Enter description", Toast.LENGTH_SHORT).show();
        }
    }


}
