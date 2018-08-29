package com.hibernate.spring.chapter2;

import javax.persistence.Entity;

@Entity
public class Message_ {
	// 식별자 속성
	private Long id;
	
	// 메시지 텍스트
	private String text;
	
	// 다른 Message 인스턴스에 대한 참조
	private Message_ nextMessage;

	public Message_() {
		// empty
	}
	
	public Message_(String text) {
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

	public Message_ getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(Message_ nextMessage) {
		this.nextMessage = nextMessage;
	}
	
	

}
