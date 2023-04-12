package ezen.project.IGSJ.review.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.project.IGSJ.review.dto.ReviewDTO;
import ezen.project.IGSJ.review.service.ReviewService;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private ReviewService reviewService;

	// 리뷰 목록 불러오기
	@ResponseBody
	@RequestMapping
	public List<ReviewDTO> getReviewList() throws Exception {

		logger.info("리뷰 목록 불러오기 controller");

		List<ReviewDTO> getReviewList = reviewService.getReviewList();

		return getReviewList;

	}

	// 리뷰 작성하기
	@ResponseBody
	@RequestMapping
	public boolean writeReview(@RequestBody ReviewDTO reviewDTO) throws Exception {

		logger.info("리뷰 작성 시작 controller");

		int writeResult = reviewService.writeReview(reviewDTO);

		if (writeResult == 1) {

			return true;
		} else {

			return false;
		}

	}

	// 리뷰 수정하기
	@ResponseBody
	@RequestMapping
	public boolean modifyReview(@RequestBody ReviewDTO reviewDTO) throws Exception {

		logger.info("리뷰 수정 시작 controller");

		int modifyResult = reviewService.modifyReview(reviewDTO);

		if (modifyResult == 1) {

			return true;
		} else {

			return false;
		}
	}

	// 리뷰 삭제하기
	@ResponseBody
	@RequestMapping
	public boolean removeReview(@RequestBody ReviewDTO reviewDTO) throws Exception {

		logger.info("리뷰 삭제 시작 controller");

		int removeResult = reviewService.removeReview(reviewDTO);

		if (removeResult == 1) {

			return true;
		} else {

			return false;
		}
	}

}
