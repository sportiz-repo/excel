package com.example.realation.modal;

import java.io.Serializable;
import java.util.Objects;

public class KeySet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chips;
	private int pid;

	public KeySet() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(chips, pid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeySet other = (KeySet) obj;
		return Objects.equals(chips, other.chips) && pid == other.pid;
	}

}
