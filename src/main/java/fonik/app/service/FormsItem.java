package fonik.app.service;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FormsItem{

	@JsonProperty("form")
	private String form;

	@JsonProperty("tags")
	private List<String> tags;

	public void setForm(String form){
		this.form = form;
	}

	public String getForm(){
		return form;
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
			"FormsItem{" + 
			"form = '" + form + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}