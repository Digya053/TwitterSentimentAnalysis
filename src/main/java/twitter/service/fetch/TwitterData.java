package twitter.service.fetch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter.configuration.TwitterConfiguration;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterData {

	@Autowired
	TwitterConfiguration twitterConfiguration;

	public List<String> fetchTweets(){
		Twitter twitter = this.twitterConfiguration.twitter();
		List<Status> statuses = null;
		List<String> tweets = new ArrayList<String>();
		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		for (Status status : statuses) {
			tweets.add(status.getUser().getName() + " : " +
					status.getText());
		}
		return tweets;
	}

}
