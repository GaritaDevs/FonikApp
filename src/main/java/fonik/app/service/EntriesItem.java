package fonik.app.service;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntriesItem{

	@JsonProperty("senses")
	private List<SensesItem> senses;

	@JsonProperty("forms")
	private List<FormsItem> forms;

	public void setSenses(List<SensesItem> senses){
		this.senses = senses;
	}

	public List<SensesItem> getSenses(){
		return senses;
	}

	public void setForms(List<FormsItem> forms){
		this.forms = forms;
	}

	public List<FormsItem> getForms(){
		return forms;
	}

	@Override
 	public String toString(){
		return 
			"EntriesItem{" + 
			"senses = '" + senses + '\'' + 
			",forms = '" + forms + '\'' + 
			"}";
		}
}