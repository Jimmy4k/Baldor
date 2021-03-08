package Player;

import java.util.ArrayList;

import Items.Trank;
import Items.Weapons;

public class Player {

	private String name;
	private int health = 100;
	private ArrayList<Weapons> weaponBag = new ArrayList<Weapons>();
	private ArrayList<Trank> trankBag = new ArrayList<>();


	public ArrayList<Trank> getTrankBag() {
		return trankBag;
	}

	public void setTrankBag(ArrayList<Trank> trankBag) {
		this.trankBag = trankBag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public ArrayList<Weapons> getWeaponBag() {
		return weaponBag;
	}

	public void setWeaponBag(ArrayList<Weapons> weaponBag) {
		this.weaponBag = weaponBag;
	}
}