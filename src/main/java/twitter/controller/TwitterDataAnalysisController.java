package twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twitter.data.TwitterData;
import twitter.sentiment.SentimentAnalysis;
import twitter.service.TwitterService;

@RestController
public class TwitterDataAnalysisController {
	
	@Autowired
	TwitterService twitterService;
	
	@Autowired
	TwitterData twitterData;
	
	@Autowired
	SentimentAnalysis sentimentAnalysis;

	@RequestMapping("/test")
	public String test(){
		return "tested";
	}

	@RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
	public String updateTweet(){
		this.twitterService.updateStatus("updated");
		return "twitterUpdated";
	}
	
	@RequestMapping(value = "/fetchTweets", method = RequestMethod.GET)
	public void fetchTweets(){
		this.twitterService.fetchTweets();
	}
	
	@RequestMapping(value = "/writeToFile", method = RequestMethod.GET)
	public String writeTweetsToFile(){
		this.twitterData.writeDataToFile();
		return "written to file";
	}
	
	@RequestMapping(value = "/readFromFile", method = RequestMethod.GET)
	public String readFromFile(){
		this.sentimentAnalysis.getText();
		return "read from file";
	}
	
	@RequestMapping(value = "/checkSentiment", method = RequestMethod.GET)
	public String checkSentiment(){
		this.sentimentAnalysis.checkText();
		return "sentiment checked";
	}
}

