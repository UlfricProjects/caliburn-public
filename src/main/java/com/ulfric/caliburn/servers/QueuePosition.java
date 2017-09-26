package com.ulfric.caliburn.servers;

import com.ulfric.caliburn.Bean;

public class QueuePosition extends Bean {

	private Integer index;
	private Integer total;
	private Integer priority;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
