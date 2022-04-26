package com.talencuba.test.rest.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents the line of packed items.
 * 
 * @author Dalia Maria Berbes
 *
 */
public class LinePackedItems implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Total amount of packaged boxes
	 */
	@JsonInclude(Include.NON_NULL)
	private int packagesCount;
	
	/**
	 * Sequence of packages
	 */
	@JsonInclude(Include.NON_NULL)
	private List<PackagingBox> packages;

	public int getPackagesCount() {
		return packagesCount;
	}

	public void setPackagesCount(int packagesCount) {
		this.packagesCount = packagesCount;
	}

	public List<PackagingBox> getPackages() {
		return packages;
	}

	public void setPackages(List<PackagingBox> packages) {
		this.packages = packages;
	}

	
}
