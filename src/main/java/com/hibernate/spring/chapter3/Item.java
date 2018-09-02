package com.hibernate.spring.chapter3;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Item {
	private String name;
	private String description;
	private BigDecimal reservePrice;
	private Date startDate;
	private Date endDate;
	private ItemState state;
	private Date approvalDatetime;
	private Set<Category> categories = new HashSet<Category>();
	
	public Item() {
		// empty
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final BigDecimal getReservePrice() {
		return reservePrice;
	}

	public final void setReservePrice(BigDecimal reservePrice) {
		this.reservePrice = reservePrice;
	}

	public final Date getStartDate() {
		return startDate;
	}

	public final void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public final Date getEndDate() {
		return endDate;
	}

	public final void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public final ItemState getState() {
		return state;
	}

	public final void setState(ItemState state) {
		this.state = state;
	}

	public final Date getApprovalDatetime() {
		return approvalDatetime;
	}

	public final void setApprovalDatetime(Date approvalDatetime) {
		this.approvalDatetime = approvalDatetime;
	}

	public final Set<Category> getCategories() {
		return categories;
	}

	public final void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Item [name=").append(name)
				.append(", description=").append(description)
				.append(", reservePrice=").append(reservePrice)
				.append(", startDate=").append(startDate)
				.append(", endDate=").append(endDate)
				.append(", state=").append(state)
				.append(", approvalDatetime=").append(approvalDatetime)
				.append(", categories=").append(categories)
				.append("]").toString();
	}
	
	
}
