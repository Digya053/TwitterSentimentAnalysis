package twitter.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter.configuration.TwitterConfiguration;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterService {

	private static final Logger logger = LoggerFactory.getLogger(TwitterService.class);

	@Autowired
	TwitterConfiguration twitterConfiguration;

	public Status updateStatus(String latestStatus){
		Status status = null;
		try 
		{
			Twitter twitter = this.twitterConfiguration.twitter();
			status = twitter.updateStatus(latestStatus);

			System.out.println("Successfully updated the status to [" + status.getText() + "].");

		}catch (TwitterException e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<String> fetchTweets(){
		Twitter twitter = this.twitterConfiguration.twitter();
		List<Status> statuses = null;
		List<String> tweets = new ArrayList<String>();
		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		logger.info("Showing home timeline.");
		for (Status status : statuses) {
			logger.info(status.getUser().getName() + ":" +
					status.getText());
			tweets.add(status.getUser().getName() + " : " +
					status.getText());
		}
		return tweets;
	}
	
	

}
