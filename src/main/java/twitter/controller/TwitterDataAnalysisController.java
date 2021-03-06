package twitter.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twitter.data.SaveData;
import twitter.service.sentiment.Sentiment;
import twitter.service.sentiment.SentimentAnalysis;
import twitter.service.fetch.TwitterData;

@RestController
public class TwitterDataAnalysisController {

	private static final Logger logger = LoggerFactory.getLogger(TwitterDataAnalysisController.class);

	@Autowired
	TwitterData twitterData;

	@Autowired
	SaveData saveData;

	@Autowired
	SentimentAnalysis sentimentAnalysis;

	@RequestMapping(value = "/fetchTweets", method = RequestMethod.GET)
	public ResponseEntity<?> fetchTweets(){
		logger.info("Fetching all tweets...");
		List<String> tweets = this.twitterData.fetchTweets();
		return new ResponseEntity<List<String>>(tweets, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveTweetsToFile", method = RequestMethod.GET)
	public ResponseEntity<?> writeTweetsToFile(){
		logger.info("Saving all tweets to file...");
		this.saveData.writeDataToFile();
		return new ResponseEntity<String>("Tweets saved to file", HttpStatus.OK);
	}

	@RequestMapping(value = "/checkSentiment", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Sentiment>> checkSentiment(){
		logger.info("Analyzing sentiment...");
		Map<String, Sentiment> sentiments = this.sentimentAnalysis.checkTweets();
		return new ResponseEntity<Map<String, Sentiment>>(sentiments, HttpStatus.OK);
	}
}

