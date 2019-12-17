package net.openrs.cache.definition_dumpers;

public class Item {
	
	private String name = "Null";
	private String examine = "Unknown";
	private int id, slot, notedId, unnotedId = -1;
	private int highAlchValue, lowAlchValue, grandExchangePrice, value, attackSpeed = 0;
	private double weight = 0;
	private boolean members, tradeable, stackable, twoHanded, fullHelm, mask, fullBody;
	private int[] bonusses = new int[14];
	private int[] requirements = new int[23];
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExamine() {
		return examine;
	}
	
	public void setExamine(String examine) {
		this.examine = examine;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSlot() {
		return slot;
	}
	
	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	public boolean isEquipable() {
		return slot != -1;
	}
	
	public int getNotedId() {
		return notedId;
	}
	
	public void setNotedId(int notedId) {
		this.notedId = notedId;
	}
	
	public boolean isNoteable() {
		return notedId != -1;
	}
	
	public int getUnnotedId() {
		return unnotedId;
	}
	
	public void setUnnotedId(int unnotedId) {
		this.unnotedId = unnotedId;
	}
	
	public boolean isNoted() {
		return unnotedId != -1;
	}
	
	public int getHighAlchValue() {
		return highAlchValue;
	}
	
	public void setHighAlchValue(int highAlchValue) {
		this.highAlchValue = highAlchValue;
	}
	
	public int getLowAlchValue() {
		return lowAlchValue;
	}
	
	public void setLowAlchValue(int lowAlchValue) {
		this.lowAlchValue = lowAlchValue;
	}
	
	public int getGrandExchangePrice() {
		return grandExchangePrice;
	}
	
	public void setGrandExchangePrice(int grandExchangePrice) {
		this.grandExchangePrice = grandExchangePrice;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getAttackSpeed() {
		return attackSpeed;
	}
	
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public boolean isMembers() {
		return members;
	}
	
	public void setMembers(boolean members) {
		this.members = members;
	}
	
	public boolean isTradeable() {
		return tradeable;
	}
	
	public void setTradeable(boolean tradeable) {
		this.tradeable = tradeable;
	}
	
	public boolean isStackable() {
		return stackable;
	}
	
	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}
	
	public boolean isTwoHanded() {
		return twoHanded;
	}
	
	public void setTwoHanded(boolean twoHanded) {
		this.twoHanded = twoHanded;
	}
	
	public boolean isFullHelm() {
		return fullHelm;
	}
	
	public void setFullHelm(boolean fullHelm) {
		this.fullHelm = fullHelm;
	}
	
	public boolean isMask() {
		return mask;
	}
	
	public void setMask(boolean mask) {
		this.mask = mask;
	}
	
	public boolean isFullBody() {
		return fullBody;
	}
	
	public void setFullBody(boolean fullBody) {
		this.fullBody = fullBody;
	}
	
	public int[] getBonusses() {
		return bonusses;
	}
	
	public void setBonusses(int[] bonusses) {
		this.bonusses = bonusses;
	}
	
	public int[] getRequirements() {
		return requirements;
	}
	
	public void setRequirements(int[] requirements) {
		this.requirements = requirements;
	}
	
}
