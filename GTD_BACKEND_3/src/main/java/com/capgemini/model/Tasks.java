package com.capgemini.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "comments")
	private String comments;

	@Column(name = "created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;

	@Column(name = "finished")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date finished;

	@Column(name = "planned")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date planned;

	@Column(name = "title")
	private String title;

	@Column(name = "observations")
	private String observations;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "owner_id")
	private Propietario propietario;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "category_id")
	private Categories category;

	public Tasks() {
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", comments=" + comments + ", created=" + created + ", finished=" + finished
				+ ", planned=" + planned + ", title=" + title + ", observations=" + observations + ", propietario="
				+ propietario + ", category=" + category + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getFinished() {
		return finished;
	}

	public void setFinished(Date finished) {
		this.finished = finished;
	}

	public Date getPlanned() {
		return planned;
	}

	public void setPlanned(Date planned) {
		this.planned = planned;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}


	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	


}
