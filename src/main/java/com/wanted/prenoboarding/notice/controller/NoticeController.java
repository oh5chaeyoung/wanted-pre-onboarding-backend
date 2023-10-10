package com.wanted.prenoboarding.notice.controller;

import com.wanted.prenoboarding.notice.dto.NoticeModifyRequest;
import com.wanted.prenoboarding.notice.dto.NoticeRegisterRequest;
import com.wanted.prenoboarding.notice.dto.NoticeResponse;
import com.wanted.prenoboarding.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {
	private final NoticeService noticeService;
	@GetMapping
	public ResponseEntity<List<NoticeResponse>> noticeList() {
		return ResponseEntity.status(HttpStatus.OK).body(noticeService.findAllNotices());
	}
	@GetMapping("/{noticeId}")
	public ResponseEntity<NoticeResponse> noticeDetails(@PathVariable("noticeId") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(noticeService.findNoticeById(id));
	}
	@PostMapping
	public ResponseEntity<Long> noticeAdd(@RequestBody NoticeRegisterRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(noticeService.addNotice(request));
	}
	@PutMapping("/{noticeId}")
	public ResponseEntity<NoticeResponse> noticeModify(@PathVariable("noticeId") Long id,
	                                                   @RequestBody NoticeModifyRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(noticeService.modifyNotice(id, request));
	}
	@DeleteMapping("/{noticeId}")
	public ResponseEntity<Long> noticeRemove(@PathVariable("noticeId") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(noticeService.removeNotice(id));
	}
}
