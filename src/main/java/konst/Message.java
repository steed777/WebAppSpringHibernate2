package konst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;

    private String tag;
    public Message (){
    	
    }
public Message(String text, String tag){
	this.tag = tag;
	this.text = text;
}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {

		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTag() {

		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}