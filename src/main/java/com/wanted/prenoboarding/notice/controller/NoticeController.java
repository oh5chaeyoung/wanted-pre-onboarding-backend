package com.wanted.prenoboarding.notice.controller;

import com.wanted.prenoboarding.notice.dto.NoticeRegisterRequest;
import com.wanted.prenoboarding.notice.dto.NoticeResponse;
import com.wanted.prenoboarding.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {
	private final NoticeService noticeService;
	@GetMapping("/{noticeId}")
	public ResponseEntity<NoticeResponse> noticeDetails(@PathVariable("noticeId") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(noticeService.findNoticeById(id));
	}
	@PostMapping
	public ResponseEntity<Long> noticeAdd(@RequestBody NoticeRegisterRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(noticeService.addNotice(request));
	}
}
