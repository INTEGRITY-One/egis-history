package com.ionep.egis.current.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(schema="EGIS_WEATHER")
public class CloudConditions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
//	private Cloudiness cloudiness;
	@NonNull
	int cloudiness;

//	public Cloudiness getCloudiness() {
//		return this.cloudiness;
//	}
//
//	public void setCloudiness(Cloudiness cloudiness) {
//		this.cloudiness = cloudiness;
//	}
//
	@OneToMany(mappedBy="cloudConditions")
	private List<CurrentConditions> measurements = new ArrayList<>();
	
	public CloudConditions() {
	}
	
	public CloudConditions(int cloudiness) {
		this.cloudiness = cloudiness;
	}
	
	public CloudConditions from(CloudConditions cloudConditions) {
		this.cloudiness = cloudConditions.cloudiness;
		return this;
	}
	
	public int getCloudiness() {
		return this.cloudiness;
	}

	public void setCloudiness(int cloudiness) {
		this.cloudiness = cloudiness;
	}

}
