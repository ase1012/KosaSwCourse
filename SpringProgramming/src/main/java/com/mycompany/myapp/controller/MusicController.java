package com.mycompany.myapp.controller;
import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Comment;
import com.mycompany.myapp.dto.Music;
import com.mycompany.myapp.service.MusicService;
import com.mycompany.myapp.service.CommentService;


@Controller
public class MusicController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private MusicService musicService;
	
	@RequestMapping("/music/list")
	public String list(@RequestParam(defaultValue = "1") int pageNo, Model model, HttpSession session) {
		logger.info("pageNo: " + pageNo);

		session.setAttribute("pageNo", pageNo);

		// 페이징을 위한 변수 선언
		int rowsPerPage = 10;
		int pagesPerGroup = 5;

		// 전체 게시물 수
		int totalMusicNo = musicService.getTotalMusicNo();

		// 전체 페이지 수
		int totalPageNo = totalMusicNo / rowsPerPage;
		if (totalMusicNo % rowsPerPage != 0) {
			totalPageNo++;
		}

		// 전체 그룹 수
		int totalGroupNo = totalPageNo / pagesPerGroup;
		if (totalPageNo % pagesPerGroup != 0) {
			totalGroupNo++;
		}

		// 현재 그룹번호, 시작페이지번호, 끝페이지번호
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}

		// 현재 페이지 게시물 리스트
		List<Music> list = musicService.getPage(pageNo, rowsPerPage);

		// View로 넘길 데이터
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);

		return "music/list";
	}

	@RequestMapping("/music/writeForm")
	public String writeForm() {
		logger.info("writeForm()");
		return "music/writeForm";
	}
	
	@RequestMapping("/music/write")
	public String write(Music music, HttpSession session) {
		logger.info("write()");

		// 파일 정보 얻기
		ServletContext application = session.getServletContext();
		String dirPath = application.getRealPath("/resources/uploadfiles");
		String originalFilename = music.getAttach().getOriginalFilename();
		String filesystemName = System.currentTimeMillis() + "-" + originalFilename;
		String contentType = music.getAttach().getContentType();

		if (!music.getAttach().isEmpty()) {
			// 파일에 저장하기
			try {
				music.getAttach().transferTo(new File(dirPath + "/" + filesystemName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 데이터베이스에 게시물 정보 저장

		if (!music.getAttach().isEmpty()) {
			music.setOriginalFileName(originalFilename);
			music.setFilesystemName(filesystemName);
			music.setContentType(contentType);
		}
		musicService.add(music);

		return "redirect:/music/list";
	}
	
	/*@RequestMapping("/music/writecomment")
	public String writecomment(Comment comment) {
		logger.info("writecomment()");

		commentService.add(comment);

		return "redirect:/music/detail";
	}
	*/
	@RequestMapping("/music/updateForm")
	public String updateForm(int musicNo, Model model) {
		Music music = musicService.getMusic(musicNo);
		model.addAttribute("music", music);
		return "music/updateForm";
	}

	
	@RequestMapping("/music/update")
	public String update(Music music) {
		musicService.modify(music);
		return "redirect:/music/detail?musicNo=" + music.getNo();
	}
	
	@RequestMapping("/music/detail")
	public String detail(int musicNo, Model model) {
		Music music = musicService.getMusic(musicNo);
		model.addAttribute("music", music);
		
		return "music/detail";
	}

	@RequestMapping("/music/delete")
	public String delete(int musicNo) {
		musicService.remove(musicNo);
		return "redirect:/music/list";
	}

}
