package com.rba.securesharedpreference.main;

/**
 * Created by Ricardo Bravo on 27/02/17.
 */

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public boolean isdDescription(String description){
        return !description.isEmpty();
    }

}
