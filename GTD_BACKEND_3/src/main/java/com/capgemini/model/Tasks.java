package com.capgemini.model;

import java.util.Date;
import java.util.Objects;

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
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@RestResource(rel="tareas", path="tareas")
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
	@JoinColumn(name = "propietario_id")
	private Propietario propietario;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "category_id")
	private Categories category;

	public Tasks() {
	}

	public Tasks(String comments, Date created, Date finished, Date planned, String title, Long categoryId,
			Long userId, String observations) {
		this.comments = comments;
		this.created = created;
		this.finished = finished;
		this.planned = planned;
		this.title = title;
		this.observations = observations;
	}

	public Tasks(Long id, String comments, Date created, Date finished, Date planned, String title, Long categoryId,
			Long userId, String observations) {
		this.id = id;
		this.comments = comments;
		this.created = created;
		this.finished = finished;
		this.planned = planned;
		this.title = title;
		this.observations = observations;
	}

	public Long getId() {
		return id;
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

	

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, comments, created, finished, id, observations, planned, propietario, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		return Objects.equals(category, other.category) && Objects.equals(comments, other.comments)
				&& Objects.equals(created, other.created) && Objects.equals(finished, other.finished)
				&& Objects.equals(id, other.id) && Objects.equals(observations, other.observations)
				&& Objects.equals(planned, other.planned) && Objects.equals(propietario, other.propietario)
				&& Objects.equals(title, other.title);
	}


}
