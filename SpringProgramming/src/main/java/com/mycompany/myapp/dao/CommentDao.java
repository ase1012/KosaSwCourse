package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Comment;

@Component
public class CommentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Integer insert(Comment comment) {
		
		Integer pk = null;
		String sql = "insert into comments (comment_writer, music_no, comment_date, comment_content) values(?, ?, now(), ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "comment_no" });
				pstmt.setString(1, comment.getWriter());
				pstmt.setInt(2, comment.getMusicNo());
				pstmt.setString(3, comment.getContent());
				
				return pstmt;
			}
		}, keyHolder);
		Number keyNumber = keyHolder.getKey();
		pk = keyNumber.intValue();
		return pk;
	}
	
	public Comment selectList(int musicNo) {
		String sql = "select comment_writer, comment_date, comment_content from comments c, music m where m.music_no=c.music_no";
		Comment comment = jdbcTemplate.queryForObject(sql, new Object[] { musicNo }, new RowMapper<Comment>() {
			@Override
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Comment comment= new Comment();
				comment.setWriter(rs.getString("comment_writer"));
				comment.setDate(rs.getDate("comment_date"));
				comment.setContent(rs.getString("comment_content"));
				return comment;
			}
		});
		return comment;
	}
	
	public int update(Comment comment) {
		String sql = "update comments set comment_writer=?, comment_content=? where comment_no=?";
		int rows = jdbcTemplate.update(sql, comment.getWriter(), comment.getContent(), comment.getNo(), comment.getMusicNo());
		return rows;
	}

	public int delete(int musicNo) {
		String sql = "delete from music where music_no=?";
		int rows = jdbcTemplate.update(sql, musicNo);
		return rows;
	}

	public int selectCount() {
		String sql = "select count(*) from comments";
		int rows = jdbcTemplate.queryForObject(sql, Integer.class);
		return rows;
	}
}