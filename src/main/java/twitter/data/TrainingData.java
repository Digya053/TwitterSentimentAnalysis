package twitter.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TrainingData {

	public List<String> positive(){
		List<String> positiveValues = new ArrayList<>();
		positiveValues.add("good");
		positiveValues.add("happy");
		positiveValues.add(":)");
		positiveValues.add(":D");
		positiveValues.add("positive");
		positiveValues.add("love");
		positiveValues.add("pray");

		return positiveValues;
	}

	public List<String> negative(){
		List<String> negativeValues = new ArrayList<>();
		negativeValues.add("hard");
		negativeValues.add("slow");
		negativeValues.add("bad");
		negativeValues.add("sad");
		negativeValues.add("negative");
		negativeValues.add(":(");
		negativeValues.add(":'(");

		return negativeValues;
	}

}
