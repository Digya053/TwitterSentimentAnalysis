package twitter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import twitter4j.conf.ConfigurationBuilder;

import twitter.domain.TwitterDomain;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuthAuthorization;

@Configuration
public class TwitterConfiguration {

	@Autowired
	TwitterDomain twitterDomain;

	@Value("${spring.oauth.consumerKey}")
	private String consumerKey;

	@Value("${spring.oauth.consumerSecret}")
	private String consumerSecret;

	@Value("${spring.oauth.accessToken}")
	private String accessToken;

	@Value("${spring.oauth.accessTokenSecret}")
	private String accessTokenSecret;


	private TwitterFactory twitterFactory(){

		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(accessToken)
		.setOAuthAccessTokenSecret(accessTokenSecret);

		TwitterFactory tf = new TwitterFactory(cf.build());

		return tf;
	}

	public Twitter twitter(){
		TwitterFactory twitterFactory = this.twitterFactory();
		Twitter twitter = twitterFactory.getInstance();
		return twitter;
	}
}
