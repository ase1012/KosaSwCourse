package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Music;

@Component
public class MusicDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Integer insert(Music music) {
		Integer pk = null;
		String sql = "insert into music (music_title, music_content, music_singer, music_price, music_original_file_name, music_filesystem_name, music_content_type) values(?, ?, ?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "music_no" });
				pstmt.setString(1, music.getTitle());
				pstmt.setString(2, music.getContent());
				pstmt.setString(3, music.getSinger());
				pstmt.setInt(4, music.getPrice());
				pstmt.setString(5, music.getOriginalFileName());
				pstmt.setString(6, music.getFilesystemName());
				pstmt.setString(7, music.getContentType());
				return pstmt;
			}
		}, keyHolder);
		Number keyNumber = keyHolder.getKey();
		pk = keyNumber.intValue();
		return pk;
	}

	public List<Music> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "";
		sql += "select music_no, music_title, music_singer, music_price ";
		sql += "from music ";
		sql += "order by music_no desc ";
		sql += "limit ?,?";

		List<Music> list = jdbcTemplate.query(sql, new Object[] { (pageNo - 1) * rowsPerPage, rowsPerPage },
				new RowMapper<Music>() {
					@Override
					public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
						Music music = new Music();
						music.setNo(rs.getInt("music_no"));
						music.setTitle(rs.getString("music_title"));
						music.setSinger(rs.getString("music_singer"));
						music.setPrice(rs.getInt("music_price"));
						return music;
					}
				});
		return list;
	}

	public Music selectByPk(int musicNo) {
		String sql = "select * from music where music_no=?";
		Music music = jdbcTemplate.queryForObject(sql, new Object[] { musicNo }, new RowMapper<Music>() {
			@Override
			public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
				Music music = new Music();
				music.setNo(rs.getInt("music_no"));
				music.setTitle(rs.getString("music_title"));
				music.setSinger(rs.getString("music_singer"));
				music.setPrice(rs.getInt("music_price"));
				music.setContent(rs.getString("music_content"));
				music.setOriginalFileName(rs.getString("music_original_file_name"));
				music.setFilesystemName(rs.getString("music_filesystem_name"));
				music.setContentType(rs.getString("music_content_type"));
				return music;
			}
		});
		return music;
	}

/*	public int update(Music music) {
		String sql = "update music set music_singer=?, music_price=? where music_no=?";
		int rows = jdbcTemplate.update(sql, music.getSinger(), music.getPrice(), music.getNo());
		return rows;
	}

	public int delete(int musicNo) {
		String sql = "delete from music where music_no=?";
		int rows = jdbcTemplate.update(sql, musicNo);
		return rows;
	}*/

	public int selectCount() {
		String sql = "select count(*) from music";
		int rows = jdbcTemplate.queryForObject(sql, Integer.class);
		return rows;
	}
}