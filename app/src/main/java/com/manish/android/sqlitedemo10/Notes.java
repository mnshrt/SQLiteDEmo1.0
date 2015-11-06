package com.manish.android.sqlitedemo10;

/**
 * Created by emkayx on 06-11-2015.
 */
public class Notes {

    int _id;
    String _notetitle;

    public Notes(){}
    public Notes(String _notetitle) {
        this._notetitle = _notetitle;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_notetitle() {
        return _notetitle;
    }

    public void set_notetitle(String _notetitle) {
        this._notetitle = _notetitle;
    }
}
