package com.atguigu.team.domain;

public class Designer extends Programmer {

	private double bonus;

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	// 9 史玉柱 26 9800.0 设计师 FREE 5500.0 惠普m6(5800.0)
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDatails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t设计师\t" + getBonus();
	}
}
