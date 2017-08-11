package twitter.domain;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TwitterDomain {

	private Boolean debug;

	private static Oauth oauth = new Oauth();

	public void setDebug(Boolean value){
		this.debug = value;
	}

	public Boolean getDebug(){
		return debug;
	}
	
	public void setOauth(Oauth oauth){
		this.oauth = oauth;
	}
	
	public Oauth getOauth(){
		return oauth;
	}

	public static class Oauth{
		private String accessToken;
		private String accessTokenSecret;
		private String consumerKey;
		private String consumerSecret;

		public void setAccessToken(String accessToken){
			this.accessToken = accessToken;
		}

		public String getAccessToken(){
			return accessToken;
		}

		public void setAccessTokenSecret(String accessTokenSecret){
			this.accessTokenSecret = accessTokenSecret;
		}

		public String getAccessTokenSecret(){
			return accessTokenSecret;
		}

		public void setConsumerKey(String consumerKey){
			this.consumerKey = consumerKey;
		}

		public String getConsumerKey(){
			return consumerKey;
		}

		public void setConsumerSecret(String consumerSecret){
			this.consumerSecret = consumerSecret;
		}

		public String getConsumerSecret(){
			return consumerSecret;
		}
	}
}
