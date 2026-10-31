package fonik.app.service;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SensesItem{

	@JsonProperty("glosses")
	private List<String> glosses;

	@JsonProperty("tags")
	private List<String> tags;

	public void setGlosses(List<String> glosses){
		this.glosses = glosses;
	}

	public List<String> getGlosses(){
		return glosses;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"SensesItem{" + 
			"glosses = '" + glosses + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}