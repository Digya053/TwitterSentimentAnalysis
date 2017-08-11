package twitter.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter.service.fetch.TwitterData;

@Service
public class SaveData {

	@Autowired
	TwitterData twitterData;

	public void writeDataToFile(){
		List<String> tweets = this.twitterData.fetchTweets();

		BufferedWriter output = null;

		try {
			output = new BufferedWriter(new FileWriter("src/main/resources/tweet.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String tweet : tweets){
			try {
				output.write(tweet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(output !=null){
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
