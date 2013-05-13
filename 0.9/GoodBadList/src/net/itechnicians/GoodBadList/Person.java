package net.itechnicians.GoodBadList;

public class Person {

	// private variables
	int _person_id;
	String _person_name;

	@Override
	public String toString() {
		return _person_name;
	}

	// Empty constructor
	public Person() {

	}

	// constructor
	public Person(int id, String name) {
		this._person_id = id;
		this._person_name = name;

	}

	// constructor
	public Person(String name) {

		this._person_name = name;
	}

	public int get_person_id() {
		return _person_id;
	}

	public void set_person_id(int _person_id) {
		this._person_id = _person_id;
	}

	public String get_person_name() {
		return _person_name;
	}

	public void set_person_name(String _person_name) {
		this._person_name = _person_name;
	}

}
