package com.ulfric.caliburn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class Bean {

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	public final String toJson() {
		return GSON.toJson(this);
	}

	public final <T> T transform(Type type) {
		return GSON.fromJson(toJson(), type);
	}

	@Override
	public String toString() {
		return toJson();
	}

	@Override
	public boolean equals(Object that) {
		if (that == this) {
			return true;
		}

		if (that == null) {
			return false;
		}

		if (that.getClass() != this.getClass()) {
			return false;
		}

		Bean thatBean = (Bean) that;
		return toJson().equals(thatBean.toJson());
	}

	@Override
	public int hashCode() {
		return toJson().hashCode();
	}

}
