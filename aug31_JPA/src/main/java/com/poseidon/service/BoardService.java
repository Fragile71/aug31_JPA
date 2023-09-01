package com.poseidon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.entity.JBoard;
import com.poseidon.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public List<JBoard> findAll() {
		return boardRepository.findAll();
	}

	public void save(JBoard jBoard) {
		boardRepository.save(jBoard);
	}

	public JBoard findByBno(int bno) {

		return boardRepository.findByBno(bno);
	}
}
