package twitter.sentiment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter.data.TwitterData;
import twitter.service.TwitterService;
import twitter.trainingdata.TrainingData;

@Service
public class SentimentAnalysis {
	private static final Logger logger = LoggerFactory.getLogger(SentimentAnalysis.class);

	@Autowired
	TwitterData twitterData;

	@Autowired
	TwitterService twitterService;

	@Autowired
	TrainingData trainingData;


	public List<String> getText(){
		List<String> tweets = this.twitterService.fetchTweets();
		return tweets;
	}

	public Sentiment assignSentiment(String tweet){
		String[] tweetString = tweet.split("\\s+");
		for(int i = 0; i < tweetString.length; i++){
			if(this.trainingData.positive().contains(tweetString[i])){
				return Sentiment.POSITIVE;
			} else if(this.trainingData.negative().contains(tweetString[i])){
				return Sentiment.NEGATIVE;
			}
		}
		return Sentiment.NEUTRAL;
	}

	public void checkText(){
		List<String> tweets = this.getText();
		logger.info("Analysing sentiment of each tweet...");
		for(String tweet : tweets){
			Sentiment sentiment = this.assignSentiment(tweet);
			System.out.println(tweet + "  " + sentiment);
		}
	}
}
