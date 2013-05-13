package net.itechnicians.GoodBadList;

public class Deed {

    //private variables
    int _id;
    String _desc;
    String _type;
    String _person_name;

    @Override
    public String toString() {
        return _desc;
    }
    // Empty constructor
    public Deed() {

    }


    // constructor
    public Deed(int id, String desc, String type) {
        this._id = id;
        this._desc = desc;
        this._type = type;
    }

    // constructor
    public Deed(String desc, String type) {
        this._desc = desc;
        this._type = type;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getDesc() {
        return this._desc;
    }

    // setting desc
    public void setDesc(String desc) {
        this._desc = desc;
    }

    // getting phone number
    public String getType() {
        return this._type;
    }

    // setting phone number
    public void setType(String type) {
        this._type = type;
    }
	public String get_person_name() {
		return _person_name;
	}
	public void set_person_name(String _person_name) {
		this._person_name = _person_name;
	}
	
}
