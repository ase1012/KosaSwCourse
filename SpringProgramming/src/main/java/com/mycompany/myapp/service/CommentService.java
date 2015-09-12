package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.CommentDao;
import com.mycompany.myapp.dto.Comment;

@Component
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public void list(int musicNo) {
		commentDao.selectList(musicNo);
	}
	
	public void add(Comment comment) {
		commentDao.insert(comment);
	}
	
	public void modify(Comment comment) {
		commentDao.update(comment);
	}
	
	public void remove(int musicNo) {
		commentDao.delete(musicNo);
	}	
	
	public int getTotalCommentNo() {
		int rows = commentDao.selectCount();
		return rows;
	}

	public Comment getComment(int musicNo) {
	Comment comment = commentDao.selectList(musicNo);
	return comment;
	}
}
