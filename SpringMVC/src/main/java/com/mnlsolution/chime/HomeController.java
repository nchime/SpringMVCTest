package com.mnlsolution.chime;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/springTest")
public class HomeController {

	
	 @Autowired
     private SqlSession sqlSession;
		
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		logger.info("list method call");

		model.addAttribute("serverTime", "한글 Test");

		return "home";
	}
	
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list2(Locale locale, Model model) {
		logger.info("list method call");

		model.addAttribute("serverTime", "한글 Test");

		return "home";
	}
	

	@ResponseBody
	@RequestMapping(value = "/jsonTest", method = RequestMethod.GET)
	public HashMap<String, Object> jsonTest(Locale locale) {

		logger.info("jsonTest");

		// your logic

		HashMap<String, Object> subHashmap1 = new HashMap<String, Object>();

		subHashmap1.put("sub1Key", "sub1Value");
		subHashmap1.put("sub2Key", "sub2Value");
		subHashmap1.put("sub3Key", "sub3Value");

		HashMap<String, Object> subHashmap2 = new HashMap<String, Object>();

		subHashmap2.put("sub11Key", "한글 테스트");
		subHashmap2.put("sub21Key", "sub22Value");
		subHashmap2.put("sub31Key", "sub33alue");
		
		subHashmap1.put("sub4Key", subHashmap2);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("ApplicatinKey", "0001");
		hashmap.put("readDate", formattedDate);
		
		hashmap.put("KEY2", "YES2");
		hashmap.put("KEY3", "YES3");
		hashmap.put("KEY4", subHashmap1);

		return hashmap;
	}
	
	
	
	 @RequestMapping(value = "/sqlTest", method = RequestMethod.GET)
     public ModelAndView sqlTest(Locale locale, Model model) {
             logger.info("Welcome home! The client locale is {}.", locale);
             // 메시지 모델에 추가.
             String sMessage = "스프링+아이바티스 첫만남. I Love Spring Framework!";
             model.addAttribute("sMessage", sMessage);
             
             // 날짜 부분 출력 및 모델에 추가
             Date date = new Date();
             DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
             String formattedDate = dateFormat.format(date);
             model.addAttribute("serverTime", formattedDate);
             
             // mybatis를 활용 db조회 모델에 추가
             HashMap<String, String> executeQuery = new HashMap<String, String>();
             executeQuery.put("name", "shin");
             List<HashMap<String, String>> resultSet = sqlSession.selectList("userControlMapper.R01", executeQuery);
             model.addAttribute("rs", resultSet);
             
             System.out.print(model.toString());
             

             // view에 모델 넘겨 넘겨
             ModelAndView mav = new ModelAndView("sqltest", "model", model);
             return mav;
     }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
