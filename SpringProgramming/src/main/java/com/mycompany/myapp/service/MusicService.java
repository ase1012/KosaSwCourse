package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.MusicDao;
import com.mycompany.myapp.dto.Music;

@Component
public class MusicService {
	@Autowired
	private MusicDao musicDao;
	
	public void add(Music music) {
		musicDao.insert(music);
	}
	
	public List<Music>  getPage(int pageNo, int rowsPerPage) {
		List<Music> list = musicDao.selectByPage(pageNo, rowsPerPage);
		return list;
	}
	
	public Music getMusic(int musicNo) {
		Music music = musicDao.selectByPk(musicNo);
		return music;
	}
	/*
	public void modify(Music music) {
		musicDao.update(music);
	}
	
	public void remove(int musicNo) {
		musicDao.delete(musicNo);
	}	
	*/
	public int getTotalMusicNo() {
		int rows = musicDao.selectCount();
		return rows;
	}
}
