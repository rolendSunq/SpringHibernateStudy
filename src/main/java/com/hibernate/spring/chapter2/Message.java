package com.hibernate.spring.chapter2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGES")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MESSAGE_ID")
	private Long id;
	
	@Column(name = "MESSAGE_TEXT")
	private String text;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "NEXT_MESSAGE_ID"))
	private Message nextMessage;
	
	public Message() {
		// empty
	}

	public Message(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Message getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(Message nextMessage) {
		this.nextMessage = nextMessage;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Message [id=").append(id)
				.append(", text=").append(text)
				.append(", nextMessage=").append(nextMessage)
				.append("]").toString();
	}
	
	
}
