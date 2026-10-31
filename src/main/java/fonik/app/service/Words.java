package fonik.app.service;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Words{

	@JsonProperty("entries")
	private List<EntriesItem> entries;

	@JsonProperty("edition")
	private String edition;

	@JsonProperty("word")
	private String word;

	public void setEntries(List<EntriesItem> entries){
		this.entries = entries;
	}

	public List<EntriesItem> getEntries(){
		return entries;
	}

	public void setEdition(String edition){
		this.edition = edition;
	}

	public String getEdition(){
		return edition;
	}

	public void setWord(String word){
		this.word = word;
	}

	public String getWord(){
		return word;
	}

	@Override
 	public String toString(){
		return 
			"Words{" + 
			"entries = '" + entries + '\'' + 
			",edition = '" + edition + '\'' + 
			",word = '" + word + '\'' + 
			"}";
		}
}