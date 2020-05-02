package com.assignment.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "price_component")
@JsonInclude(Include.NON_NULL)
public class PriceComponent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "name",unique = true, nullable = false,length = 50)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "is_discount")
	private boolean isDiscount;

	@Column(name = "is_required")
	private boolean isRequired;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "priceComponent", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CourseDetailPriceComponent> courseDetailPriceComponents = new HashSet<CourseDetailPriceComponent>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDiscount() {
		return isDiscount;
	}

	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}

	public Set<CourseDetailPriceComponent> getCourseDetailPriceComponents() {
		return courseDetailPriceComponents;
	}

	public void setCourseDetailPriceComponents(Set<CourseDetailPriceComponent> courseDetailPriceComponents) {
		this.courseDetailPriceComponents = courseDetailPriceComponents;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

}
